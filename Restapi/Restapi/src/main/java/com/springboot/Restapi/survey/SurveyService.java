package com.springboot.Restapi.survey;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class SurveyService {

	private static List<Survey> surveys = new ArrayList<>();

	static {
		Question question1 = new Question("Question1", "Most Popular Cloud Platform Today",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "AWS");
		Question question2 = new Question("Question2", "Fastest Growing Cloud Platform",
				Arrays.asList("AWS", "Azure", "Google Cloud", "Oracle Cloud"), "Google Cloud");
		Question question3 = new Question("Question3", "Most Popular DevOps Tool",
				Arrays.asList("Kubernetes", "Docker", "Terraform", "Azure DevOps"), "Kubernetes");

		List<Question> questions = new ArrayList<>(Arrays.asList(question1, question2, question3));

		Survey survey = new Survey("Survey1", "My Favorite Survey", "Description of the Survey", questions);

		surveys.add(survey);
	}

	public List<Survey> retrieveAllSurveys() {

		return surveys;
	}

	public Survey retrieveSurveyById(String id) {

		Predicate<? super Survey> predicate = survey -> survey.getId().equals(id);
		Optional<Survey> optionalSurvey = surveys.stream().filter(survey -> survey.getId().equals(id)).findFirst();
		return optionalSurvey.isEmpty() ? null : optionalSurvey.get();
	}

	public List<Question> retrieveallQuestions(String id) {
		Survey survey = retrieveSurveyById(id);
		if (survey == null)
			return null;
		return survey.getQuestion();
	}

	public Question retrievetheQuestion(String id, String questionid) {

		List<Question> question = retrieveallQuestions(id);

		if (question == null)
			return null;

		Optional<Question> optional = question.stream().filter(q -> q.getId().equalsIgnoreCase(questionid)).findFirst();

		if (optional.isEmpty())
			return null;
		return optional.get();
	}

	public String addNewSurveyQuestion(String id, Question question) {

		System.out.println("success");
		List<Question> questions = retrieveallQuestions(id);
		SecureRandom secureRandom = new SecureRandom();

		String randomid = new BigInteger(32, secureRandom).toString();
		question.setId(randomid);
		questions.add(question);
		return question.getId();
	}

	public String deleteSurveyQuestion(String surveyId, String questionId) {

		List<Question> surveyQuestions = retrieveallQuestions(surveyId);

		if (surveyQuestions == null)
			return null;

		Predicate<? super Question> predicate = q -> q.getId().equalsIgnoreCase(questionId);
		boolean removed = surveyQuestions.removeIf(predicate);

		if (!removed)
			return null;

		return questionId;
	}

	public void updateSurveyQuestion(String surveyId, String questionId, Question question) {
		List<Question> questionsurvey = retrieveallQuestions(surveyId);
		questionsurvey.removeIf(q -> q.getId().equals(questionId));
		questionsurvey.add(question);

	}

}
