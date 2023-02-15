package com.sandeep.myFirstWebApp.Todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
	private TodoService todoService;
	

	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> todo = todoService.findByUser("sandeep");
		model.addAttribute("todo", todo);
		return "todos";
	}
	
	@RequestMapping(value="add-todos",method=RequestMethod.GET)
	public String showNewTodo(ModelMap model ) {
		String username = (String)model.get("name");
		Todo todo=new Todo(0,username,"Default",LocalDate.now().plusYears(4),false);
		model.put("todo", todo);
		return "todo";
	}
	
	
	@RequestMapping(value="add-todos",method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = (String)model.get("name");
		todoService.addTodo(username, todo.getDiscription(),todo.getLocaldate(),false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-Todo")
	public String deleteTodo(@RequestParam int id) {
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
		
	@RequestMapping(value="update-Todo",method=RequestMethod.GET)
	public String showUpdateTodo(ModelMap model,@RequestParam int id ) {
		
		Todo todo=todoService.findById(id);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="update-Todo",method=RequestMethod.POST)
	public String updateNewTodo(ModelMap model, @Valid Todo todo,BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		String username = (String)model.get("name");
		todo.setUsername(username);
		todoService.updateTodo(todo);
		return "redirect:list-todos";
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

