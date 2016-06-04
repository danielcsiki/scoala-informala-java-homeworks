package siit.java.homeworks.objectcontainers;

public class Employee implements Comparable<Employee> {

	private String name;
	private String role;
	private int seniority;	
	private boolean parkingSpace;

	public Employee() {
	}

	public Employee(String name, String role, int seniority, boolean parkingSpace) {
		this.name = name;
		this.role = role;
		this.seniority = seniority;
		this.parkingSpace = parkingSpace;

	}
	
	
	public String getName() {
		return name;
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int getSeniority() {
		return seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public boolean hasParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(boolean parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	@Override
	public int compareTo(Employee emp) {
		if(this.seniority < emp.getSeniority()){
			return -1;
		}
		else if(this.seniority > emp.getSeniority()){
			return 1;
		}
		else if(getRole().contains("Manager")){
			return 1;
		}
		else if(!getRole().contains("Manager")){
			return -1;
		}
		return 0;
	}
}
