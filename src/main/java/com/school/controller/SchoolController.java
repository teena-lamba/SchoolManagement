package com.school.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.school.DAO.Groups;
import com.school.DAO.Marks;
import com.school.DAO.Students;
import com.school.DAO.Subjects;
import com.school.component.GroupsController;
import com.school.component.SchoolComponent;
import com.school.models.MarksBySubjectModel;
import com.school.repository.SubjectsRepository;
import com.school.service.GroupsService;
import com.school.service.MarksService;
import com.school.service.StudentsService;
import com.school.service.SubjectService;

@RestController
@ComponentScan("com.*.*")
public class SchoolController {
	@Autowired
	private SchoolComponent schoolComponent;
	@Autowired
	private GroupsService groupsService;
	@Autowired
	private MarksService marksService;
	@Autowired
	private StudentsService studentsService;
	@Autowired
	private SubjectService subjectService;

	@GetMapping( "/student/{id}/marks")
	public long getStudentMarks(@PathVariable("id") int id) {
		return schoolComponent.getStudentMarks(id);
	}

	@GetMapping( "/teacher/{id}")
	public long getCountStudentsWithTeacherId(@PathVariable("id") int teacherId) {
		return schoolComponent.getCountStudentsWithTeacherId(teacherId);
	}

	@GetMapping( "/students/{id}/marks")
	public List<MarksBySubjectModel> getListOfMarksForStudentsId(@PathVariable("id") int studentId) {
		return schoolComponent.getListOfMarksForStudentsId(studentId);
	}

	@GetMapping("Groups/{id}")
	public Optional<Groups> getGroupsById(int id) {
		return groupsService.getGroupsById(id);
	}

	@GetMapping("Groups")
	public List<Groups> getAllGroups(){
		return  (List<Groups>) groupsService.getAllGroups();
	}

	@PostMapping("Groups")
	public void addGroups(@RequestBody Groups groups) {
		groupsService.addGroups(groups);
	}
	@PutMapping("Groups/{id}/{name}")
	public void updateGroups(int id, String name) {
		groupsService.updateGroups(id, name);
		
	}
	@DeleteMapping("Groups/{id}")
	public void deleteGroup(int id) {
		groupsService.deleteGroup(id);
	}
	@GetMapping("Marks/{id}")
	public Optional<Marks> getMarksById(int id) {
		return marksService.getMarksById(id);
	}
	@GetMapping("Marks")
	public List<Marks> getAllMarks(){
		return  marksService.getAllMarks();
	}

	@PostMapping("Marks")
	public void addMarks(@RequestBody Marks groups) {
		marksService.addMarks(groups);
	}
	@PutMapping("Marks/{id}/{name}")
	public void updateMarks(int id, int marks) {
		 marksService.updateMarks(id, marks);
		
	}

	@DeleteMapping("Marks/{id}")
	public void deleteMarks(int id) {
		marksService.deleteMarks(id);
	}
	
	@GetMapping("Students/{id}")
	public Optional<Students> getStudentsById(int id) {
		return studentsService.getStudentsById(id);
	}

	@GetMapping("Students")
	public List<Students> getAllStudents(){
		return  (List<Students>) studentsService.getAllStudents();
	}
	@PostMapping("Students")
	public void addStudents(@RequestBody Students groups) {
		studentsService.addStudents(groups);
	}
	@PutMapping("Students/{id}/{name}")
	public void updateStudents(int id, String name) {
		studentsService.updateStudents(id, name);
		
	}

	@DeleteMapping("Students/{id}")
	public void deleteStudents(int id) {
		studentsService.deleteStudents(id);
	}


	@GetMapping("Subjects/{id}")
	public Optional<Subjects> getSubjectsById(int id) {
		return subjectService.getSubjectsById(id);
	}

	@GetMapping("Subjects")
	public List<Subjects> getAllSubjects(){
		return  (List<Subjects>) subjectService.getAllSubjects();
	}

	@PostMapping("Subjects")
	public void addSubjects(@RequestBody Subjects groups) {
		subjectService.addSubjects(groups);
	}

	@PutMapping("Subjects/{id}/{name}")
	public void updateSubjects(int id, String name) {
		 subjectService.updateSubjects(id, name);
		
	}

	@DeleteMapping("Subjects/{id}")
	public void deleteSubjects(int id) {
		subjectService.deleteSubjects(id);
	}
	
	
	
	
	
	
	
	

}
