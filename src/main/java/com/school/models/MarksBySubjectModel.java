package com.school.models;

import java.util.List;

public class MarksBySubjectModel {

	private String subjectName;
	private List<MarksListModel> marksListModels;

	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public List<MarksListModel> getMarksListModels() {
		return marksListModels;
	}
	public void setMarksListModels(List<MarksListModel> marksListModels) {
		this.marksListModels = marksListModels;
	}


}
