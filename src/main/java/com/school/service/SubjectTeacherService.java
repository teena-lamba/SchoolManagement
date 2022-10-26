package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.DAO.SubjectTeacher;
import com.school.repository.SubjectTeacherRepository;

@Service
public class SubjectTeacherService {

	@Autowired
	private SubjectTeacherRepository subjectTeacherService;
	public Optional<SubjectTeacher> getSubjectTeacherById(int id) {
		return subjectTeacherService.findById(id);
	}

	public List<SubjectTeacher> getAllSubjectTeacher(){
		return  (List<SubjectTeacher>) subjectTeacherService.findAll();
	}

	public void addSubjectTeacher(SubjectTeacher groups) {
		subjectTeacherService.save(groups);
	}

	public void deleteSubjectTeacher(int id) {
		subjectTeacherService.deleteById(id);
	}
}
