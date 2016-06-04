package test.siit.javahomeworks.objectcontainers;

import static org.junit.Assert.*;

import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import siit.java.homeworks.objectcontainers.CompanyManagementSystem;
import siit.java.homeworks.objectcontainers.Employee;

public class TestCompanyManagement {

	@Test
	public void whenEmployeesAreAdded_rolesListAreCorrect() {
		CompanyManagementSystem cmp = new CompanyManagementSystem();
		Employee a = new Employee("Raj", "Junior Developer", 3, false);
		Employee b = new Employee("Samir", "Junior Developer", 2, false);
		Employee c = new Employee("Sandeep", "Manager", 2, true);
		Employee d = new Employee("Jamal", "Cleaner", 2, false);
		cmp.addEmployee(a);
		cmp.addEmployee(b);
		cmp.addEmployee(c);
		cmp.addEmployee(d);
		System.out.println("juniors:");
		for (Employee e : cmp.getJuniorDevelopers()) {
			System.out.println(e.getName());
		}
		System.out.println("managers:");
		for (Employee e : cmp.getManagers()) {
			System.out.println(e.getName());
		}
		System.out.println("other employees:");
		for (Employee e : cmp.getOtherEmployees()) {
			System.out.println(e.getName());
		}

	}

	@Test
	public void listOfEmployeesWithoutParking_isSortedBySeniority() {
		CompanyManagementSystem cmp = new CompanyManagementSystem();
		Employee a = new Employee("Raj", "Junior Developer", 3, false);
		Employee b = new Employee("Samir", "Junior Developer", 2, false);
		Employee c = new Employee("Sandep", "manager", 2, true);
		cmp.addEmployee(a);
		cmp.addEmployee(b);
		cmp.addEmployee(c);

		for (Entry<Integer, Employee> entry : cmp.getEmployeesWithoutParking().entrySet()) {
			System.out.println("Seniority:" + entry.getKey() + " / Employee name: " + entry.getValue().getName());
		}

	}

	@Test
	public void listOfEmployeesByDepartment() {
		CompanyManagementSystem cmp = new CompanyManagementSystem();
		Employee a = new Employee("Raj", "Junior Developer", 3, false);
		Employee b = new Employee("Samir", "Junior Developer", 2, false);
		Employee c = new Employee("Sandep", "manager", 2, true);
		cmp.addEmployee(a);
		cmp.addEmployee(b);
		cmp.addEmployee(c);

		cmp.printEmployeeByDepartment();

	}

}
