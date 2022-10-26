package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.DAO.Subjects;
import com.school.repository.SubjectsRepository;

@Service
public class SubjectService {

	@Autowired
	public SubjectsRepository subjectsRepository;

	public Optional<Subjects> getSubjectsById(int id) {
		return subjectsRepository.findById(id);
	}

	public List<Subjects> getAllSubjects(){
		return  (List<Subjects>) subjectsRepository.findAll();
	}

	public void addSubjects(Subjects groups) {
		subjectsRepository.save(groups);
	}
	public void updateSubjects(int id, String name) {
		Optional<Subjects> group = subjectsRepository.findById(id);
		if(group.isPresent()) {
			Subjects g = group.get();
			g.setTitle(name);
			subjectsRepository.save(g);
		}
	}
	public void deleteSubjects(int id) {
		subjectsRepository.deleteById(id);
	}
}
