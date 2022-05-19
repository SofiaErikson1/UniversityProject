import java.util.Collections;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.WindowConstants;

public class Main {

	public static void main(String[] args) {
		
		DepartmentTable dptTable = new DepartmentTable();
		// Preset data for departments
		dptTable.addDepartment(new Department("IT", 1000000));
		dptTable.addDepartment(new Department("Resources", 90000));
		dptTable.addDepartment(new Department("Production", 25000));
		dptTable.addDepartment(new Department("Purchasing", 83000));
		dptTable.addDepartment(new Department("Administration", 70000));
		dptTable.addDepartment(new Department("Customer service", 17000));
		dptTable.addDepartment(new Department("Marketing and sales", 190000));
		
		Department d1 = dptTable.findDepartment("IT");
		Department d2 = dptTable.findDepartment("Customer service");
		//
		
		EmployeeTable empTable = new EmployeeTable();
		// Preset data for employees
		empTable.addEmployee(new Employee("Sara", 19000));
		empTable.addEmployee(new Employee("Peter", 23000));
		empTable.addEmployee(new Employee("Amanda", 45000));
		empTable.addEmployee(new Employee("Johan", 53000));
		empTable.addEmployee(new Employee("Anna", 80000));
		empTable.addEmployee(new Employee("Kalle", 34000));
		empTable.addEmployee(new Employee("Kevin", 99999));
		
		Employee e1 = empTable.findEmployee("Sara");
		Employee e2 = empTable.findEmployee("Peter");
		Employee e3 = empTable.findEmployee("Amanda");
		Employee e4 = empTable.findEmployee("Johan");
		
		Employee e5 = empTable.findEmployee("Anna");
		Employee e6 = empTable.findEmployee("Kalle");
		Employee e7 = empTable.findEmployee("Kevin");
		//
		
		ProjectTable proTable = new ProjectTable();
		// Preset data for projects
		proTable.addProject(new Project("Project X", 90000));
		proTable.addProject(new Project("Tech Project", 140000));
		proTable.addProject(new Project("Mediocre Project", 78000));
		proTable.addProject(new Project("Project 99999", 54000));
		proTable.addProject(new Project("Project XYZ", 429000));
		proTable.addProject(new Project("Tiny Project", 39000));
		proTable.addProject(new Project("Big Project", 530000));
		
		Project p1 = proTable.findProject("Project X");
		Project p2 = proTable.findProject("Tech Project");
		//
		
		p1.addEmployeeToProject(e7);
		e7.setProject(p1);
		
		d1.addProjectToDepartment(p1);
		d1.addProjectToDepartment(p2);
		
		Frame frame = new Frame();
		DepartmentFrame departmentFrame = new DepartmentFrame();
		EmployeeFrame employeeFrame = new EmployeeFrame();
		ProjectFrame projectFrame = new ProjectFrame();
		Controller controller = new Controller(frame, departmentFrame, dptTable, employeeFrame, empTable, projectFrame, proTable);
		
	}
}
