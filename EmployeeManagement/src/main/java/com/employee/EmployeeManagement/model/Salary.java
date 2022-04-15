package com.employee.EmployeeManagement.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="salary")
public class Salary {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int salaryId;
	
	private int employeeId;
	private float baseSalary;
	private float hra;
	private float coa;
	private float med;
	private float specialAllowance;
	private float lta;
	private float pf;
	
	public Salary()
	{
		
	}
	public Salary(int salaryId, int employeeId, float baseSalary, float hra, float coa, float med,
			float specialAllowance, float lta, float pf) {
		super();
		this.salaryId = salaryId;
		this.employeeId = employeeId;
		this.baseSalary = baseSalary;
		this.hra = hra;
		this.coa = coa;
		this.med = med;
		this.specialAllowance = specialAllowance;
		this.lta = lta;
		this.pf = pf;
	}
	public int getSalaryId() {
		return salaryId;
	}
	public void setSalaryId(int salaryId) {
		this.salaryId = salaryId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public float getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(float baseSalary) {
		this.baseSalary = baseSalary;
	}
	public float getHra() {
		return hra;
	}
	public void setHra(float hra) {
		this.hra = hra;
	}
	public float getCoa() {
		return coa;
	}
	public void setCoa(float coa) {
		this.coa = coa;
	}
	public float getMed() {
		return med;
	}
	public void setMed(float med) {
		this.med = med;
	}
	public float getSpecialAllowance() {
		return specialAllowance;
	}
	public void setSpecialAllowance(float specialAllowance) {
		this.specialAllowance = specialAllowance;
	}
	public float getLta() {
		return lta;
	}
	public void setLta(float lta) {
		this.lta = lta;
	}
	public float getPf() {
		return pf;
	}
	public void setPf(float pf) {
		this.pf = pf;
	}
	

}
