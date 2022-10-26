package com.school.component;

import java.util.List;

import org.springframework.stereotype.Component;

import com.school.DAO.Groups;
import com.school.models.MarksBySubjectModel;
@Component
public interface SchoolComponent {
	public long getStudentMarks(int studentId);
	public long getCountStudentsWithTeacherId(int teacherId);
	public List<MarksBySubjectModel> getListOfMarksForStudentsId(int studentsId);
}
