package com.school.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.school.DAO.Marks;
import com.school.DAO.SubjectTeacher;
import com.school.component.SchoolComponent;
import com.school.models.MarksBySubjectModel;
import com.school.models.MarksListModel;
import com.school.repository.MarksRepository;

@Service
public class SchoolService implements SchoolComponent{

	@Autowired
	public DAOService marksService;

	@Override
	public long getStudentMarks(int studentId) {
		// TODO Auto-generated method stub
		return marksService.getMarks(studentId);
	}

	@Override
	public long getCountStudentsWithTeacherId(int teacherId) {
		// TODO Auto-generated method stub
		return marksService.noOfStudentsFromTeacherId(teacherId);
	}
	@Override
	public List<MarksBySubjectModel> getListOfMarksForStudentsId(int studentsId) {
		List<SubjectTeacher> marksList = marksService.getMarksForParticularSubject(studentsId);
		List<MarksBySubjectModel> 	marksBySubjectModels = new ArrayList<>();
		if(marksList!=null) {

			for(SubjectTeacher subjectTeacher: marksList) {
				MarksBySubjectModel marksBySubjectModel = new MarksBySubjectModel();
				marksBySubjectModel.setSubjectName(subjectTeacher.getSubjects().getTitle());
				List<Marks> marks = subjectTeacher.getSubjects().getMarksList();
				List<MarksListModel> marksListModels = new ArrayList<>();
				for(Marks m : marks) {
					MarksListModel marksListModel = new MarksListModel();
					marksListModel.setMarks(m.getMarks());
					marksListModel.setDate(m.getDate());
					marksListModels.add(marksListModel);

				}
				marksBySubjectModel.setMarksListModels(marksListModels);
				marksBySubjectModels.add(marksBySubjectModel);
			}

		}
		return marksBySubjectModels;
	}
}
