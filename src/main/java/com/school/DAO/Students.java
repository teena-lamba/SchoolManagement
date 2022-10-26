package com.school.DAO;

import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Students")
public class Students {
	@Id
	@Column(name = "student_id")
	private int studentId;

	@Column(name = "first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "students", cascade = CascadeType.ALL)
	private List<Marks> marksList;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL,optional=false)
	@JoinColumn(name = "group_id", referencedColumnName="group_id")
	private Groups groups;


	public Groups getGroups() {
		return groups;
	}
	public void setGroups(Groups groups) {
		this.groups = groups;
	}
	public List<Marks> getMarksList() {
		return marksList;
	}
	public void setMarksList(List<Marks> marksList) {
		this.marksList = marksList;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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


}
