package com.example.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.DAO.Students;

public interface StudentsRepository extends CrudRepository< Students, Integer>  {

}
