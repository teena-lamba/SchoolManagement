package com.example.DAO;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "Subjects")
public class Subjects {
	@Id
	@Column(name = "subject_id")
	private int subjectId;

	@Column(name = "title")
	private String title;

	@OneToMany( mappedBy = "subjects", cascade = CascadeType.ALL)

	private List<Marks> marksList;

	@OneToMany( mappedBy = "subjects", cascade = CascadeType.ALL)
	private List<SubjectTeacher> subjectTeachers;


	public List<Marks> getMarksList() {
		return marksList;
	}

	public void setMarksList(List<Marks> marksList) {
		this.marksList = marksList;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



}
