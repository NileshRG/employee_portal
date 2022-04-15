package com.employee.EmployeeManagement.service;


import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.EmployeeManagement.model.Salary;
import com.employee.EmployeeManagement.repository.SalaryRepository;


@Service
public class SalaryService {

	
	@Autowired
	private SalaryRepository salrepo;
	
	public void saveSalary(Salary sal)
	{
		salrepo.save(sal);
	}

	public List<Salary> ListAll() {
		// TODO Auto-generated method stub
		
		return salrepo.findAll();
	}
	public void update(int id,Salary sal)
	{
		int salId=getSalaryId(id);
		sal.setEmployeeId(id);
		sal.setSalaryId(salId);
		salrepo.save(sal);
		
	}
	public int getSalaryId(int empid)
	{
		return salrepo.getSalaryId(empid);
	}

	public Optional<Salary> findByEmpId(int employee_id) {
		// TODO Auto-generated method stub
		Optional<Salary> salOptList=salrepo.findByEmpId(employee_id);
//		List<Salary> salList=new ArrayList<>();
//		salOptList.ifPresent(salList::add);
		
		
		return salOptList;
	}
}

