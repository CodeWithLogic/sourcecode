package com.springcrud.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springcrud.entity.Employee;

@Repository
public interface EmployeeCRUDRepo extends JpaRepository<Employee, Long> {

}
