package com.employee.EmployeeManagement.model;



import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity(name="salary_update")
public class SalaryUpdate {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int updateId;
	
	public int employeeId;
	private float lastAnnualSalary;
	private float newAnnualSalary;
	
	
	private Date dateOfUpdation=new Date(System.currentTimeMillis());
	
	private String updated_by;
	public SalaryUpdate()
	{
		
	}
	public SalaryUpdate(int updateId, int employeeId, float lastAnnualSalary, float newAnnualSalary,
			Date dateOfUpdation, String updated_by) {
		super();
		this.updateId = updateId;
		this.employeeId = employeeId;
		this.lastAnnualSalary = lastAnnualSalary;
		this.newAnnualSalary = newAnnualSalary;
		this.dateOfUpdation = dateOfUpdation;
		this.updated_by = updated_by;
	}
	public int getUpdateId() {
		return updateId;
	}
	public void setUpdateId(int updateId) {
		this.updateId = updateId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public float getLastAnnualSalary() {
		return lastAnnualSalary;
	}
	public void setLastAnnualSalary(float lastAnnualSalary) {
		this.lastAnnualSalary = lastAnnualSalary;
	}
	public float getNewAnnualSalary() {
		return newAnnualSalary;
	}
	public void setNewAnnualSalary(float newAnnualSalary) {
		this.newAnnualSalary = newAnnualSalary;
	}
	public Date getDateOfUpdation() {
		
		return dateOfUpdation;
	}
	public void setDateOfUpdation(Date dateOfUpdation) {
		this.dateOfUpdation = dateOfUpdation;
	}
	public String getUpdated_by() {
		return updated_by;
	}
	public void setUpdated_by(String updated_by) {
		this.updated_by = updated_by;
	}
	
	

}
