package com.employee.EmployeeManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.EmployeeManagement.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

	@Query(value="select Max(employeeId) from employee")
	int getLastById();
	
	
	
	

}