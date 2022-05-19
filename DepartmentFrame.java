import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;

public class DepartmentFrame extends JFrame {

	JFrame frame;
	private JTable departmentTable;
	private DepartmentTable dptTableRegister;
	private JScrollPane dptScrollPane;

	public DepartmentFrame() {
		initialize();
	}

	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 340);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		dptScrollPane = new JScrollPane();
		dptScrollPane.setBounds(54, 52, 337, 203);
		frame.getContentPane().add(dptScrollPane);

		departmentTable = new JTable();
	}

	public DepartmentTable getDptTableRegister() {
		return dptTableRegister;
	}

	public void setDptTableRegister(DepartmentTable dptTable) {
		this.dptTableRegister = dptTable;
		departmentTable.setModel(dptTable);
		dptScrollPane.setViewportView(departmentTable);
		departmentTable.getColumnModel().getColumn(0).setPreferredWidth(160);
	}

	// Getters for JTables
	public JTable getDptTable() {
		return departmentTable;
	}
}
