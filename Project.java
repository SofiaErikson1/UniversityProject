import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Project {

	private String projectID;
	private String name;
	private int budget;
	
	private HashMap<String, Employee> employeesPerProject = new HashMap<String, Employee>();
	static private int lastProjectID = 1001;

	public Project(String name, int budget) {
		this.name = name;
		this.budget = budget;
		this.projectID = "P" + Project.lastProjectID;
		Project.lastProjectID = Project.lastProjectID + 1;
	}

	public String getProjectID() {
		return projectID;
	}

	public void setProjectID(String projectID) {
		this.projectID = projectID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}
	public HashMap<String, Employee> getEmployees() {
		return employeesPerProject;
	}

	public String toString() {
		return this.name + " (" + this.projectID + ")";
	}
	
	// Methods
	public void addEmployeeToProject(Employee e) {
		getEmployees().put(e.getEmployeeID(), e);
	}

	public void removeEmployeeFromProject(Employee e) {
		getEmployees().remove(e.getEmployeeID(), e);
	}

	/* public int getTotalSalaryForEmployeesInProject() {
		int sum = 0;
		for (Map.Entry<String, Employee> e : employeesPerProject.entrySet()) {
			sum = sum + e.getValue().getSalary();
		}
		return sum;
	}*/
}
