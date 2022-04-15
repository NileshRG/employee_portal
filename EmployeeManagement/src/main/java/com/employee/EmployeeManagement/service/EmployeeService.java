package com.employee.EmployeeManagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.employee.EmployeeManagement.model.Employee;
import com.employee.EmployeeManagement.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;



@Service
public class EmployeeService {

	
	@Autowired
	private EmployeeRepository emprepo;
	
	
	@org.springframework.cache.annotation.Cacheable(value="employee_details")
	public List<Employee> ListAll() {
		// TODO Auto-generated method stub
		System.out.println("In cache");
		return emprepo.findAll();
	}
	public void saveEmployee(Employee emp)
	{
		System.out.println("in save Employee clear cahcxhe");
		clearCache();
		emprepo.save(emp);
	}
	
	public int getLastSavedId()
	{
		return emprepo.getLastById();
	}
	

	public Optional<Employee> findById(int id) {
		// TODO Auto-generated method stub
		System.out.println("in find by"+id);
		
		return emprepo.findById(id);
	}
	//@CachePut(value="employee",key="employeeId")
	public void updateSalary(int employeeId,Employee empl) {
		// TODO Auto-generated method stub
		clearCache();
		System.out.println("in update Cache");
		empl.setEmployeeId(employeeId);
		emprepo.save(empl);
		
		
	}
	
	@Autowired
    private CacheManager cacheManager;      // autowire cache manager
    // clear all cache using cache manager
    
    public void clearCache(){
    	System.out.println("in clear cache");
        for(String name:cacheManager.getCacheNames()){
            cacheManager.getCache(name).clear();            // clear cache by name
        }
    }
    
    
	
	
}
