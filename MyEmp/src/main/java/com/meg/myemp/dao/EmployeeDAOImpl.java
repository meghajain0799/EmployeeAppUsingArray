package com.meg.myemp.dao;

import java.util.Scanner;

import com.meg.myemp.db.EmployeeDB;
import com.meg.myemp.dto.Employee;
import com.meg.myemp.exception.InvalidEmployeeIdExcption;
import com.meg.myemp.exception.WrongSalaryException;

public class EmployeeDAOImpl implements IEmployeeDAO {

	Scanner sc = new Scanner(System.in);

	public boolean addEmployee(Employee e) throws WrongSalaryException {
		// SQL insert into employee ......

		// System.out.println(" =====>> DAO Impl employee "+e);
		return EmployeeDB.addEmployee(e);
	}

	public Employee[] getAllEmployees() {

		return EmployeeDB.employees;
	}

	// ============================================================

	public boolean editSalaryByEmployeeId(int id) throws InvalidEmployeeIdExcption, WrongSalaryException {
		boolean status = false;
		Employee arr[] = getAllEmployees();
		int count = EmployeeDB.count;
		for (int i = 0; i < count; i++) {

			if (id == arr[i].getEmployeeId()) {
				status = true;
				System.out.println("Enter the salary to be updated");
				int salary = sc.nextInt();
				try {
					if (salary <= 50000 && salary >= 5000) {
						arr[i].setSalary(salary);
					}

					else {
						status = false;
						throw new WrongSalaryException(salary);
					}

				} catch (WrongSalaryException e1) {
					System.out.println(e1);
				}

			}
		}
		if (status) {
			System.out.println("Salary updated");
		} else
			throw new InvalidEmployeeIdExcption();

		// throw new InvalidEmployeeIdExcption();

		return status;
	}

	public boolean editExpByEmployeeId(int id) throws InvalidEmployeeIdExcption {
		boolean status = false;
		Employee arr[] = getAllEmployees();
		int count = EmployeeDB.count;
		for (int i = 0; i < count; i++) {

			if (id == arr[i].getEmployeeId()) {
				status = true;
				System.out.println("Enter the experience to be updated");
				int exp = sc.nextInt();
				arr[i].setExp(exp);

			}
		}
		if (status) {
			System.out.println("Experience updated");
		} else
			throw new InvalidEmployeeIdExcption();

		// throw new InvalidEmployeeIdExcption();

		return status;

	}

	public Employee[] getEmployeeBySalary(int salary) {
		Employee arr[] = getAllEmployees();
		Employee[] arr1 = new Employee[EmployeeDB.count];
		int count = EmployeeDB.count;
		for (int i = 0; i < count; i++) {
			if (arr[i].getSalary() == salary) {

				arr1[i] = arr[i];
			}

		}
		return arr1;
	}

	public Employee[] getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		Employee arr[] = getAllEmployees();
		int count = EmployeeDB.count;
		Employee arr2[] = new Employee[count];
		int count1 = count;
		for (int i = 0; i < count1; i++) {
			if (arr[i].getSalary() >= salaryRangeMin && arr[i].getSalary() <= salaryRangeMax) {
				arr2[i] = arr[i];
			}
		}

		return arr2;

	}
}
