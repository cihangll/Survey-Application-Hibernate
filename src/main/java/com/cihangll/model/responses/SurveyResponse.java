package com.cihangll.model.responses;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cihangll.model.surveys.Survey;

@Entity
@Table(name = "SURVEY_RESPONSE")
public class SurveyResponse {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "updated", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@Column(name = "started_at", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date started_at;

	@Column(name = "completed_at", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date completed_at;

	@ManyToOne
	private Survey survey;

	@ManyToOne
	private Respondent respondent;

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}

	public SurveyResponse() {
		super();
	}

	public SurveyResponse(Date started_at, Date completed_at) {
		super();
		this.started_at = started_at;
		this.completed_at = completed_at;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Date getStarted_at() {
		return started_at;
	}

	public void setStarted_at(Date started_at) {
		this.started_at = started_at;
	}

	public Date getCompleted_at() {
		return completed_at;
	}

	public void setCompleted_at(Date completed_at) {
		this.completed_at = completed_at;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public Respondent getRespondent() {
		return respondent;
	}

	public void setRespondent(Respondent respondent) {
		this.respondent = respondent;
	}

}
