package com.cihangll.model.responses;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.cihangll.model.questions.Question;

@Entity
@Table(name = "RESPONSE")
public class Response {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "answer", nullable = false, length = 1000)
	private String answer;

	@ManyToOne
	private SurveyResponse surveyResponse;

	@ManyToOne
	private Question question;

	@ManyToOne
	private Respondent respondent;

	public Response() {
		super();
	}

	public Response(String answer) {
		super();
		this.answer = answer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public SurveyResponse getSurveyResponse() {
		return surveyResponse;
	}

	public void setSurveyResponse(SurveyResponse surveyResponse) {
		this.surveyResponse = surveyResponse;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Respondent getRespondent() {
		return respondent;
	}

	public void setRespondent(Respondent respondent) {
		this.respondent = respondent;
	}

}
