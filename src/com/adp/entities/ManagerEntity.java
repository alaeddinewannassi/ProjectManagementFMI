package com.adp.entities;

import java.util.Collection;

public class ManagerEntity extends UserEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;

	// @OneToMany(mappedBy="projectManager")
	private Collection<ProjectEntity> projects;

	private String jobTitle;
	private String phone;

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Collection<ProjectEntity> getProjects() {
		return projects;
	}

	public void setProjects(Collection<ProjectEntity> projects) {
		this.projects = projects;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public ManagerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

}
