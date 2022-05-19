import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Collections;

import javax.swing.table.AbstractTableModel;

public class EmployeeTable extends AbstractTableModel {

	private ArrayList<Employee> employees = new ArrayList<Employee>();
	private String[] columns = { "Employee ID", "Name", "Salary" };

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void addEmployee(Employee e) {
		this.employees.add(e);
		this.fireTableDataChanged();

	}

	public Employee findEmployee(String name) {
		for (Employee employee : this.getEmployees()) {
			if (name.equals(employee.getName())) {
				return employee;
			}
		}
		return null;
	}

	public Employee findEmployeeByID(String employeeID) {
		for (Employee employee : this.getEmployees()) {
			if (employeeID.equals(employee.getEmployeeID())) {
				return employee;
			}
		}
		return null;
	}

	public void removeEmployee(String name) {
		Employee employee = findEmployee(name);
		if (employee != null) {
			this.getEmployees().remove(employee);
		}
		
	}
	
	public void removeEmployeeByID(String employeeID) {
		Employee employee = findEmployeeByID(employeeID);
		if (employee != null) {
			this.getEmployees().remove(employee);
		}
	}

	public void updateEmployee(String name, String updatedName, int updatedSalary) {
		for (Employee employee : this.getEmployees()) {
			if (name.equals(employee.getName())) {
				employee.setName(updatedName);
				employee.setSalary(updatedSalary);

			}
		}
	}
	public void updateEmployeeByID(String employeeID, String updatedName, int updatedSalary) {
		for (Employee employee : this.getEmployees()) {
			if (employeeID.equals(employee.getEmployeeID())) {
				employee.setName(updatedName);
				employee.setSalary(updatedSalary);
			}
		}
	}

	@Override
	public int getRowCount() {
		return employees.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public String getColumnName(int columnIndex) {
		return columns[columnIndex];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Employee employee = employees.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return employee.getEmployeeID();
		case 1:
			return employee.getName();
		case 2:
			return employee.getSalary();
		}
		return null;
	}

}
