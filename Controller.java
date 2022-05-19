import java.awt.Color;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.WindowConstants;

public class Controller {

	private Frame frame;
	private DepartmentFrame dptFrame;
	private DepartmentTable dptTable;
	private EmployeeFrame empFrame;
	private EmployeeTable empTable;
	private ProjectFrame proFrame;
	private ProjectTable proTable;

	public Controller(Frame frame, DepartmentFrame dptFrame, DepartmentTable dptTable, EmployeeFrame empFrame,
			EmployeeTable empTable, ProjectFrame proFrame, ProjectTable proTable) {
		this.frame = frame;
		this.dptFrame = dptFrame;
		this.dptTable = dptTable;
		this.empFrame = empFrame;
		this.empTable = empTable;
		this.proFrame = proFrame;
		this.proTable = proTable;
		dptFrame.setDptTableRegister(dptTable);
		empFrame.setEmpTableRegister(empTable);
		proFrame.setProTableRegister(proTable);
		declareListeners();
	}

	private void declareListeners() { // GUI settings for when you run the program
		frame.getLblSek().setBounds(130, 112, 61, 16);
		frame.getLblCreateName().setBounds(29, 60, 137, 27);
		frame.getLblCreateBudgetOrSalary().setBounds(105, 93, 61, 27);
		frame.getTextFieldCreateName().setBounds(178, 61, 183, 26);
		frame.getTextFieldCreateBudgetOrSalary().setBounds(178, 94, 183, 26);
		frame.getScrollPane().setBounds(260, 259, 152, 179);
		frame.getJList().setBounds(260, 259, 152, 179);
		frame.getLblChooseDptOrAssignToPro().setBounds(255, 356, 143, 16);
		frame.getComboBoxChooseDptOrPro().setBounds(365, 353, 150, 27);
		frame.getLblNewName().setVisible(false);
		frame.getLblOptional().setVisible(false);
		frame.getLblRemaining().setVisible(false);
		frame.getLblRemainingNumber().setVisible(false);
		frame.getLblNewBudgetOrSalary().setVisible(false);
		frame.getLblChooseDptOrAssignToPro().setVisible(false);
		frame.getTextFieldNewName().setVisible(false);
		frame.getTextFieldHiddenID().setVisible(false);
		frame.getTextFieldCurrentName().setVisible(false);
		frame.getTextFieldCurrentProjects().setVisible(false);
		frame.getTextFieldNewBudgetOrSalary().setVisible(false);
		frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
		frame.getBtnRemove().setVisible(false);
		frame.getBtnUpdate().setVisible(false);
		frame.getBtnSecondaryFind().setVisible(false);
		frame.getBtnAddOrRemovePro().setVisible(false);
		frame.getLblEnterEmpId().setText("");
		frame.getLblCurrentName().setText("");
		frame.getLblCurrentProjects().setText("");
		frame.getLblCurrentBudgetOrSalary().setText("");
		frame.getLblMultipleEmployeesNumber().setText("");
		frame.getLblMultipleEmployeesExisting().setText("");
		frame.getJList().setVisible(false);
		frame.getScrollPane().setVisible(false);
		frame.getComboBoxChooseDptOrPro().setVisible(false);
		
		// changes the remaining budget for departments depending on which department you choose in the combobox in project view
		frame.getComboBoxChooseDptOrPro().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame.getComboBoxChangeView().getSelectedItem() == "Project") {
					Department department = (Department) frame.getComboBoxChooseDptOrPro().getSelectedItem();
					if (department != null) {
						String dptName = department.getName();
						Department dptTable = dptFrame.getDptTableRegister().findDepartment(dptName);
						String foundDpt = dptTable.getName();
						int remainingBudget = dptTable.getRemainingBudgetForProjects();
						if (dptName.equals(foundDpt)) {
							frame.getTextFieldCreateName().setText("");
							frame.getTextFieldCreateBudgetOrSalary().setText("");
							frame.repaint();
							frame.getLblRemainingNumber().setText(new Integer(remainingBudget).toString() + ")");
							frame.getLblRemainingNumber().setForeground(new Color(0, 0, 0));
							frame.getLblUnitCreated().setForeground(new Color(0, 0, 0));
							frame.getLblUnitCreated().setVisible(false);
						}
					}
				}
			}
		});
		frame.getComboBoxChangeView().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame.getComboBoxChangeView().getSelectedItem() == "Project") {
					ArrayList<Department> departments = dptTable.getDepartments(); // shows all departments in combobox when creating project
					frame.getComboBoxChooseDptOrPro().removeAllItems(); // clears the combobox
					for (int i = 0; i < departments.size(); i++) {
						frame.getComboBoxChooseDptOrPro().addItem(departments.get(i)); // adds the departments again
					}
					// GUI settings for project view
					frame.getBtnOpenJTable().setText("Show all data for projects");
					frame.getLblPrimaryTitle().setText("Create a project down below");
					frame.getLblCreateName().setText("Project name:");
					frame.getLblSecondaryTitle().setText("Do you wish to find an existing project?");
					frame.getLblUnitName().setText("    Project name");
					frame.getLblCreateBudgetOrSalary().setText("                   Budget:");
					frame.getLblChooseDptOrAssignToPro().setText("Choose department:");
					frame.getLblUnitCreated().setText("");
					frame.getTextFieldCreateName().setText("");
					frame.getTextFieldCreateBudgetOrSalary().setText("");
					frame.getTextFieldFind().setText("");
					frame.getLblCurrentName().setText("");
					frame.getLblCurrentBudgetOrSalary().setText("");
					frame.getLblUnitFoundOrNotFound().setText("");
					frame.getLblDptUpdated().setText("");
					frame.getLblMultipleEmployeesNumber().setText("");
					frame.getLblMultipleEmployeesExisting().setText("");
					frame.getLblEnterEmpId().setText("");
					frame.getComboBoxChooseDptOrPro().setBounds(178, 62, 183, 27);
					frame.getLblCreateName().setBounds(63, 93, 95, 27);
					frame.getTextFieldCreateName().setBounds(178, 94, 183, 26);
					frame.getLblCreateBudgetOrSalary().setBounds(29, 124, 137, 27);
					frame.getTextFieldCreateBudgetOrSalary().setBounds(178, 125, 183, 26);
					frame.getLblSek().setBounds(130, 144, 61, 16);
					frame.getLblUnitCreated().setBounds(402, 104, 142, 16);
					frame.getLblChooseDptOrAssignToPro().setBounds(17, 65, 143, 16);
					frame.getLblChooseDptOrAssignToPro().setFont(new Font("Lucida Grande", Font.PLAIN, 14));
					frame.getLblRemaining().setVisible(true);
					frame.getLblRemainingNumber().setVisible(true);
					frame.getJList().setVisible(false);
					frame.getScrollPane().setVisible(false);
					frame.getComboBoxChooseDptOrPro().setVisible(true);
					frame.getLblChooseDptOrAssignToPro().setVisible(true);
					frame.getLblOptional().setVisible(false);
					frame.getBtnSecondaryFind().setVisible(false);
					frame.getBtnRemove().setVisible(false);
					frame.getLblNewName().setVisible(false);
					frame.getTextFieldNewName().setVisible(false);
					frame.getLblNewBudgetOrSalary().setVisible(false);
					frame.getTextFieldNewBudgetOrSalary().setVisible(false);
					frame.getBtnUpdate().setVisible(false);
					frame.getLblCurrentProjects().setVisible(false);
					frame.getTextFieldCurrentName().setVisible(false);
					frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
					frame.getTextFieldCurrentProjects().setVisible(false);
					frame.getTextFieldHiddenID().setVisible(false);
					frame.getBtnAddOrRemovePro().setVisible(false);
					
					// GUI settings for department view
				} else if (frame.getComboBoxChangeView().getSelectedItem() == "Department") {
					frame.getBtnOpenJTable().setText("Show all data for departments");
					frame.getLblPrimaryTitle().setText("Create a department down below");
					frame.getLblCreateName().setText("Department name:");
					frame.getLblSecondaryTitle().setText("Do you wish to remove, find or update an existing department?");
					frame.getLblUnitName().setText("Department name");
					frame.getLblCreateBudgetOrSalary().setText("Budget:");
					frame.getLblCurrentProjects().setText("");
					frame.getLblUnitCreated().setText("");
					frame.getTextFieldCreateName().setText("");
					frame.getTextFieldCreateBudgetOrSalary().setText("");
					frame.getTextFieldFind().setText("");
					frame.getLblCurrentName().setText("");
					frame.getLblCurrentBudgetOrSalary().setText("");
					frame.getLblUnitFoundOrNotFound().setText("");
					frame.getLblDptUpdated().setText("");
					frame.getLblMultipleEmployeesNumber().setText("");
					frame.getLblMultipleEmployeesExisting().setText("");
					frame.getLblEnterEmpId().setText("");
					frame.getLblCreateName().setBounds(29, 60, 137, 27);
					frame.getTextFieldCreateName().setBounds(178, 61, 183, 26);
					frame.getLblCreateBudgetOrSalary().setBounds(105, 93, 61, 27);
					frame.getTextFieldCreateBudgetOrSalary().setBounds(178, 94, 183, 26);
					frame.getComboBoxChooseDptOrPro().setBounds(365, 353, 150, 27);
					frame.getLblSek().setBounds(130, 112, 61, 16);
					frame.getLblCurrentName().setBounds(268, 258, 93, 16);
					frame.getLblChooseDptOrAssignToPro().setBounds(255, 356, 143, 16);
					frame.getLblOptional().setVisible(false);
					frame.getLblRemaining().setVisible(false);
					frame.getLblRemainingNumber().setVisible(false);
					frame.getScrollPane().setVisible(false);
					frame.getLblChooseDptOrAssignToPro().setVisible(false);
					frame.getComboBoxChooseDptOrPro().setVisible(false);
					frame.getJList().setVisible(false);
					frame.getBtnSecondaryFind().setVisible(false);
					frame.getBtnRemove().setVisible(false);
					frame.getLblNewName().setVisible(false);
					frame.getTextFieldNewName().setVisible(false);
					frame.getLblNewBudgetOrSalary().setVisible(false);
					frame.getTextFieldNewBudgetOrSalary().setVisible(false);
					frame.getBtnUpdate().setVisible(false);
					frame.getTextFieldCurrentName().setVisible(false);
					frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
					frame.getTextFieldCurrentProjects().setVisible(false);
					frame.getTextFieldHiddenID().setVisible(false);
					frame.getBtnAddOrRemovePro().setVisible(false);
					
					// GUI settings for employee view
				} else if (frame.getComboBoxChangeView().getSelectedItem() == "Employee") {
					ArrayList<Project> projects = proTable.getProjects(); // shows all projects in combobox
					frame.getComboBoxChooseDptOrPro().removeAllItems(); // clears the combobox
					for (int i = 0; i < projects.size(); i++) {
						frame.getComboBoxChooseDptOrPro().addItem(projects.get(i)); // adds all the projects again
					}
					frame.getBtnOpenJTable().setText("Show all data for employees");
					frame.getLblPrimaryTitle().setText("Register an employee down below");
					frame.getLblCreateName().setText("   Employee name:");
					frame.getLblSecondaryTitle()
							.setText("Do you wish to remove, find or update a registered employee?");
					frame.getLblUnitName().setText("  Employee name");
					frame.getLblCreateBudgetOrSalary().setText("Salary:");
					frame.getLblChooseDptOrAssignToPro().setText("Assign to:");
					frame.getLblCurrentProjects().setText("");
					frame.getLblUnitCreated().setText("");
					frame.getTextFieldCreateName().setText("");
					frame.getTextFieldCreateBudgetOrSalary().setText("");
					frame.getTextFieldFind().setText("");
					frame.getLblCurrentName().setText("");
					frame.getLblCurrentBudgetOrSalary().setText("");
					frame.getLblUnitFoundOrNotFound().setText("");
					frame.getLblDptUpdated().setText("");
					frame.getLblMultipleEmployeesNumber().setText("");
					frame.getLblMultipleEmployeesExisting().setText("");
					frame.getLblEnterEmpId().setText("");
					frame.getComboBoxChooseDptOrPro().setBounds(365, 353, 150, 27);
					frame.getLblCreateName().setBounds(29, 60, 137, 27);
					frame.getTextFieldCreateName().setBounds(178, 61, 183, 26);
					frame.getLblCreateBudgetOrSalary().setBounds(105, 93, 61, 27);
					frame.getTextFieldCreateBudgetOrSalary().setBounds(178, 94, 183, 26);
					frame.getLblSek().setBounds(130, 112, 61, 16);
					frame.getLblUnitCreated().setBounds(402, 104, 142, 16);
					frame.getLblChooseDptOrAssignToPro().setBounds(289, 353, 143, 16);
					frame.getLblCurrentName().setBounds(268, 258, 93, 16);
					frame.getLblChooseDptOrAssignToPro().setFont(new Font("Lucida Grande", Font.PLAIN, 13));
					frame.getLblRemaining().setVisible(false);
					frame.getLblChooseDptOrAssignToPro().setVisible(false);
					frame.getLblOptional().setVisible(false);
					frame.getComboBoxChooseDptOrPro().setVisible(false);
					frame.getLblRemainingNumber().setVisible(false);
					frame.getJList().setVisible(false);
					frame.getScrollPane().setVisible(false);
					frame.getJList().setVisible(false);
					frame.getBtnSecondaryFind().setVisible(false);
					frame.getBtnRemove().setVisible(false);
					frame.getLblNewName().setVisible(false);
					frame.getTextFieldNewName().setVisible(false);
					frame.getLblNewBudgetOrSalary().setVisible(false);
					frame.getTextFieldNewBudgetOrSalary().setVisible(false);
					frame.getBtnUpdate().setVisible(false);
					frame.getTextFieldCurrentName().setVisible(false);
					frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
					frame.getTextFieldCurrentProjects().setVisible(false);
					frame.getTextFieldHiddenID().setVisible(false);
					frame.getBtnAddOrRemovePro().setVisible(false);
				}
			}
		});
		frame.getBtnOpenJTable().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame.getComboBoxChangeView().getSelectedItem() == "Department") { // launches department table window
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								dptFrame.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else if (frame.getComboBoxChangeView().getSelectedItem() == "Employee") { // launches employee table window
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								empFrame.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else if (frame.getComboBoxChangeView().getSelectedItem() == "Project") { // launches project table window
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								proFrame.frame.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		frame.getBtnCreate().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String name = frame.getTextFieldCreateName().getText();
					Department returnDpt = dptFrame.getDptTableRegister().findDepartment(name);
					int salaryOrBudget = Integer.parseInt(frame.getTextFieldCreateBudgetOrSalary().getText()); // parseInt for usage in line i.e 303,327
					if (salaryOrBudget <= 0) { // won't create objects if the salary or budget is 0 or below
						throw new IllegalArgumentException();
					} else if (name.isEmpty()) { // won't create objects if the textfield is empty
						throw new IllegalArgumentException();
					}
					if (frame.getComboBoxChangeView().getSelectedItem() == "Department") { // create view for dpt
						if (returnDpt == null) { // if department name is unique
							dptFrame.getDptTable().repaint();
							dptFrame.getDptTableRegister().addDepartment(new Department(name, salaryOrBudget)); // adds dpt to table
							frame.getLblUnitCreated().setVisible(true);
							frame.getLblUnitCreated().setText("Department created");
							frame.getLblUnitCreated().setBounds(402, 104, 142, 16);
						} else { // if another department is found with the same name
							frame.getLblUnitCreated().setText("Department name taken");
							frame.getLblUnitCreated().setBounds(392, 104, 142, 16);
						}
					} else if (frame.getComboBoxChangeView().getSelectedItem() == "Employee") { // create view for emp
						empFrame.getEmpTable().repaint();
						empFrame.getEmpTableRegister().addEmployee(new Employee(name, salaryOrBudget)); // adds emp to table
						frame.getLblUnitCreated().setVisible(true);
						frame.getLblUnitCreated().setText("Employee registered");
						frame.getLblChooseDptOrAssignToPro().setVisible(false);
						frame.getComboBoxChooseDptOrPro().setVisible(false);
					} else if (frame.getComboBoxChangeView().getSelectedItem() == "Project") { // create view for pro
						Department department = (Department) frame.getComboBoxChooseDptOrPro().getSelectedItem();
						String comboBoxValue = department.getName();
						Department tmp = dptFrame.getDptTableRegister().findDepartment(comboBoxValue);
						String foundDptName = tmp.getName();
						if (comboBoxValue == foundDptName) {
							String dptName = department.getName();
							Department dptTable = dptFrame.getDptTableRegister().findDepartment(dptName);
							int remainingBudget = dptTable.getRemainingBudgetForProjects();
							int calculatedBudget = (remainingBudget - salaryOrBudget); // when creating a project, the new project budget will subtract from the dpt budget
							if (calculatedBudget >= 0) { // as long as dpt budget after creating project is above or equal to 0 the project will be created
								proFrame.getProTable().repaint();
								Project p = new Project(name, salaryOrBudget); // creates new object of Project
								proFrame.getProTableRegister().addProject(p); // adds project to project table
								tmp.addProjectToDepartment(p); // adds project to chosen department
								frame.getLblUnitCreated().setVisible(true);
								frame.getLblUnitCreated().setText("    Project created");
								frame.getLblRemainingNumber().setText(new Integer(calculatedBudget).toString() + ")");
								frame.getLblRemainingNumber().setForeground(new Color(0, 0, 0));
								frame.getLblUnitCreated().setForeground(new Color(0, 0, 0));
							} else { // if project budget exceeds department budget, project won't be created and will show and error message
								frame.getLblUnitCreated().setVisible(true);
								frame.getLblUnitCreated().setText("     Invalid budget");
								frame.getLblRemainingNumber().setText(new Integer(calculatedBudget).toString() + ")");
								frame.getLblRemainingNumber().setForeground(new Color(212, 38, 1));
								frame.getLblUnitCreated().setForeground(new Color(212, 38, 1));
							}
						}
						frame.getLblChooseDptOrAssignToPro().setVisible(true);
						frame.getComboBoxChooseDptOrPro().setVisible(true);
						frame.getJList().setVisible(false);
						frame.getScrollPane().setVisible(false);
					}
					frame.getTextFieldFind().setText("");
					frame.getTextFieldNewName().setText("");
					frame.getTextFieldNewBudgetOrSalary().setText("");
					frame.getLblUnitFoundOrNotFound().setText("");
					frame.getLblCurrentName().setText("");
					frame.getLblCurrentBudgetOrSalary().setText("");
					frame.getLblCurrentProjects().setText("");
					frame.getLblMultipleEmployeesNumber().setText("");
					frame.getLblMultipleEmployeesExisting().setText("");
					frame.getLblEnterEmpId().setText("");
					frame.getTextFieldHiddenID().setText("");
					frame.getTextFieldCreateName().setText("");
					frame.getTextFieldCreateBudgetOrSalary().setText("");
					frame.getBtnSecondaryFind().setVisible(false);
					frame.getLblDptUpdated().setVisible(false);
					frame.getBtnRemove().setVisible(false);
					frame.getTextFieldNewName().setVisible(false);
					frame.getLblNewName().setVisible(false);
					frame.getLblNewBudgetOrSalary().setVisible(false);
					frame.getTextFieldNewBudgetOrSalary().setVisible(false);
					frame.getBtnUpdate().setVisible(false);
					frame.getTextFieldCurrentName().setVisible(false);
					frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
					frame.getTextFieldCurrentProjects().setVisible(false);
					frame.getLblOptional().setVisible(false);
					frame.getBtnAddOrRemovePro().setVisible(false);
				} catch (NumberFormatException nfe) { // catches any numberformatexceptions in the marked code
				} catch (IllegalArgumentException x) { // catches any illegalargumentexceptions in the marked code
				}
			}
		});
		frame.getBtnPrimaryFind().addActionListener(new ActionListener() { // methods for the primary find button
			public void actionPerformed(ActionEvent e) {
				try {
					String name = frame.getTextFieldFind().getText();
					Department returnDpt = dptFrame.getDptTableRegister().findDepartment(name);
					Employee returnEmp = empFrame.getEmpTableRegister().findEmployee(name);
					Project returnPro = proFrame.getProTableRegister().findProject(name);
					String returnName = null;
					List<Employee> foundEmployees = new ArrayList<>(); // will create an arraylist of employees if you create more than 1 employee with the same name
					for (Employee employee : empTable.getEmployees()) {
						if (name.equals(employee.getName())) {
							foundEmployees.add(employee);
						}
					}
					List<Project> foundProjects = new ArrayList<>();  // will create an arraylist of projects if you create more than 1 project with the same name
					for (Project project : proTable.getProjects()) {
						if (name.equals(project.getName())) {
							foundProjects.add(project);
						}
					}
					if (returnDpt != null || returnEmp != null) { // shows if a department or employee is found
						frame.getTextFieldCurrentName().setVisible(true);
						frame.getTextFieldCurrentBudgetOrSalary().setVisible(true);
						frame.getBtnRemove().setVisible(true);
						frame.getTextFieldNewName().setVisible(true);
						frame.getLblNewName().setVisible(true);
						frame.getLblNewBudgetOrSalary().setVisible(true);
						frame.getTextFieldNewBudgetOrSalary().setVisible(true);
						frame.getBtnUpdate().setVisible(true);
						frame.getTextFieldCurrentProjects().setVisible(true);
						frame.getLblCurrentProjects().setVisible(true);
						frame.getLblCurrentName().setVisible(true);
					} else {
						frame.getBtnRemove().setVisible(false);
						frame.getTextFieldNewName().setVisible(false);
						frame.getLblNewName().setVisible(false);
						frame.getLblNewBudgetOrSalary().setVisible(false);
						frame.getTextFieldNewBudgetOrSalary().setVisible(false);
						frame.getBtnUpdate().setVisible(false);
						frame.getLblUnitUpdated().setVisible(false);
						frame.getTextFieldCurrentName().setVisible(false);
						frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
						frame.getLblCurrentProjects().setVisible(false);
						frame.getTextFieldCurrentProjects().setVisible(false);
						frame.getLblCurrentName().setText("");
						frame.getLblCurrentBudgetOrSalary().setText("");
					}
					if (frame.getComboBoxChangeView().getSelectedItem() == "Department") {
						if (returnDpt != null) { 
							HashMap<String, Project> projects = returnDpt.getProjects(); // shows added projects for specific department
							frame.getComboBoxChooseDptOrPro().removeAllItems();
							for (Project project : projects.values()) { // loops through values of hashmap
								frame.getComboBoxChooseDptOrPro().addItem(project); // adds
							}
							int returnBudget = returnDpt.getBudget();
							frame.getLblNewName().setText("New department name:");
							frame.getLblNewBudgetOrSalary().setText("New department budget:");
							frame.getLblUnitFoundOrNotFound().setText("Found department");
							frame.getLblCurrentName().setText("Current name:");
							frame.getLblCurrentBudgetOrSalary().setText("Current budget:");
							frame.getLblCurrentProjects().setText("Projects:");
							frame.getLblChooseDptOrAssignToPro().setText("Remove project:");
							frame.getTextFieldCurrentBudgetOrSalary().setText((new Integer(returnBudget)).toString());
							frame.getTextFieldCurrentName().setText(name);
							frame.getTextFieldCurrentProjects().setText((new Integer(returnDpt.getProjects().size()).toString()));
							if (returnDpt.getProjects().size() >= 1) {
								frame.getBtnAddOrRemovePro().setText("Remove from department");
								frame.getBtnAddOrRemovePro().setBounds(280, 385, 200, 29);
								frame.getComboBoxChooseDptOrPro().setVisible(true);
								frame.getLblChooseDptOrAssignToPro().setVisible(true);
								frame.getBtnAddOrRemovePro().setVisible(true);
							} else {
								frame.getComboBoxChooseDptOrPro().setVisible(false);
								frame.getLblChooseDptOrAssignToPro().setVisible(false);
								frame.getBtnAddOrRemovePro().setVisible(false);
							}
						} else {
							frame.getLblUnitFoundOrNotFound().setText("Department not found");
							frame.getBtnRemove().setVisible(false);
							frame.getLblNewName().setVisible(false);
							frame.getTextFieldNewName().setVisible(false);
							frame.getLblNewBudgetOrSalary().setVisible(false);
							frame.getTextFieldNewBudgetOrSalary().setVisible(false);
							frame.getTextFieldCurrentName().setVisible(false);
							frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
							frame.getTextFieldCurrentProjects().setVisible(false);
							frame.getBtnUpdate().setVisible(false);
							frame.getLblCurrentName().setVisible(false);
						}
					} else if (frame.getComboBoxChangeView().getSelectedItem() == "Project") {
						if (foundProjects.size() > 1) { // if more than one project with same name is found
							String s = Integer.toString(foundProjects.size());
							frame.getLblMultipleEmployeesNumber().setBounds(329, 220, 25, 16);
							frame.getLblMultipleEmployeesNumber().setText(s);
							frame.getLblMultipleEmployeesExisting().setText("projects found.");
							frame.getLblEnterEmpId().setText("Please enter project ID:");
							frame.getLblCurrentName().setText("Project ID:");
							frame.getLblCurrentBudgetOrSalary().setText("");
							frame.getLblCurrentProjects().setText("");
							frame.getLblUnitFoundOrNotFound().setText("");
							frame.getTextFieldCurrentName().setText("");
							frame.getLblNewName().setText("");
							frame.getLblNewBudgetOrSalary().setText("");
							frame.getLblDptUpdated().setText("");
							frame.getLblCurrentName().setBounds(284, 258, 93, 16);
							frame.getBtnRemove().setVisible(false);
							frame.getBtnUpdate().setVisible(false);
							frame.getTextFieldNewBudgetOrSalary().setVisible(false);
							frame.getTextFieldNewName().setVisible(false);
							frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
							frame.getTextFieldCurrentProjects().setVisible(false);
							frame.getBtnAddOrRemovePro().setVisible(false);
							frame.getLblOptional().setVisible(false);
							frame.getJList().setVisible(false);
							frame.getScrollPane().setVisible(false);
							frame.getLblEnterEmpId().setVisible(true);
							frame.getLblMultipleEmployeesExisting().setVisible(true);
							frame.getTextFieldCurrentName().setVisible(true);
							frame.getTextFieldCurrentName().setEditable(true);
							frame.getBtnSecondaryFind().setVisible(true);
							frame.getLblCurrentName().setVisible(true);
						} else if (foundProjects.size() == 1) { // unique project name found
							frame.getListModel().clear();
							for (Employee employee : returnPro.getEmployees().values()) {
								frame.getListModel().addElement(employee); // adds all employees assigned to specific project
							}
							frame.getLblMultipleEmployeesNumber().setText("");
							frame.getJList().setVisible(true);
							frame.getScrollPane().setVisible(true);
							frame.getScrollPane().setViewportView(frame.getJList());
							frame.getLblMultipleEmployeesExisting().setVisible(false);
							frame.getLblEnterEmpId().setVisible(false);
							frame.getLblCurrentName().setVisible(false);
							frame.getBtnSecondaryFind().setVisible(false);
							frame.getLblUnitFoundOrNotFound().setVisible(false);
						} else {
							frame.getLblUnitFoundOrNotFound().setVisible(true);
							frame.getLblUnitFoundOrNotFound().setText("Project not found");
							frame.getJList().setVisible(false);
							frame.getScrollPane().setVisible(false);
						}
					} else if (frame.getComboBoxChangeView().getSelectedItem() == "Employee") {
						if (foundEmployees.size() > 1) { // if more than one employee with same name is found
							String s = Integer.toString(foundEmployees.size());
							frame.getLblMultipleEmployeesNumber().setText(s);
							frame.getLblMultipleEmployeesExisting().setText("employees found.");
							frame.getLblEnterEmpId().setText("Please enter employee ID:");
							frame.getLblCurrentName().setText("Employee ID:");
							frame.getLblCurrentBudgetOrSalary().setText("");
							frame.getLblCurrentProjects().setText("");
							frame.getLblUnitFoundOrNotFound().setText("");
							frame.getTextFieldCurrentName().setText("");
							frame.getLblNewName().setText("");
							frame.getLblNewBudgetOrSalary().setText("");
							frame.getLblDptUpdated().setText("");
							frame.getTextFieldCurrentName().setEditable(true);
							frame.getLblMultipleEmployeesExisting().setVisible(true);
							frame.getLblEnterEmpId().setVisible(true);
							frame.getLblCurrentName().setVisible(true);
							frame.getBtnRemove().setVisible(false);
							frame.getBtnUpdate().setVisible(false);
							frame.getTextFieldNewBudgetOrSalary().setVisible(false);
							frame.getTextFieldNewName().setVisible(false);
							frame.getBtnSecondaryFind().setVisible(true);
							frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
							frame.getTextFieldCurrentProjects().setVisible(false);
							frame.getBtnAddOrRemovePro().setVisible(false);
							frame.getComboBoxChooseDptOrPro().setVisible(false);
							frame.getLblChooseDptOrAssignToPro().setVisible(false);
							frame.getLblOptional().setVisible(false);
						} else if (foundEmployees.size() == 1) { // if employee name is unique
							returnName = returnEmp.getName();
							int returnSalary = returnEmp.getSalary();
							Project assignedProject = (Project) returnEmp.getProject();
							if (assignedProject != null) { // if employee is assigned to a project
								String assignedProjectName = assignedProject.getName();
								frame.getLblNewName().setText("  New employee name:");
								frame.getLblNewBudgetOrSalary().setText("  New employee salary:");
								frame.getLblUnitFoundOrNotFound().setText("     Found employee");
								frame.getLblCurrentName().setText("Current name:");
								frame.getLblCurrentBudgetOrSalary().setText(" Current salary:");
								frame.getLblCurrentProjects().setText(" Project:");
								frame.getBtnAddOrRemovePro().setText("Remove from project");
								frame.getLblMultipleEmployeesNumber().setText("");
								frame.getLblMultipleEmployeesExisting().setText("");
								frame.getLblEnterEmpId().setText("");
								frame.getBtnAddOrRemovePro().setBounds(327, 349, 160, 29);
								frame.getLblCurrentProjects().setVisible(true);
								frame.getTextFieldCurrentProjects().setVisible(true);
								frame.getBtnAddOrRemovePro().setVisible(true);
								frame.getBtnSecondaryFind().setVisible(false);
								frame.getLblChooseDptOrAssignToPro().setVisible(false);
								frame.getLblOptional().setVisible(false);
								frame.getComboBoxChooseDptOrPro().setVisible(false);
								frame.getTextFieldCurrentName().setText(returnName);
								frame.getTextFieldCurrentBudgetOrSalary().setText((new Integer(returnSalary)).toString());
								frame.getTextFieldCurrentProjects().setText(assignedProjectName);
							} else { // if employee is NOT assigned to a project
								frame.getLblNewName().setText("  New employee name:");
								frame.getLblNewBudgetOrSalary().setText("  New employee salary:");
								frame.getLblUnitFoundOrNotFound().setText("     Found employee");
								frame.getLblCurrentName().setText("Current name:");
								frame.getLblCurrentBudgetOrSalary().setText(" Current salary:");
								frame.getLblCurrentProjects().setText(" Project:");
								frame.getBtnAddOrRemovePro().setText("Add");
								frame.getLblMultipleEmployeesNumber().setText("");
								frame.getLblMultipleEmployeesExisting().setText("");
								frame.getLblEnterEmpId().setText("");
								frame.getBtnAddOrRemovePro().setBounds(408, 380, 60, 29);
								frame.getLblCurrentProjects().setVisible(true);
								frame.getTextFieldCurrentProjects().setVisible(true);
								frame.getLblChooseDptOrAssignToPro().setVisible(true);
								frame.getLblOptional().setVisible(true);
								frame.getComboBoxChooseDptOrPro().setVisible(true);
								frame.getBtnAddOrRemovePro().setVisible(true);
								frame.getBtnSecondaryFind().setVisible(false);
								frame.getTextFieldCurrentBudgetOrSalary().setText((new Integer(returnSalary)).toString());
								frame.getTextFieldCurrentProjects().setText("None");
								frame.getTextFieldCurrentName().setText(returnName);
							}
						} else {
							frame.getLblUnitFoundOrNotFound().setText("Employee not found");
							frame.getLblMultipleEmployeesNumber().setText("");
							frame.getLblMultipleEmployeesExisting().setText("");
							frame.getLblEnterEmpId().setText("");
							frame.getLblUnitFoundOrNotFound().setVisible(true);
							frame.getBtnSecondaryFind().setVisible(false);
							frame.getComboBoxChooseDptOrPro().setVisible(false);
							frame.getBtnAddOrRemovePro().setVisible(false);
							frame.getLblChooseDptOrAssignToPro().setVisible(false);
							frame.getLblOptional().setVisible(false);
						}
					}
					frame.getLblUnitCreated().setVisible(false);
					frame.getTextFieldHiddenID().setText("");
					frame.getTextFieldCreateName().setText("");
					frame.getTextFieldCreateBudgetOrSalary().setText("");
					frame.getTextFieldNewName().setText("");
					frame.getTextFieldNewBudgetOrSalary().setText("");
					frame.getLblUnitUpdated().setText("");
				} catch (NullPointerException npe) { // catches any nullpointerexceptions in the marked code
				}
			}
		});
		frame.getBtnSecondaryFind().addActionListener(new ActionListener() { // methods for the secondary find button
			public void actionPerformed(ActionEvent e) {
				try {
					String unitID = frame.getTextFieldCurrentName().getText();
					if (frame.getComboBoxChangeView().getSelectedItem() == "Employee") {
						Employee returnEmp = empFrame.getEmpTableRegister().findEmployeeByID(unitID);
						String returnName = null;
						Project assignedProject = (Project) returnEmp.getProject();
						returnName = returnEmp.getName();
						int returnSalary = returnEmp.getSalary();
						frame.getLblNewName().setText("  New employee name:");
						frame.getLblNewBudgetOrSalary().setText("  New employee salary:");
						frame.getLblUnitFoundOrNotFound().setText("     Found employee");
						frame.getLblCurrentName().setText("Current name:");
						frame.getLblCurrentBudgetOrSalary().setText(" Current salary:");
						frame.getLblCurrentProjects().setText(" Project:");
						frame.getLblMultipleEmployeesNumber().setText("");
						frame.getLblMultipleEmployeesExisting().setText("");
						frame.getLblEnterEmpId().setText("");
						frame.getTextFieldHiddenID().setText(unitID);
						frame.getTextFieldCurrentProjects().setVisible(true);
						frame.getTextFieldCurrentBudgetOrSalary().setVisible(true);
						frame.getTextFieldNewName().setVisible(true);
						frame.getTextFieldNewBudgetOrSalary().setVisible(true);
						frame.getBtnUpdate().setVisible(true);
						frame.getBtnRemove().setVisible(true);
						frame.getBtnSecondaryFind().setVisible(false);
						frame.getTextFieldCurrentName().setEditable(false);
						frame.getTextFieldCurrentBudgetOrSalary().setText((new Integer(returnSalary)).toString());
						frame.getTextFieldCurrentName().setText(returnName);
						if (assignedProject != null) {
							String assignedProjectName = assignedProject.getName();
							frame.getTextFieldCurrentProjects().setText(assignedProjectName);
							frame.getBtnAddOrRemovePro().setText("Remove from project");
							frame.getBtnAddOrRemovePro().setBounds(327, 349, 160, 29);
							frame.getBtnAddOrRemovePro().setVisible(true);
							frame.getLblChooseDptOrAssignToPro().setVisible(false);
							frame.getLblOptional().setVisible(false);
							frame.getComboBoxChooseDptOrPro().setVisible(false);
						} else {
							frame.getTextFieldCurrentProjects().setText("None");
							frame.getBtnAddOrRemovePro().setText("Add");
							frame.getBtnAddOrRemovePro().setBounds(408, 380, 60, 29);
							frame.getLblChooseDptOrAssignToPro().setVisible(true);
							frame.getLblOptional().setVisible(true);
							frame.getComboBoxChooseDptOrPro().setVisible(true);
							frame.getBtnAddOrRemovePro().setVisible(true);
						}
					} else if (frame.getComboBoxChangeView().getSelectedItem() == "Project") {
						Project returnPro = proFrame.getProTableRegister().findProjectByID(unitID);
						frame.getListModel().clear();
						frame.getJList().setVisible(true);
						frame.getScrollPane().setVisible(true);
						for (Employee employee : returnPro.getEmployees().values()) {
							frame.getListModel().addElement(employee);
						}
						frame.getLblMultipleEmployeesNumber().setText("");
						frame.getLblMultipleEmployeesExisting().setVisible(false);
						frame.getLblEnterEmpId().setVisible(false);
						frame.getLblCurrentName().setVisible(false);
						frame.getBtnSecondaryFind().setVisible(false);
						frame.getTextFieldCurrentName().setVisible(false);
						frame.getScrollPane().setViewportView(frame.getJList());
					}
				} catch (NullPointerException npe) {
				}
			}
		});
		frame.getBtnRemove().addActionListener(new ActionListener() { // methods for removing objects
			public void actionPerformed(ActionEvent e) {
				String name = frame.getTextFieldFind().getText();
				String hiddenID = frame.getTextFieldHiddenID().getText();
				Employee returnEmp = empFrame.getEmpTableRegister().findEmployee(name);
				Employee returnEmpID = empFrame.getEmpTableRegister().findEmployeeByID(hiddenID);
				Project returnProID = proFrame.getProTableRegister().findProjectByID(hiddenID);
				Department returnDpt = dptFrame.getDptTableRegister().findDepartment(name);
				if (returnDpt != null || returnEmp != null || returnEmpID != null) {
					frame.getBtnRemove().setVisible(false);
					frame.getTextFieldNewName().setVisible(false);
					frame.getLblNewName().setVisible(false);
					frame.getLblNewBudgetOrSalary().setVisible(false);
					frame.getTextFieldNewBudgetOrSalary().setVisible(false);
					frame.getBtnUpdate().setVisible(false);
					frame.getLblUnitUpdated().setVisible(false);
					frame.getTextFieldCurrentName().setVisible(false);
					frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
					frame.getLblCurrentProjects().setVisible(false);
					frame.getTextFieldCurrentProjects().setVisible(false);
					frame.getBtnSecondaryFind().setVisible(false);
					frame.getLblChooseDptOrAssignToPro().setVisible(false);
					frame.getLblOptional().setVisible(false);
					frame.getComboBoxChooseDptOrPro().setVisible(false);
					frame.getBtnAddOrRemovePro().setVisible(false);
					frame.getTextFieldHiddenID().setText("");
					frame.getLblMultipleEmployeesNumber().setText("");
					frame.getLblMultipleEmployeesExisting().setText("");
					frame.getLblEnterEmpId().setText("");
					frame.getLblCurrentName().setText("");
					frame.getLblCurrentBudgetOrSalary().setText("");
					frame.getTextFieldNewName().setText("");
					frame.getTextFieldNewBudgetOrSalary().setText("");
					frame.getLblUnitCreated().setText("");
					frame.getLblUnitUpdated().setText("");
					frame.getTextFieldFind().setText("");
				}
				if (frame.getComboBoxChangeView().getSelectedItem() == "Department") {
					if (returnDpt != null) {
						dptFrame.getDptTable().repaint();
						frame.getLblUnitFoundOrNotFound().setText(name + " removed");
						dptFrame.getDptTableRegister().removeDepartment(name);
						dptFrame.getDptTable().repaint();
					}
				} else if (frame.getComboBoxChangeView().getSelectedItem() == "Employee") {
					Project project = (Project) frame.getComboBoxChooseDptOrPro().getSelectedItem();
					if (returnEmpID != null) {
						empFrame.getEmpTable().repaint();
						frame.getLblUnitFoundOrNotFound().setText(name + " removed");
						project.removeEmployeeFromProject(returnEmpID); // removes employee from project if assigned
						empFrame.getEmpTableRegister().removeEmployeeByID(hiddenID);
						empFrame.getEmpTable().repaint();
					} else if (returnEmp != null) {
						empFrame.getEmpTable().repaint();
						frame.getLblUnitFoundOrNotFound().setText(name + " removed");
						project.removeEmployeeFromProject(returnEmp); // removes employee from project if assigned
						empFrame.getEmpTableRegister().removeEmployee(name);
						empFrame.getEmpTable().repaint();
					}
				} else if (frame.getComboBoxChangeView().getSelectedItem() == "Project") {
					if (returnProID != null) {
						proFrame.getProTable().repaint();
						frame.getLblUnitFoundOrNotFound().setText(name + " removed");

					}
				}
			}
		});
		frame.getBtnUpdate().addActionListener(new ActionListener() { // methods for updating objects
			public void actionPerformed(ActionEvent e) {
				try {
					String name = frame.getTextFieldFind().getText();
					String employeeID = frame.getTextFieldHiddenID().getText();
					Employee returnEmp = empFrame.getEmpTableRegister().findEmployee(name);
					Employee returnEmpID = empFrame.getEmpTableRegister().findEmployeeByID(employeeID);
					String oldName = frame.getTextFieldFind().getText();
					String updatedName = frame.getTextFieldNewName().getText();
					int updatedBudgetOrSalary = Integer.parseInt(frame.getTextFieldNewBudgetOrSalary().getText());
					if (frame.getComboBoxChangeView().getSelectedItem() == "Department") {
						dptFrame.getDptTable().repaint();
						dptFrame.getDptTableRegister().updateDepartment(oldName, updatedName, updatedBudgetOrSalary);
						dptFrame.getDptTable().repaint();
					} else if (frame.getComboBoxChangeView().getSelectedItem() == "Employee") {
						if (returnEmpID != null) {
							empFrame.getEmpTable().repaint();
							empFrame.getEmpTableRegister().updateEmployeeByID(employeeID, updatedName,
									updatedBudgetOrSalary);
							empFrame.getEmpTable().repaint();
						} else if (returnEmp != null) {
							empFrame.getEmpTable().repaint();
							empFrame.getEmpTableRegister().updateEmployee(name, updatedName, updatedBudgetOrSalary);
							empFrame.getEmpTable().repaint();
						}
					}
					frame.getTextFieldCurrentName().setText(updatedName);
					frame.getTextFieldCurrentName().setVisible(false);
					frame.getTextFieldCurrentBudgetOrSalary().setVisible(false);
					frame.getLblUnitUpdated().setVisible(true);
					frame.getLblCurrentProjects().setVisible(false);
					frame.getTextFieldCurrentProjects().setVisible(false);
					frame.getLblChooseDptOrAssignToPro().setVisible(false);
					frame.getLblOptional().setVisible(false);
					frame.getComboBoxChooseDptOrPro().setVisible(false);
					frame.getBtnAddOrRemovePro().setVisible(false);
					frame.getLblUnitUpdated().setText("Successfully updated!");
					frame.getTextFieldFind().setText("");
					frame.getTextFieldHiddenID().setText("");
					frame.getLblUnitFoundOrNotFound().setText("");
					frame.getLblCurrentName().setText("");
					frame.getLblCurrentBudgetOrSalary().setText("");
				} catch (NumberFormatException nfe) {

				}
			}
		});
		frame.getBtnAddOrRemovePro().addActionListener(new ActionListener() { // for adding or removing projects for employees or departments
			public void actionPerformed(ActionEvent e) {
				if (frame.getComboBoxChangeView().getSelectedItem() == "Employee") {
					String nameID = frame.getTextFieldHiddenID().getText();
					String name = frame.getTextFieldCurrentName().getText();
					Project project = (Project) frame.getComboBoxChooseDptOrPro().getSelectedItem();
					Employee returnEmpByID = empFrame.getEmpTableRegister().findEmployeeByID(nameID);
					Employee returnEmpByName = empFrame.getEmpTableRegister().findEmployee(name);
					if (returnEmpByID != null) { // if the hidden textfield has, for example,  an employee code E1008
						if (returnEmpByID.getProject() == null) { // if the employee does NOT have a project assigned
							project.addEmployeeToProject(returnEmpByID); // adds
							returnEmpByID.setProject(project);
						} else {
							project.removeEmployeeFromProject(returnEmpByID); // removes assigned project from employee
							returnEmpByID.removeProject(project);
						}
					} else { // if textfield is empty
						if (returnEmpByName.getProject() == null) {
							project.addEmployeeToProject(returnEmpByName);
							returnEmpByName.setProject(project);
						} else {
							project.removeEmployeeFromProject(returnEmpByName);
							returnEmpByName.removeProject(project);
						}
					}
				} else if (frame.getComboBoxChangeView().getSelectedItem() == "Department") {
					Project project = (Project) frame.getComboBoxChooseDptOrPro().getSelectedItem();
					String department = frame.getTextFieldCurrentName().getText();
					Department returnDpt = dptFrame.getDptTableRegister().findDepartment(department);
					returnDpt.removeProjectFromDepartment(project);
				}
			}
		});
	}
}