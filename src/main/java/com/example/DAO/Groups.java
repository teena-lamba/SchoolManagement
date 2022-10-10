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
@Table(name = "Groups")
public class Groups {

	@Id
	@Column(name = "group_id")
	private int groupId;

	@Column(name = "name")
	private String name;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "groups", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Students> studenList;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "groups", cascade = CascadeType.ALL)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<SubjectTeacher> subjectTeachers;


	public List<SubjectTeacher> getSubjectTeachers() {
		return subjectTeachers;
	}

	public void setSubjectTeachers(List<SubjectTeacher> subjectTeachers) {
		this.subjectTeachers = subjectTeachers;
	}

	public List<Students> getStudenList() {
		return studenList;
	}

	public void setStudenList(List<Students> studenList) {
		this.studenList = studenList;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
