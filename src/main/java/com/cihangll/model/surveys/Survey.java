package com.cihangll.model.surveys;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.cihangll.model.users.Group;

@Entity
@Table(name = "SURVEY")
public class Survey {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "description", nullable = false, length = 1000)
	private String description;

	@Column(name = "opening_time", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date opening_time;

	@Column(name = "updated", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated;

	@ManyToOne
	private Group group;

	@PrePersist
	protected void onCreate() {
		opening_time = new Date();
	}

	@PreUpdate
	protected void onUpdate() {
		updated = new Date();
	}

	public Survey() {
		super();
	}

	public Survey(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getOpening_time() {
		return opening_time;
	}

	public void setOpening_time(Date opening_time) {
		this.opening_time = opening_time;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

}
