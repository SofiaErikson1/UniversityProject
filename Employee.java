import java.util.Comparator;

public class Employee {

	private String employeeID;
	private String name;
	private int salary;

	private Project project;
	
	public static int getLastEmployeeID() {
		return lastEmployeeID;
	}

	public static void setLastEmployeeID(int lastEmployeeID) {
		Employee.lastEmployeeID = lastEmployeeID;
	}

	private static int lastEmployeeID = 1001; // sets a unique employee ID for each created employee

	public Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
		this.employeeID = "E" + Employee.lastEmployeeID;
		Employee.lastEmployeeID = Employee.lastEmployeeID + 1; // adds +1 for each new employee
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	public void removeProject (Project project) {
		this.project = null;
	}

	public String toString() {
		return this.name;
	}
}
