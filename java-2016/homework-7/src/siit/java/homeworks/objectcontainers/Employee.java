package siit.java.homeworks.objectcontainers;

public class Employee implements Comparable<Employee> {

	private String name;
	private String role;
	private int seniority;
	private boolean parkingSpace;

	/**
	 * Constructor for a new employee.
	 */
	public Employee() {
	}

	/**
	 * Constructor for new employee with parameters
	 * 
	 * @param name
	 *            name of the employee
	 * @param role
	 *            role of the employee
	 * @param seniority
	 *            time since employee was hired
	 * @param parkingSpace
	 *            defines if the employee has parking space
	 */
	public Employee(String name, String role, int seniority, boolean parkingSpace) {
		this.name = name;
		this.role = role;
		this.seniority = seniority;
		this.parkingSpace = parkingSpace;

	}

	/**
	 * Getter for name
	 * 
	 * @return name the name of the employee.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for role
	 * 
	 * @return role the role of the employee.
	 */
	public String getRole() {
		return role;
	}

	/**
	 * Setter for role
	 */
	public void setRole(String role) {
		this.role = role;
	}

	/**
	 * Getter for seniority of the employee.
	 * 
	 * @return seniority
	 */
	public int getSeniority() {
		return seniority;
	}

	/**
	 * Setter for seniority.
	 */
	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	/**
	 * Getter for verifying if employee has parking space.
	 * 
	 * @return parkingSpace true or false
	 */
	public boolean hasParkingSpace() {
		return parkingSpace;
	}

	/**
	 * Setter for parking space of employee.
	 * 
	 * @param parkingSpace
	 */

	public void setParkingSpace(boolean parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	@Override
	public int compareTo(Employee employee) {

		return 0;
	}
}
