import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;

public class Panel3 {

	private JFrame frmProjectScheduler;
	private JTextField staffName;
	private Project currentProject;

	public Panel3(Project project) {
		currentProject = project;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjectScheduler = new JFrame();
		frmProjectScheduler.setResizable(false);
		frmProjectScheduler.setTitle("Project Scheduler");
		frmProjectScheduler.setBounds(100, 100, 450, 300);
		frmProjectScheduler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjectScheduler.getContentPane().setLayout(null);

		JLabel lblStaffName = new JLabel("Staff Name");
		lblStaffName.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblStaffName.setBounds(26, 34, 103, 20);
		frmProjectScheduler.getContentPane().add(lblStaffName);

		JLabel lblExpert = new JLabel("Expert?");
		lblExpert.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblExpert.setBounds(26, 87, 71, 23);
		frmProjectScheduler.getContentPane().add(lblExpert);

		JLabel lblCurrentStaff = new JLabel("Current Staff");
		lblCurrentStaff.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCurrentStaff.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentStaff.setBounds(313, 11, 125, 14);
		frmProjectScheduler.getContentPane().add(lblCurrentStaff);

		JCheckBox isExpert = new JCheckBox("");
		isExpert.setBounds(86, 87, 21, 23);
		frmProjectScheduler.getContentPane().add(isExpert);

		staffName = new JTextField();
		staffName.setBounds(116, 35, 86, 20);
		frmProjectScheduler.getContentPane().add(staffName);
		staffName.setColumns(10);

		DefaultListModel<Staff> staffModel = new DefaultListModel<>();
		JList staffList = new JList(staffModel);
		staffList.setBounds(10, 136, 125, 180);
		JScrollPane staffScroll = new JScrollPane(staffList);
		staffScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(staffName.getText().isEmpty()){
					JOptionPane.showMessageDialog(frmProjectScheduler, "Staff Name Can't Be Empty!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Staff newStaff = new Staff(staffName.getText(), isExpert.isSelected());
					staffModel.addElement(newStaff);
					staffName.setText("");
					isExpert.setSelected(false);
				}
			}
		});
		btnAdd.setBounds(212, 33, 89, 23);
		frmProjectScheduler.getContentPane().add(btnAdd);

		JButton btnRemove = new JButton("Remove");
		btnRemove.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffModel.removeElement((staffList.getSelectedValue()));
			}
		});
		btnRemove.setBounds(212, 106, 89, 23);
		frmProjectScheduler.getContentPane().add(btnRemove);

		JButton btnPlanProject = new JButton("Plan Project");
		btnPlanProject.setFont(new Font("Dialog", Font.BOLD, 12));
		btnPlanProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(staffModel.isEmpty()){
					JOptionPane.showMessageDialog(frmProjectScheduler, "Staff List Can't Be Empty!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					for (int i = 0; i < staffModel.size(); i++) {
						currentProject.addStaff(staffModel.getElementAt(i));
					}
					Panel4 panel4 = new Panel4(currentProject);
					frmProjectScheduler.setVisible(false);	
				}
				
			}
		});
		
		btnPlanProject.setBounds(144, 227, 141, 23);
		frmProjectScheduler.getContentPane().add(btnPlanProject);
		
		JPanel panelStaff = new JPanel(new BorderLayout());
		panelStaff.setBounds(323, 34, 111, 149);
		panelStaff.add(staffScroll, BorderLayout.CENTER);
		frmProjectScheduler.getContentPane().add(panelStaff);

		frmProjectScheduler.setVisible(true);
	}

}
