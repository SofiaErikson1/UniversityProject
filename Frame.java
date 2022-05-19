
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JList;

public class Frame extends JFrame {

	DepartmentTable dptTable;
	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JList list;
	private JLabel lblCreateBudgetOrSalary;
	private JLabel lblCreateName;
	private JLabel lblChooseDptOrAssignToPro;
	private JLabel lblCurrentBudgetOrSalary;
	private JLabel lblCurrentName;
	private JLabel lblCurrentProjects;
	private JLabel lblEnterEmpId;
	private JLabel lblMultipleEmployeesExisting;
	private JLabel lblMultipleEmployeesNumber;
	private JLabel lblNewBudgetOrSalary;
	private JLabel lblNewName;
	private JLabel lblOptional;
	private JLabel lblPrimaryTitle;
	private JLabel lblRemaining;
	private JLabel lblRemainingNumber;
	private JLabel lblSecondaryTitle;
	private JLabel lblSek;
	private JLabel lblUnitName;
	private JLabel lblUnitCreated;
	private JLabel lblUnitUpdated;
	private JLabel lblUnitFoundOrNotFound;
	private JTextField textFieldCreateBudgetOrSalary;
	private JTextField textFieldCreateName;
	private JTextField textFieldCurrentName;
	private JTextField textFieldCurrentBudgetOrSalary;
	private JTextField textFieldCurrentProjects;
	private JTextField textFieldHiddenID;
	private JTextField textFieldFind;
	private JTextField textFieldNewName;
	private JTextField textFieldNewBudgetOrSalary;
	private JButton btnAddOrRemovePro;
	private JButton btnCreate;
	private JButton btnOpenJTable;
	private JButton btnPrimaryFind;
	private JButton btnRemove;
	private JButton btnSecondaryFind;
	private JButton btnUpdate;
	private JComboBox comboBoxChangeView;
	private JComboBox comboBoxChooseDptOrPro;

	public Frame() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(250, 259, 152, 179);
		contentPane.add(scrollPane);

		DefaultListModel model = new DefaultListModel();

		list = new JList(model);
		scrollPane.setViewportView(list);

		lblCreateBudgetOrSalary = new JLabel("Budget:");
		lblCreateBudgetOrSalary.setBounds(105, 93, 61, 27);
		lblCreateBudgetOrSalary.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(lblCreateBudgetOrSalary);

		lblCreateName = new JLabel("Department name:");
		lblCreateName.setBounds(29, 60, 137, 27);
		lblCreateName.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(lblCreateName);

		lblChooseDptOrAssignToPro = new JLabel("Choose department");
		lblChooseDptOrAssignToPro.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblChooseDptOrAssignToPro.setBounds(17, 65, 143, 16);
		contentPane.add(lblChooseDptOrAssignToPro);

		lblCurrentBudgetOrSalary = new JLabel("Current budget:");
		lblCurrentBudgetOrSalary.setBounds(258, 290, 103, 16);
		contentPane.add(lblCurrentBudgetOrSalary);

		lblCurrentName = new JLabel("Current name:");
		lblCurrentName.setBounds(268, 258, 93, 16);
		contentPane.add(lblCurrentName);

		lblCurrentProjects = new JLabel("Projects:");
		lblCurrentProjects.setBounds(302, 323, 61, 16);
		contentPane.add(lblCurrentProjects);

		lblEnterEmpId = new JLabel("");
		lblEnterEmpId.setBounds(310, 237, 167, 16);
		contentPane.add(lblEnterEmpId);

		lblMultipleEmployeesExisting = new JLabel("");
		lblMultipleEmployeesExisting.setBounds(340, 220, 117, 16);
		contentPane.add(lblMultipleEmployeesExisting);

		lblMultipleEmployeesNumber = new JLabel("");
		lblMultipleEmployeesNumber.setBounds(328, 220, 13, 16);
		contentPane.add(lblMultipleEmployeesNumber);

		lblNewBudgetOrSalary = new JLabel("New Department budget:");
		lblNewBudgetOrSalary.setBounds(56, 379, 152, 16);
		lblNewBudgetOrSalary.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		contentPane.add(lblNewBudgetOrSalary);

		lblNewName = new JLabel("New Department name:");
		lblNewName.setBounds(61, 334, 143, 16);
		lblNewName.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		contentPane.add(lblNewName);

		lblOptional = new JLabel("(Optional)");
		lblOptional.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblOptional.setBounds(306, 367, 45, 12);
		contentPane.add(lblOptional);

		lblPrimaryTitle = new JLabel("Create a department down below");
		lblPrimaryTitle.setBounds(39, 21, 275, 27);
		lblPrimaryTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		contentPane.add(lblPrimaryTitle);

		lblRemaining = new JLabel("(remaining:");
		lblRemaining.setForeground(Color.BLACK);
		lblRemaining.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblRemaining.setBounds(190, 148, 53, 16);
		contentPane.add(lblRemaining);

		lblRemainingNumber = new JLabel("");
		lblRemainingNumber.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		lblRemainingNumber.setBounds(245, 148, 103, 16);
		contentPane.add(lblRemainingNumber);

		lblSecondaryTitle = new JLabel("Do you wish to remove, find or update an existing department?");
		lblSecondaryTitle.setBounds(29, 193, 501, 27);
		lblSecondaryTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		contentPane.add(lblSecondaryTitle);

		lblSek = new JLabel("(SEK)");
		lblSek.setBounds(130, 112, 34, 16);
		lblSek.setFont(new Font("Lucida Grande", Font.PLAIN, 9));
		contentPane.add(lblSek);

		lblUnitName = new JLabel("Department name:");
		lblUnitName.setBounds(67, 226, 137, 27);
		lblUnitName.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(lblUnitName);

		lblUnitCreated = new JLabel("");
		lblUnitCreated.setBounds(402, 104, 142, 16);
		lblUnitCreated.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		contentPane.add(lblUnitCreated);

		lblUnitUpdated = new JLabel("");
		lblUnitUpdated.setBounds(75, 454, 109, 16);
		lblUnitUpdated.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		contentPane.add(lblUnitUpdated);

		lblUnitFoundOrNotFound = new JLabel("");
		lblUnitFoundOrNotFound.setBounds(308, 226, 161, 27);
		lblUnitFoundOrNotFound.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		contentPane.add(lblUnitFoundOrNotFound);

		textFieldCreateBudgetOrSalary = new JTextField();
		textFieldCreateBudgetOrSalary.setBounds(178, 94, 183, 26);
		contentPane.add(textFieldCreateBudgetOrSalary);
		textFieldCreateBudgetOrSalary.setColumns(10);

		textFieldCreateName = new JTextField();
		textFieldCreateName.setBounds(178, 61, 183, 26);
		contentPane.add(textFieldCreateName);
		textFieldCreateName.setColumns(10);

		textFieldCurrentName = new JTextField();
		textFieldCurrentName.setEditable(false);
		textFieldCurrentName.setColumns(10);
		textFieldCurrentName.setBackground(Color.LIGHT_GRAY);
		textFieldCurrentName.setBounds(368, 253, 143, 26);
		contentPane.add(textFieldCurrentName);

		textFieldCurrentBudgetOrSalary = new JTextField();
		textFieldCurrentBudgetOrSalary.setEditable(false);
		textFieldCurrentBudgetOrSalary.setColumns(10);
		textFieldCurrentBudgetOrSalary.setBackground(Color.LIGHT_GRAY);
		textFieldCurrentBudgetOrSalary.setBounds(368, 286, 142, 26);
		contentPane.add(textFieldCurrentBudgetOrSalary);

		textFieldCurrentProjects = new JTextField();
		textFieldCurrentProjects.setEditable(false);
		textFieldCurrentProjects.setColumns(10);
		textFieldCurrentProjects.setBackground(Color.LIGHT_GRAY);
		textFieldCurrentProjects.setBounds(368, 318, 142, 26);
		contentPane.add(textFieldCurrentProjects);

		textFieldHiddenID = new JTextField();
		textFieldHiddenID.setBounds(394, 465, 130, 26);
		contentPane.add(textFieldHiddenID);
		textFieldHiddenID.setColumns(10);

		textFieldFind = new JTextField();
		textFieldFind.setBounds(39, 253, 183, 26);
		contentPane.add(textFieldFind);
		textFieldFind.setColumns(10);

		textFieldNewName = new JTextField();
		textFieldNewName.setBounds(39, 352, 183, 26);
		textFieldNewName.setColumns(10);
		contentPane.add(textFieldNewName);

		textFieldNewBudgetOrSalary = new JTextField();
		textFieldNewBudgetOrSalary.setBounds(39, 396, 183, 26);
		textFieldNewBudgetOrSalary.setColumns(10);
		contentPane.add(textFieldNewBudgetOrSalary);

		btnAddOrRemovePro = new JButton("Add");
		btnAddOrRemovePro.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		btnAddOrRemovePro.setBounds(408, 380, 60, 29);
		contentPane.add(btnAddOrRemovePro);

		btnCreate = new JButton("Create");
		btnCreate.setBounds(394, 73, 117, 29);
		contentPane.add(btnCreate);

		btnOpenJTable = new JButton("Show all data for departments");
		btnOpenJTable.setBounds(166, 465, 212, 29);
		contentPane.add(btnOpenJTable);

		btnPrimaryFind = new JButton("Find");
		btnPrimaryFind.setBounds(49, 283, 80, 29);
		contentPane.add(btnPrimaryFind);

		btnRemove = new JButton("Remove");
		btnRemove.setBounds(128, 283, 80, 29);
		contentPane.add(btnRemove);

		btnSecondaryFind = new JButton("Find");
		btnSecondaryFind.setBounds(400, 278, 80, 29);
		contentPane.add(btnSecondaryFind);

		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(85, 424, 88, 29);
		contentPane.add(btnUpdate);

		comboBoxChangeView = new JComboBox();
		comboBoxChangeView.setBounds(427, 23, 117, 27);
		contentPane.add(comboBoxChangeView);
		comboBoxChangeView.addItem("Department");
		comboBoxChangeView.addItem("Project");
		comboBoxChangeView.addItem("Employee");

		comboBoxChooseDptOrPro = new JComboBox();
		comboBoxChooseDptOrPro.setBounds(178, 62, 183, 27);
		contentPane.add(comboBoxChooseDptOrPro);

		JLabel primaryTitleAddition = new JLabel("... or change view to");
		primaryTitleAddition.setBounds(320, 28, 103, 16);
		primaryTitleAddition.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		contentPane.add(primaryTitleAddition);

		this.setVisible(true);
	}
	// Getters
	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JLabel getLblOptional() {
		return lblOptional;
	}

	public JLabel getLblRemaining() {
		return lblRemaining;
	}

	public JLabel getLblRemainingNumber() {
		return lblRemainingNumber;
	}

	public JLabel getLblSek() {
		return lblSek;
	}

	public JLabel getLblChooseDptOrAssignToPro() {
		return lblChooseDptOrAssignToPro;
	}

	public JLabel getLblMultipleEmployeesNumber() {
		return lblMultipleEmployeesNumber;
	}

	public JLabel getLblMultipleEmployeesExisting() {
		return lblMultipleEmployeesExisting;
	}

	public JLabel getLblEnterEmpId() {
		return lblEnterEmpId;
	}

	public JLabel getLblCurrentName() {
		return lblCurrentName;
	}

	public JLabel getLblCurrentBudgetOrSalary() {
		return lblCurrentBudgetOrSalary;
	}

	public JLabel getLblCurrentProjects() {
		return lblCurrentProjects;
	}

	public JLabel getLblUnitFoundOrNotFound() {
		return lblUnitFoundOrNotFound;
	}

	public JLabel getLblUnitUpdated() {
		return lblUnitUpdated;
	}

	public JLabel getLblNewName() {
		return lblNewName;
	}

	public JLabel getLblNewBudgetOrSalary() {
		return lblNewBudgetOrSalary;
	}

	public JLabel getLblPrimaryTitle() {
		return lblPrimaryTitle;
	}

	public JLabel getLblCreateName() {
		return lblCreateName;
	}

	public JLabel getLblSecondaryTitle() {
		return lblSecondaryTitle;
	}

	public JLabel getLblDptUpdated() {
		return lblUnitUpdated;
	}

	public JLabel getLblUnitName() {
		return lblUnitName;
	}

	public JLabel getLblUnitCreated() {
		return lblUnitCreated;
	}

	public JLabel getLblCreateBudgetOrSalary() {
		return lblCreateBudgetOrSalary;
	}

	public JTextField getTextFieldHiddenID() {
		return textFieldHiddenID;
	}

	public JTextField getTextFieldFind() {
		return textFieldFind;
	}

	public JTextField getTextFieldNewName() {
		return textFieldNewName;
	}

	public JTextField getTextFieldNewBudgetOrSalary() {
		return textFieldNewBudgetOrSalary;
	}

	public JTextField getTextFieldCreateName() {
		return textFieldCreateName;
	}

	public JTextField getTextFieldCreateBudgetOrSalary() {
		return textFieldCreateBudgetOrSalary;
	}

	public JTextField getTextFieldCurrentName() {
		return textFieldCurrentName;
	}

	public JTextField getTextFieldCurrentBudgetOrSalary() {
		return textFieldCurrentBudgetOrSalary;
	}

	public JTextField getTextFieldCurrentProjects() {
		return textFieldCurrentProjects;
	}

	public JButton getBtnCreate() {
		return btnCreate;
	}

	public JButton getBtnPrimaryFind() {
		return btnPrimaryFind;
	}

	public JButton getBtnRemove() {
		return btnRemove;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public JButton getBtnOpenJTable() {
		return btnOpenJTable;
	}

	public JButton getBtnSecondaryFind() {
		return btnSecondaryFind;
	}

	public JButton getBtnAddOrRemovePro() {
		return btnAddOrRemovePro;
	}

	public JComboBox getComboBoxChooseDptOrPro() {
		return comboBoxChooseDptOrPro;
	}

	public JComboBox getComboBoxChangeView() {
		return comboBoxChangeView;
	}

	public void setListModel(DefaultListModel listModel) {
		list.setModel(listModel);
	}

	public JList getJList() {
		return list;
	}

	public DefaultListModel getListModel() {
		return (DefaultListModel) list.getModel();
	}

}
