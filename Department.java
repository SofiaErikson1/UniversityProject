import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Department {

	private EmployeeTable employees;
	private String name;
	private int budget;

	private HashMap<String, Project> projectsPerDepartment = new HashMap<String, Project>();

	public Department(String name, int budget) { // constructor
		this.setName(name);
		this.budget = budget;
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

	public HashMap<String, Project> getProjects() {
		return this.projectsPerDepartment;
	}

	public String toString() {
		return this.name;
	}

	// Methods
	public void addProjectToDepartment(Project p) {
		getProjects().put(p.getProjectID(), p);
	}

	public void removeProjectFromDepartment(Project p) {
		getProjects().remove(p.getProjectID(), p);
	}
	
	public int getRemainingBudgetForProjects() {
		int sum = 0;
		for (Map.Entry<String, Project> project : projectsPerDepartment.entrySet()) { // returns a collection-view of the map whose elements are of this class
			sum = sum + project.getValue().getBudget();
		}
		return (this.getBudget() - sum);
	}
	
	public Project findProjectInDepartment(String projectID) {
		for (Project project : projectsPerDepartment.values()) {
			if (projectID.equals(project.getProjectID())) {
				return project;
			}
		}
		return null;
	}
}
