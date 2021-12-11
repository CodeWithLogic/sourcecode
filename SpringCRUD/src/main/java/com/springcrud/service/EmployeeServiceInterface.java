package com.springcrud.service;

import java.util.List;

import com.springcrud.entity.Employee;

public interface EmployeeServiceInterface {

	public Employee addEmployee(Employee employee);

	public List<Employee> getAllEmployees();

	public Employee getEmpById(Long empId);

	public void deleteEmpById(Long empId);

	

}
