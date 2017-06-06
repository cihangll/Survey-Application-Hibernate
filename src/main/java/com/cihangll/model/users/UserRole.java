package com.cihangll.model.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_ROLE")
public class UserRole {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "name", nullable = false, length = 100)
	private String name;

	@Column(name = "description", nullable = false, length = 1000)
	private String description;

	@ManyToMany
	@JoinTable(name = "ROLE_PERMISSION", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "permission_id"))
	private List<Permission> permissions;

	public UserRole() {
		super();
	}

	public UserRole(String name, String description) {
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

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

}
