package com.cihangll.model.users;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "USER")
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "password", nullable = false, length = 100)
	private String password;

	@Column(name = "first_name", nullable = false, length = 100)
	private String first_name;

	@Column(name = "last_name", nullable = false, length = 100)
	private String last_name;

	@Column(name = "email", nullable = false, length = 254)
	private String email;

	@Column(name = "creation_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDate;

	@ManyToOne
	private UserRole userRole;

	@ManyToOne
	private Group group;

	@PrePersist
	protected void onCreate() {
		creationDate = new Date();
	}

	public User() {
		super();
	}

	public User(String password, String first_name, String last_name, String email) {
		super();
		this.password = password;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public UserRole getUserRole() {
		return userRole;
	}

	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

}
