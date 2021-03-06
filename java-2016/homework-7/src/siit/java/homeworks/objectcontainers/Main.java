package siit.java.homeworks.objectcontainers;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		CompanyManagementSystem cmp = new CompanyManagementSystem();

		Employee a = new Employee("Raj", "Junior Developer", 3, false);
		Employee b = new Employee("Samir", "Junior Developer", 2, false);
		Employee c = new Employee("Sandep", "manager", 2, true);
		cmp.addEmployee(a);
		cmp.addEmployee(b);
		cmp.addEmployee(c);

		for (Entry<Integer, Employee> entry : cmp.getEmployeesWithoutParking().entrySet()) {
			System.out.println(entry.getKey() + "/" + entry.getValue().getName());
		}

		System.out.println(cmp.getEmployeeList());
		cmp.printEmployeeByDepartment();

	}

}
