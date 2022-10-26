package com.school.repository;

import org.springframework.data.repository.CrudRepository;

import com.school.DAO.SubjectTeacher;

public interface SubjectTeacherRepository extends CrudRepository<SubjectTeacher, Integer>  {

	public SubjectTeacher findByTeacherId(int teacherId);
}
