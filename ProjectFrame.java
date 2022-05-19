import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ProjectFrame extends JFrame {

	JFrame frame;
	private JTable projectTable;
	private ProjectTable proTableRegister;
	private JScrollPane scrollPane;

	public ProjectFrame() {
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

		projectTable = new JTable();
	}

	public ProjectTable getProTableRegister() {
		return proTableRegister;
	}

	public void setProTableRegister(ProjectTable proTable) {
		this.proTableRegister = proTable;
		projectTable.setModel(proTable);
		scrollPane.setViewportView(projectTable);
		projectTable.getColumnModel().getColumn(0).setPreferredWidth(60);
		projectTable.getColumnModel().getColumn(1).setPreferredWidth(120);
		projectTable.getColumnModel().getColumn(2).setPreferredWidth(50);
	}
	
	public JTable getProTable() {
		return projectTable;
	}

}
