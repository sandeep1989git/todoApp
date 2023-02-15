package com.sandeep.myFirstWebApp.Todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int count = 1;
	static {
		todos.add(new Todo(count++, "name1", "java", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(count++, "name1", "dsa", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(count++, "name2", "algo", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUser(String user) {
		Predicate<? super Todo> predicate= l->l.getUsername().equalsIgnoreCase(user);
		return todos.stream().filter(predicate).toList();
		//return todos;
	}

	public Todo findById(int id) {
		/*
		 * for(Todo todo:todos) { if(todo.getId()==id) return todo; } return null;
		 */
		Todo todo = todos.stream().filter(a -> (a.getId() == id)).findFirst().get();
		return todo;
	}

	public void addTodo(String username, String discription, LocalDate date, boolean done) {
		todos.add(new Todo(count++, username, discription, date, done));
	}

	public void deleteById(int id) {
		todos.removeIf(a -> a.getId() == id);
	}

	public void updateById(int id, String discription) {
		int index = 0;
		for (int i = 0; i < todos.size(); i++) {
			if (todos.get(i).getId() == id) {
				index = i;
				break;
			}
		}
		todos.get(index).setDiscription(discription);
	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());
		todos.add(todo);
		
	}
	

}
