package com.school.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.DAO.Groups;
import com.school.DAO.Marks;
import com.school.repository.MarksRepository;

@Service
public class MarksService {

	@Autowired
	private MarksRepository marksRepository;

	public Optional<Marks> getMarksById(int id) {
		return marksRepository.findById(id);
	}

	public List<Marks> getAllMarks(){
		return  marksRepository.findAll();
	}

	public void addMarks(Marks groups) {
		marksRepository.save(groups);
	}
	public void updateMarks(int id, int marks) {
		Optional<Marks> group = marksRepository.findById(id);
		if(group.isPresent()) {
			Marks g = group.get();
			g.setMarks(marks);
			marksRepository.save(g);
		}
	}
	public void deleteMarks(int id) {
		marksRepository.deleteById(id);
	}
}
