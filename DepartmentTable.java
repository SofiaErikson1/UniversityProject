import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class DepartmentTable extends AbstractTableModel {

	private ArrayList<Department> departments = new ArrayList<Department>();
	private String[] columns = { "Department name", "Budget (SEK)" };

	public ArrayList<Department> getDepartments() {
		return departments;
	}

	public void addDepartment(Department d) {
		this.departments.add(d);
		this.fireTableDataChanged();
	}

	public Department findDepartment(String name) {
		for (Department department : this.getDepartments()) {
			if (name.equals(department.getName())) {
				return department;
			}
		}
		return null;
	}

	public void removeDepartment(String name) {
		Department department = findDepartment(name);
		if (department != null) {
			this.getDepartments().remove(department);
		}
	}

	public void updateDepartment(String name, String updatedName, int updatedBudget) {
		for (Department department : this.getDepartments()) {
			if (name.equals(department.getName())) {
				department.setName(updatedName);
				department.setBudget(updatedBudget);
			}
		}
	}

	@Override
	public int getRowCount() {
		return departments.size();
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
		Department department = departments.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return department.getName();
		case 1:
			return department.getBudget();
		}
		return null;
	}

}
