package com.sandeep.myFirstWebApp.Todo;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
@Entity
public class Todo {
	@Id
	private int id;
	private String username;
	@Size(min=5, message="Enter atleast 5 character")
	private String discription;
	private LocalDate localdate;
	private boolean done;
	
	
	public Todo() {
		
	}
	
	public Todo(int id, String username, String discription, LocalDate localdate, 
						boolean done) {
		super();
		this.id = id;
		this.username = username;
		this.discription = discription;
		this.localdate = localdate;
		this.done = done;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public LocalDate getLocaldate() {
		return localdate;
	}

	public void setLocaldate(LocalDate localdate) {
		this.localdate = localdate;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", username=" + username + ", discription=" + discription + ", localdate=" + localdate
				+ ", done=" + done + "]";
	}
	
	
	

}
