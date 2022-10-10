package com.example.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DAO.Groups;
import com.example.DAO.Marks;
import com.example.DAO.Students;
import com.example.DAO.SubjectTeacher;
import com.example.DAO.Subjects;
import com.example.repository.GroupsRepository;
import com.example.repository.MarksRepository;
import com.example.repository.StudentsRepository;
import com.example.repository.SubjectTeacherRepository;
import com.example.repository.SubjectsRepository;

@Service
public class DAOService{

	@Autowired
	private StudentsRepository studentsRepository;

	@Autowired
	private SubjectTeacherRepository subjectTeacherRepository;

	@Autowired
	private GroupsRepository groupsRepository;
	public long getMarks(int studentsId) {
		Optional<Students> students= studentsRepository.findById(studentsId);
		if(students.isPresent()) {
			List<Marks> markList= students.get().getMarksList();
			return markList.stream().mapToLong(s -> s.getMarks()).sum();
		}
		return 0;

	}

	public long noOfStudentsFromTeacherId(int teacherId) {
		SubjectTeacher subjeOptional = subjectTeacherRepository.findByTeacherId(teacherId);
		if(subjeOptional!=null) {
			Groups groups = subjeOptional.getGroups();
			Optional<Groups> groupsOptional = groupsRepository.findById(groups.getGroupId());
			if(groupsOptional.isPresent()) {
				List<Students> stuList= groupsOptional.get().getStudenList();
				return stuList.stream().map(s -> s.getStudentId()).count();
			}
		}
		return 0;
	}

	public List<SubjectTeacher> getMarksForParticularSubject(int subjectId) {
		Optional<Students> students= studentsRepository.findById(subjectId);
		if(students.isPresent()) {
			Groups groups= students.get().getGroups();
			List<SubjectTeacher> subjectTeachers = groups.getSubjectTeachers();
			return subjectTeachers;
		}
		return null;

	}
}
