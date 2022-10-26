package com.school.service;

import java.util.List;
import java.util.Optional;

import javax.security.auth.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.school.DAO.Groups;
import com.school.DAO.Marks;
import com.school.DAO.Students;
import com.school.DAO.SubjectTeacher;
import com.school.DAO.Subjects;
import com.school.repository.GroupsRepository;
import com.school.repository.MarksRepository;
import com.school.repository.StudentsRepository;
import com.school.repository.SubjectTeacherRepository;
import com.school.repository.SubjectsRepository;

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
