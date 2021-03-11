package com.meg.myemp.db;

import com.meg.myemp.dto.Employee;
//import com.meg.myemp.exception.*;
import com.meg.myemp.service.EmployeeServiceImpl;
import com.meg.myemp.service.IEmployeeService;

import java.util.Scanner;

public class EmployeeDB {

	static IEmployeeService empService = new EmployeeServiceImpl();
	public static Employee employees[] = new Employee[100];

	static Scanner sc = new Scanner(System.in);
	public static int count = 0;

	static {

		employees[count++] = new Employee(101, "ramesh", 8, 7000);
		employees[count++] = new Employee(102, "suresh", 2, 7000);
		employees[count++] = new Employee(103, "rakesh", 1, 7000);
		employees[count++] = new Employee(104, "lokesh", 5, 7000);

	}

	public static boolean addEmployee(Employee e) {

		employees[count++] = e;

		return true;
	}

	public static int getCount()
	{
		return count;
	}

}// end of class
