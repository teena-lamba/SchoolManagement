package com.school.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.school.DAO.Students;

public interface StudentsRepository extends CrudRepository< Students, Integer>  {

}
