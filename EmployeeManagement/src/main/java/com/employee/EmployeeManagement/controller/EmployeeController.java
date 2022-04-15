package com.employee.EmployeeManagement.controller;


import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employee.EmployeeManagement.model.Employee;
import com.employee.EmployeeManagement.model.Salary;
import com.employee.EmployeeManagement.model.SalaryUpdate;
import com.employee.EmployeeManagement.service.EmployeeService;
import com.employee.EmployeeManagement.service.SalaryService;
import com.employee.EmployeeManagement.service.SalaryUpdateService;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Controller
public class EmployeeController {

	@Autowired 
	private EmployeeService empService;
	
	@Autowired 
	private SalaryService salService;
	
	@Autowired
	private SalaryUpdateService salUpdateService;
	
	
	@GetMapping("/")
	public String homePage(Model model)
	{
		return "index";
	}
	
	@RequestMapping(value="/newEmployee")
	public String newEMployee(Model model)
	{
		model.addAttribute("employee",new Employee());
		model.addAttribute("salary",new Salary());
		return "newEmployee";
	}
	
	@RequestMapping(value="/saveEmployee",method= RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee emp,@ModelAttribute("salary") Salary sal)
	{
		System.out.println("in save Employee");
		System.out.println("in save Employee salary:"+sal.getHra()+" check "+emp.getSalary());
		empService.saveEmployee(emp);
		int e_id=empService.getLastSavedId();
		
		salService.saveSalary(new Salary(sal.getSalaryId(),e_id,sal.getBaseSalary(),sal.getHra(),sal.getCoa(),sal.getMed(),sal.getSpecialAllowance(),sal.getLta(),sal.getPf()));
		return "redirect:/";
	}
	
	@RequestMapping(value="/updateList")
	public String listForUpdate(Model model)
	{
		List<Employee> employeeList =empService.ListAll();
		model.addAttribute("employeeList",employeeList);
//		List<Salary> salaryList=salService.ListAll();
//		model.addAttribute("salList",salaryList);
		//Employee emp=new Employee();
		
		//System.out.println("salary=");
		return "updateList";
	}
	
	@GetMapping("/updateSalary/{employee_id}")
	public ModelAndView updateSalary(@PathVariable(name="employee_id") int id, Model model)
	{
		ModelAndView mav=new ModelAndView("updateSalary");
		java.util.Optional<Employee> empToUpdate=empService.findById(id);
		List<Employee> empToUpdateList= new ArrayList<>();
		
		empToUpdate.ifPresent(empToUpdateList::add);
		model.addAttribute("empList",empToUpdateList);
		model.addAttribute("employeeUpdateLog",new Employee());
		model.addAttribute("salary",new Salary());
		model.addAttribute("salLog",new SalaryUpdate());
		
		return mav;
	}
	
	@RequestMapping(value="/saveUpdatedSalary",method= RequestMethod.POST)
	public String saveUpdate(@ModelAttribute("employeeUpdateLog") Employee emp,@ModelAttribute("salaryUpdateLog") Salary sal,@ModelAttribute("salLog") SalaryUpdate salUpdate,int id,float currentSal,String fname,String lname,String desig,String address)
	{
		System.out.println("Update id"+id+"current"+currentSal+"lastName"+emp.getLastName());
		System.out.println("Name"+emp.getFirstName()+"chexk"+emp.getSalary()+"salary"+sal.getBaseSalary()+"saLog"+salUpdate.getUpdated_by()+"sal log curent"+salUpdate.getLastAnnualSalary());
		
		salUpdate.setEmployeeId(id);
		salUpdate.setLastAnnualSalary(currentSal);
		emp.setFirstName(fname);
		emp.setLastName(lname);
		emp.setDesignation(desig);
		emp.setAddress(address);
		//java.util.Optional<Employee> empList=empService.findById(id);
		//List<Employee> listEmp=new ArrayList<>();
		//empList.ifPresent(listEmp::add);
		empService.updateSalary(id, emp);
		
		//empService.updateSalary(id, emp);
		salService.update(id, sal);
		System.out.println("in check last salary"+salUpdate.getLastAnnualSalary());
		salUpdateService.salaryUpdateLog(new SalaryUpdate(salUpdate.getUpdateId(),salUpdate.getEmployeeId(),salUpdate.getLastAnnualSalary(),emp.getSalary(),salUpdate.getDateOfUpdation(),salUpdate.getUpdated_by()));
		
		//empService.updateSalary(salUpdate.getEmployeeId());
		
		return "redirect:/";
		
	}
	
	@RequestMapping(value="/salaryHistory/{employee_id}")
	public String viewSalaryHistory(Model model,@PathVariable(name="employee_id") int employee_id)
	{
		java.util.Optional<Employee> empOptList =empService.findById(employee_id);
		List<Employee> empList =new ArrayList<>();
		empOptList.ifPresent(empList::add);
		model.addAttribute("empList",empList);
		java.util.Optional<Salary> salOptList=salService.findByEmpId(employee_id);
		List<Salary> salaryList=new ArrayList<>();
		salOptList.ifPresent(salaryList::add);
		model.addAttribute("salaryList",salaryList);
		//salaryList.add((Salary) salService.findByEmpId(employee_id));
		//java.util.Optional<SalaryUpdate> salUpdateOptList=salUpdateService.getSalUpdateByEmpId(employee_id);
		List<SalaryUpdate> salUpdateList=salUpdateService.getSalUpdateByEmpId(employee_id);
		//salUpdateOptList.ifPresent(salUpdateList::add);
		model.addAttribute("salUpdateList",salUpdateList);
		return "salaryHistory";
	}
	
	@RequestMapping(value="/viewAll")
	public String viewAll(Model model)
	{
		List<Employee> listEmployee=empService.ListAll();
		model.addAttribute("empList", listEmployee);
		
		
		return "viewAll";
		
	}
	

	
	
}
