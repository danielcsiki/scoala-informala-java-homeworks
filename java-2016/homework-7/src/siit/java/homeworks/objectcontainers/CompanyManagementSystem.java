package siit.java.homeworks.objectcontainers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Map;


public class CompanyManagementSystem {
	
	private ArrayList<Employee> employeeList = new ArrayList<>();
	private Map<Integer, Employee> employeesWithoutParking =new TreeMap<>(Collections.reverseOrder());;
	
	private Set<Employee> managers = new TreeSet<>();
	private Set<Employee> juniorDevelopers = new TreeSet<>();
	private Set<Employee> seniorDevelopers = new TreeSet<>();
	private Set<Employee> qaEngineers = new TreeSet<>();
	private Set<Employee> otherEmployees = new TreeSet<>();
	
	public void addEmployee(Employee employee){
		if(employee.getRole().contains("Manager")){
			managers.add(employee);
		}else if(employee.getRole().contains("Junior")){
			juniorDevelopers.add(employee);				
		}else if(employee.getRole().contains("Senior")){
			seniorDevelopers.add(employee);
		}else if(employee.getRole().contains("QA")){
			qaEngineers.add(employee);
		}
		else{
			otherEmployees.add(employee);
		}
		employeeList.add(employee);
		if(!employee.hasParkingSpace()){
			employeesWithoutParking.put(employee.getSeniority(), employee);
		}
	}
	
	public Map<Integer, Employee> getEmployeesWithoutParking(){
		return employeesWithoutParking;
	}
	
	public Set<Employee> getManagers(){
		return managers;
	}
	
	public Set<Employee> getJuniorDevelopers(){
		return juniorDevelopers;
	}
	
	public Set<Employee> getSeniorDevelopers(){
		return seniorDevelopers;
	}
	
	public Set<Employee> getQAEngineers(){
		return qaEngineers;
	}
	
	public Set<Employee> getOtherEmployees(){
		return otherEmployees;
	}
	
	
	

}
