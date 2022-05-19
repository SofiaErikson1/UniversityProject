import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class ProjectTable extends AbstractTableModel {

	private ArrayList<Project> projects = new ArrayList<Project>();
	private String[] columns = { "Project ID", "Name", "Budget" };

	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void addProject(Project e) {
		this.projects.add(e);
		this.fireTableDataChanged();

	}

	public void removeProjectByID(String projectID) {
		for (Project project : this.getProjects()) {
			if (projectID.equals(project.getProjectID())) {
				this.getProjects().remove(project);
			}
		}
	}
	public Project findProject(String name) {
		for (Project project : this.getProjects()) {
			if (name.equals(project.getName())) {
				return project;
			}
		}
		return null;
	}
	
	public Project findProjectByID(String projectID) {
		for (Project project : this.getProjects()) {
			if (projectID.equals(project.getProjectID())) {
				return project;
			}
		}
		return null;
	}

	@Override
	public int getRowCount() {
		return projects.size();
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
		Project project = projects.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return project.getProjectID();
		case 1:
			return project.getName();
		case 2:
			return project.getBudget();
		}
		return null;
	}

}
