import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class EmployeeFrame extends JFrame {

	JFrame frame;
	private JTable employeeTable;
	private EmployeeTable empTableRegister;
	private JScrollPane scrollPane;

	public EmployeeFrame() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 340);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 52, 337, 203);
		frame.getContentPane().add(scrollPane);

		employeeTable = new JTable();
	}

	public EmployeeTable getEmpTableRegister() {
		return empTableRegister;
	}

	public void setEmpTableRegister(EmployeeTable empTable) {
		this.empTableRegister = empTable;
		employeeTable.setModel(empTable);
		scrollPane.setViewportView(employeeTable);
		employeeTable.getColumnModel().getColumn(0).setPreferredWidth(60);
		employeeTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		employeeTable.getColumnModel().getColumn(2).setPreferredWidth(50);
	}

	// Getters for JTable
	public JTable getEmpTable() {
		return employeeTable;
	}
}
