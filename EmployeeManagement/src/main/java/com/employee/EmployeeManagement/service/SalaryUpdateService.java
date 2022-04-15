package com.employee.EmployeeManagement.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeManagement.model.SalaryUpdate;
import com.employee.EmployeeManagement.repository.SalaryUpdateRepository;


@Service
public class SalaryUpdateService {

	@Autowired 
	private SalaryUpdateRepository salUpdateRepo;
	
	
	public void salaryUpdateLog(SalaryUpdate salUpdate)
	{
		salUpdateRepo.save(salUpdate);
	}


	public List<SalaryUpdate> getSalUpdateByEmpId(int employee_id) {
		// TODO Auto-generated method stub
		
		return salUpdateRepo.getSalUpdateByEmpId(employee_id);
	}


	
}
