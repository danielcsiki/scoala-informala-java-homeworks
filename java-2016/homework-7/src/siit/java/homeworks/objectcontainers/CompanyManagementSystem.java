package siit.java.homeworks.objectcontainers;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;

public class CompanyManagementSystem {

	private Map<String, Set<Employee>> employeesList = new LinkedHashMap<>();
	private Map<Integer, Employee> employeesWithoutParking = new TreeMap<>(Collections.reverseOrder());;

	private Set<Employee> managers = new TreeSet<>();
	private Set<Employee> juniorDevelopers = new TreeSet<>();
	private Set<Employee> seniorDevelopers = new TreeSet<>();
	private Set<Employee> qaEngineers = new TreeSet<>();
	private Set<Employee> otherEmployees = new TreeSet<>();

	/**
	 * Adds an employee to the company management tool. Employee is assigned in
	 * a department collection, an all employee collection, and if it's the
	 * case, to a collection of employees without parking space.
	 */
	public void addEmployee(Employee employee) {
		if (employee.getRole().contains("Manager")) {
			managers.add(employee);
			employeesList.put("MANAGERS", managers);
		} else if (employee.getRole().contains("Junior")) {
			juniorDevelopers.add(employee);
			employeesList.put("JUNIOR_DEVELOPERS", juniorDevelopers);
		} else if (employee.getRole().contains("Senior")) {
			seniorDevelopers.add(employee);
			employeesList.put("SENIOR_DEVELOPERS", seniorDevelopers);
		} else if (employee.getRole().contains("QA")) {
			qaEngineers.add(employee);
			employeesList.put("QA_ENGINEERS", qaEngineers);
		} else {
			otherEmployees.add(employee);
			employeesList.put("OTHER", otherEmployees);
		}
		if (!employee.hasParkingSpace()) {
			employeesWithoutParking.put(employee.getSeniority(), employee);
		}
	}

	/**
	 * Getter for the list of all employees without parking space.
	 * 
	 * @return employeesWithoutParking Collection of all employees without an
	 *         assigned parking space.
	 */
	public Map<Integer, Employee> getEmployeesWithoutParking() {
		return employeesWithoutParking;
	}

	/**
	 * Getter for the list of all managers.
	 * 
	 * @return managers Collection of all manager employees.
	 */
	public Set<Employee> getManagers() {
		return managers;
	}

	/**
	 * Getter for the list of all junior developers.
	 * 
	 * @return juniorDevelopers Collection of all junior developer employees.
	 */
	public Set<Employee> getJuniorDevelopers() {
		return juniorDevelopers;
	}

	/**
	 * Getter for the list of all senior developers.
	 * 
	 * @return seniorDevelopers Collection of all senior developer employees.
	 */
	public Set<Employee> getSeniorDevelopers() {
		return seniorDevelopers;
	}

	/**
	 * Getter for the list of all employees from QA department.
	 * 
	 * @return qaEngineers Collection of all the employees from QA department
	 */
	public Set<Employee> getQAEngineers() {
		return qaEngineers;
	}

	/**
	 * Getter for the list of all employees from different departments.
	 * 
	 * @return otherEmployees Collection of all the employees from unclassified
	 *         departments.
	 */
	public Set<Employee> getOtherEmployees() {
		return otherEmployees;
	}

	/**
	 * Getter for the list of all employees.
	 * 
	 * @return employeeList Collection of all the employees.
	 */
	public Map<String, Set<Employee>> getEmployeeList() {
		return employeesList;
	}

	/**
	 * Prints the list of the employees, based on the dipartment they belong to
	 */
	public void printEmployeeByDepartment() {
		for (Map.Entry<String, Set<Employee>> entry : employeesList.entrySet()) {
			for (Employee value : entry.getValue()) {
				System.out.println(entry.getKey() + "/" + value.getName());
			}
		}
	}

}
