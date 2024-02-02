package com.in28minutes.springboot.mysampleproject.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

import jakarta.validation.Valid;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int CountTodos = 0;

	static {
		todos.add(new Todo(++CountTodos, "in28minutes", "Learn AWS", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++CountTodos, "in28minutes", "LearnDevOps", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++CountTodos, "in28minutes", "Learn Full Stack Development", LocalDate.now().plusYears(1),
				false));
	}

	public List<Todo> findByUsername(String username) {
		return todos;
	}

	public void addTodo(String username, String description, LocalDate targetDate, boolean done) {

		todos.add(new Todo(++CountTodos, username, description, targetDate, done));
	}

	public void deleteById(int id) {
//		Predicate<? super Todo> predicate=todo->todo.getId()==id;
//		todos.removeIf(predicate);
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		todos.removeIf(predicate);
	}

	public Todo findById(int id) {
		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
		return todos.stream().filter(predicate).findFirst().get();

	}

	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteById(todo.getId());

		todos.add(todo);
	}
}
