package com.cihangll.model.responses;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "RESPONDENT")
public class Respondent {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "first_name", nullable = false, length = 100)
	private String first_name;

	@Column(name = "last_name", nullable = false, length = 100)
	private String last_name;

	@Column(name = "email", nullable = false, length = 254)
	private String email;

	// @Column(name = "ip_address", nullable = false, length = 45)
	// private String ip_address;

	@Column(name = "creation_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@PrePersist
	protected void onCreate() {
		creationDate = new Date();
	}

	public Respondent() {
		super();
	}

	public Respondent(String first_name, String last_name, String email) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
