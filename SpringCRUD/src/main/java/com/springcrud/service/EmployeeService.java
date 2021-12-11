package com.springcrud.service;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springcrud.custom.exception.BusinessException;
import com.springcrud.entity.Employee;
import com.springcrud.repos.EmployeeCRUDRepo;

@Service
public class EmployeeService implements EmployeeServiceInterface {
	
	@Autowired
	private EmployeeCRUDRepo empCrud;

	@Override
	public Employee addEmployee(Employee employee) {
		if(employee.getName().isEmpty() || employee.getName().length()==0) {
			throw new BusinessException("601", "Please send a proper name, It's Blank");
		}
		try {
			Employee saveEmployee=empCrud.save(employee);
			return saveEmployee;
		} catch (IllegalArgumentException e) {
			throw new BusinessException("602", "Given Employee is null "+e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("603", "Something went wrong in Service Layer "+e.getMessage());
		}
	}

	@Override
	public List<Employee> getAllEmployees() {
		try {
			return empCrud.findAll();
		} catch (NullPointerException e) {
			throw new BusinessException("702", "The list is null "+e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("703", "Something went wrong in Service Layer "+e.getMessage());
		}
		
	}

	@Override
	public Employee getEmpById(Long empId) {
		if(empId==null) {
			throw new BusinessException("704", "Please send a proper ID, It's Blank");
		}
		try {
			return empCrud.findById(empId).get();
		} catch (NoSuchElementException e) {
			throw new BusinessException("705", "Given Employee ID is null "+e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("706", "Something went wrong in Service Layer "+e.getMessage());
		}
		
	}

	@Override
	public void deleteEmpById(Long empId) {
		try {
			if(empId==null) {
				throw new BusinessException("704", "Please send a proper ID, It's Blank");
			}
			empCrud.findById(empId).get();
		} catch (IllegalArgumentException e) {
			throw new BusinessException("705", "Given Employee ID is null "+e.getMessage());
		}catch (Exception e) {
			throw new BusinessException("706", "Something went wrong in Service Layer "+e.getMessage());
		}
		
		
	}

	
	

}
