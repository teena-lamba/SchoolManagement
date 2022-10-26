package com.example.School;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.school.controller.SchoolController;
import com.school.models.MarksBySubjectModel;

class SchoolTestCases {

	@Autowired
	private SchoolController schoolController;
	@Test
	void test1() {
		List<MarksBySubjectModel> list= schoolController.getListOfMarksForStudentsId(1);
		assertEquals(2, list.size());

	}
	@Test
	void test2() {
		long list= schoolController.getCountStudentsWithTeacherId(602);
		assertEquals(1, list);

	}
	@Test
	void test3() {
		long list= schoolController.getStudentMarks(1);
		assertEquals(350, list);

	}

}
