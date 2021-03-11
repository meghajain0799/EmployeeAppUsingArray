package com.meg.myemp.service;

import com.meg.myemp.dto.Employee;
import com.meg.myemp.exception.InvalidEmployeeIdExcption;
import com.meg.myemp.exception.WrongSalaryException;

public interface IEmployeeService {
	
	public boolean addEmployee(Employee e)throws WrongSalaryException;
	 
	 public boolean editSalaryByEmployeeId(int id)throws InvalidEmployeeIdExcption,WrongSalaryException;
	 
	 public boolean editExpByEmployeeId(int id)throws InvalidEmployeeIdExcption;
	 
	 public Employee[] getAllEmployees();
	 
	 public Employee[] getEmployeeBySalary(int salary);
	 
	 public Employee[] getEmployessBySalaryRange(int salaryRangeMin,int salaryRangeMax);

}
