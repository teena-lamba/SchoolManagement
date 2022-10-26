package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.DAO.Marks;
import com.school.DAO.Students;
import com.school.repository.StudentsRepository;

@Service
public class StudentsService {

	@Autowired
	private StudentsRepository studentsRepository;
	public Optional<Students> getStudentsById(int id) {
		return studentsRepository.findById(id);
	}

	public List<Students> getAllStudents(){
		return  (List<Students>) studentsRepository.findAll();
	}

	public void addStudents(Students groups) {
		studentsRepository.save(groups);
	}
	public void updateStudents(int id, String name) {
		Optional<Students> group = studentsRepository.findById(id);
		if(group.isPresent()) {
			Students g = group.get();
			g.setFirstName(name);
			studentsRepository.save(g);
		}
	}
	public void deleteStudents(int id) {
		studentsRepository.deleteById(id);
	}
}
