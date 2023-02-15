package com.sandeep.myFirstWebApp.Todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

@Controller
@SessionAttributes("name")
public class TodoControllerJpa {
	//private TodoService todoService;
	
	private TodoRespository repository;
	int count=5;

	public TodoControllerJpa( TodoRespository repository) {
		super();
		//this.todoService = todoService;
		this.repository=repository;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		String username=getLogggedIn(model);
		List<Todo> todo = repository.findByUsername(username);
		//List<Todo> todo = todoService.findByUser(username);
		model.addAttribute("todo", todo);
		return "todos";
	}

	private String getLogggedIn(ModelMap model) {
		return SecurityContextHolder.getContext().getAuthentication().getName();
	}
	
	@RequestMapping(value="add-todos",method=RequestMethod.GET)
	public String showNewTodo(ModelMap model ) {
		
		String username = getLogggedIn(model);
		Todo todo=new Todo(count++,username,"",LocalDate.now(),false);
		model.put("todo", todo);
		return "todo";
	}
	
	
	@RequestMapping(value="add-todos",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLogggedIn(model);
		todo.setUsername(username);
		todo.setId(todo.getId());
		repository.save(todo);
		//todoService.addTodo(username, todo.getDiscription(),todo.getLocaldate(),false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-Todo")
	public String deleteTodo(@RequestParam int id) {
		//todoService.deleteById(id);
		repository.deleteById(id);
		return "redirect:list-todos";
	}
		
	@RequestMapping(value="update-Todo",method=RequestMethod.GET)
	public String showUpdateTodo(ModelMap model,@RequestParam int id ) {
		
		//Todo todo=todoService.findById(id);
		Todo todo=repository.findById(id).get();
		
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-Todo",method=RequestMethod.POST)
	public String updateNewTodo(ModelMap model, @Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = getLogggedIn(model);
		todo.setUsername(username);
		repository.save(todo);
		//todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

