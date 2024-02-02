package com.springboot.Restapi.survey;

import java.net.URI;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class SurveyResource {

	private SurveyService surveyservice;

	public SurveyResource(SurveyService surveyservice) {
		super();
		this.surveyservice = surveyservice;
	}

	@RequestMapping("/surveys")
	public List<Survey> retrieveAllSurveys() {
		return surveyservice.retrieveAllSurveys();
	}

	@RequestMapping("/surveys/{id}")
	public Survey retrieveSurveyById(@PathVariable String id) {

		Survey survey = surveyservice.retrieveSurveyById(id);

		if (survey == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		return survey;
	}

	@RequestMapping("surveys/{id}/Questions/{Questionid}")
	public Question retrieveSpecificSurveyQuestion(@PathVariable String id, @PathVariable String Questionid) {

		System.out.println(id);
		Question question = surveyservice.retrievetheQuestion(id, Questionid);
		if (question == null)
			return null;
		return question;

	}

	@RequestMapping("/surveys/{surveyId}/questions")
	public List<Question> retrieveAllSurveyQuestions(@PathVariable String surveyId) {
		List<Question> questions = surveyservice.retrieveallQuestions(surveyId);

		if (questions == null)
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		return questions;
	}

	@RequestMapping(value = "/surveys/{id}/questions", method = RequestMethod.POST)
	public ResponseEntity<Object> addNewSurveyQuestion(@PathVariable String id, @RequestBody Question question) {
		System.out.println(id);

		String questionId = surveyservice.addNewSurveyQuestion(id, question);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{questionId}").buildAndExpand(questionId)
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.DELETE)

	public ResponseEntity<Object> deleteSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId) {
		surveyservice.deleteSurveyQuestion(surveyId, questionId);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/surveys/{surveyId}/questions/{questionId}", method = RequestMethod.PUT)

	public ResponseEntity<Object> updateSurveyQuestion(@PathVariable String surveyId, @PathVariable String questionId,
			@RequestBody Question question) {

		surveyservice.updateSurveyQuestion(surveyId, questionId, question);

		return ResponseEntity.noContent().build();
	}

}
