package com.example.component;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.DAO.Groups;
import com.example.models.MarksBySubjectModel;
@Component
public interface SchoolComponent {
	public long getStudentMarks(int studentId);
	public long getCountStudentsWithTeacherId(int teacherId);
	public List<MarksBySubjectModel> getListOfMarksForStudentsId(int studentsId);
}
