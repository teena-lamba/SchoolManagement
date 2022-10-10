package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DAO.Groups;
import com.example.component.SchoolComponent;
import com.example.models.MarksBySubjectModel;
import com.example.service.SchoolService;

@RestController
@ComponentScan("com.*.*")
public class SchoolController {
	@Autowired
	private SchoolComponent schoolComponent;


	@GetMapping( "/getMarksByStudent")
	public long getStudentMarks(@RequestParam("studentId") int studentId) {
		return schoolComponent.getStudentMarks(studentId);
	}

	@GetMapping( "/getStudentsByTeacherId")
	public long getCountStudentsWithTeacherId(@RequestParam("teacherId") int teacherId) {
		return schoolComponent.getCountStudentsWithTeacherId(teacherId);
	}

	@GetMapping( "/getListOfMarksByStudentsId")
	public List<MarksBySubjectModel> getListOfMarksForStudentsId(@RequestParam("studentId") int studentId) {
		return schoolComponent.getListOfMarksForStudentsId(studentId);
	}


}
