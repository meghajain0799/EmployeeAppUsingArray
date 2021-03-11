package com.meg.myemp.service;

import com.meg.myemp.dao.EmployeeDAOImpl;
import com.meg.myemp.dao.IEmployeeDAO;
import com.meg.myemp.db.EmployeeDB;
import com.meg.myemp.dto.Employee;
import com.meg.myemp.exception.InvalidEmployeeIdExcption;
import com.meg.myemp.exception.WrongSalaryException;

public class EmployeeServiceImpl implements IEmployeeService {
   // Animal a = new Dog();
	IEmployeeDAO dao;

	public EmployeeServiceImpl() {
		dao = new EmployeeDAOImpl();
	}

	public boolean addEmployee(Employee e) throws WrongSalaryException {
		
			//System.out.println(" ------------>> inside service "+e);
		
			if(e.getSalary()> 50000)
			{
				throw new WrongSalaryException();
			}
			else return dao.addEmployee(e);		
		
	}

	public Employee[] getAllEmployees() {

		return dao.getAllEmployees();
	}
	
	
	// ================================================================================

	public boolean editSalaryByEmployeeId(int id) throws InvalidEmployeeIdExcption,WrongSalaryException  {
		
	 return dao.editSalaryByEmployeeId(id);
}

	public boolean editExpByEmployeeId(int id) throws InvalidEmployeeIdExcption {
		// TODO Auto-generated method stub
		return dao.editExpByEmployeeId(id);
	}

	public Employee[] getEmployeeBySalary(int salary) {
		// TODO Auto-generated method stub
		
		return dao.getEmployeeBySalary(salary);
	}

	public Employee[] getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		// TODO Auto-generated method stub
		return dao.getEmployessBySalaryRange(salaryRangeMin, salaryRangeMax);
	}

}