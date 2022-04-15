package com.employee.EmployeeManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.employee.EmployeeManagement.model.SalaryUpdate;


@Repository
public interface SalaryUpdateRepository extends JpaRepository<SalaryUpdate,Integer> {

	@Query(value="select * from salary_update where employee_id= :employee_id",nativeQuery=true)
	List<SalaryUpdate> getSalUpdateByEmpId(int employee_id);

}