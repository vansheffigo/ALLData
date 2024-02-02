package com.springboot.Restapi.survey;

import java.util.List;

public class Survey {

	private String id;
	private String description;
	private String title;
	private List<Question> question;

	public Survey(String id, String description, String title, List<Question> question) {
		super();
		this.id = id;
		this.description = description;
		this.title = title;
		this.question = question;
	}

	public String getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}

	public List<Question> getQuestion() {
		return question;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", description=" + description + ", title=" + title + ", question=" + question
				+ "]";
	}

}
