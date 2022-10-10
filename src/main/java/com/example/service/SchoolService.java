package com.example.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.example.DAO.Marks;
import com.example.DAO.SubjectTeacher;
import com.example.component.SchoolComponent;
import com.example.models.MarksBySubjectModel;
import com.example.models.MarksListModel;
import com.example.repository.MarksRepository;

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
