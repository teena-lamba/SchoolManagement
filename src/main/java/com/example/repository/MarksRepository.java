package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.DAO.Marks;

@Repository
public interface MarksRepository extends JpaRepository<Marks, Integer> {
	//
	//	@Query("select "
	//			+ "sum(p.marks)  "
	//			+ "from Marks p where p.studentId =:studentId "
	//			+ "group by p.student_id")
	//	public int groupBy(@Param("studentId") int studentId );

}
