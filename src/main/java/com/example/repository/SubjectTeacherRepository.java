package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.DAO.SubjectTeacher;

public interface SubjectTeacherRepository extends CrudRepository<SubjectTeacher, Integer>  {

	public SubjectTeacher findByTeacherId(int teacherId);
}
