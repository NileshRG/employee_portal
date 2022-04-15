package com.employee.EmployeeManagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.employee.EmployeeManagement.model.Salary;



@Repository
public interface SalaryRepository extends JpaRepository<Salary,Integer> {

	
	
	
	@Query(value="select salary_id from salary where employee_id= :empid",nativeQuery=true)
	int getSalaryId(@Param("empid") int empid);
	
	
	@Query(value="select * from salary where employee_id= :employee_id",nativeQuery=true)
	Optional<Salary> findByEmpId(int employee_id);
}