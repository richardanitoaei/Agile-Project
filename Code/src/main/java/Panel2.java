import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class Panel2 {

	private JFrame frmProjectScheduler;
	private JTextField txtTaskName;
	private JTextField txtEstimatedTime;
	private Project currentProject;

	public Panel2(Project project) {
		currentProject = project;
		initialize();
	}
	
	private boolean isInteger(String s){
		try {
			Integer.parseInt(s);
			return true;
		} catch(NumberFormatException e){
			return false;
		}
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

		JLabel lblTaskName = new JLabel("Task Name");
		lblTaskName.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTaskName.setBounds(10, 11, 80, 21);
		frmProjectScheduler.getContentPane().add(lblTaskName);

		txtTaskName = new JTextField();
		txtTaskName.setBounds(86, 11, 86, 20);
		frmProjectScheduler.getContentPane().add(txtTaskName);
		txtTaskName.setColumns(10);

		JLabel lblIsTheTask = new JLabel("Is the task difficult?");
		lblIsTheTask.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblIsTheTask.setBounds(10, 33, 122, 21);
		frmProjectScheduler.getContentPane().add(lblIsTheTask);

		JLabel lblEstimatedTimeTo = new JLabel("Estimated time to complete in days:");
		lblEstimatedTimeTo.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblEstimatedTimeTo.setBounds(10, 54, 225, 21);
		frmProjectScheduler.getContentPane().add(lblEstimatedTimeTo);

		JLabel lblCurrentTasks = new JLabel("Current Tasks");
		lblCurrentTasks.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblCurrentTasks.setHorizontalAlignment(SwingConstants.CENTER);
		lblCurrentTasks.setBounds(303, 87, 115, 21);
		frmProjectScheduler.getContentPane().add(lblCurrentTasks);

		JLabel lblTaskPrerequisites = new JLabel("Task Prerequisites");
		lblTaskPrerequisites.setFont(new Font("Dialog", Font.PLAIN, 12));
		lblTaskPrerequisites.setHorizontalAlignment(SwingConstants.CENTER);
		lblTaskPrerequisites.setBounds(10, 87, 129, 21);
		frmProjectScheduler.getContentPane().add(lblTaskPrerequisites);

		JCheckBox chkboxisHard = new JCheckBox("");
		chkboxisHard.setBounds(137, 33, 24, 21);
		frmProjectScheduler.getContentPane().add(chkboxisHard);

		txtEstimatedTime = new JTextField();
		txtEstimatedTime.setBounds(244, 55, 42, 20);
		frmProjectScheduler.getContentPane().add(txtEstimatedTime);
		txtEstimatedTime.setColumns(10);

		DefaultListModel<Task> prerequisitesModel = new DefaultListModel<>();
		JList prerequisitesList = new JList(prerequisitesModel);
		prerequisitesList.setFont(new Font("Dialog", Font.PLAIN, 12));
		prerequisitesList.setBounds(16, 118, 103, 98);
		JScrollPane prerequisiteScroll = new JScrollPane(prerequisitesList);
		prerequisiteScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		DefaultListModel<Task> tasksModel = new DefaultListModel<>();
		JList tasksList = new JList(tasksModel);
		tasksList.setMinimumSize(new Dimension(10,10));
		tasksList.setFont(new Font("Dialog", Font.PLAIN, 12));
		tasksList.setBounds(320, 118, 104, 98);
		JScrollPane tasksScroll = new JScrollPane(tasksList);
		tasksScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		JButton btnAddPrerequisite = new JButton("Add Prerequisite");
		btnAddPrerequisite.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAddPrerequisite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prerequisitesModel.addElement((Task) tasksList.getSelectedValue());

			}
		});
		btnAddPrerequisite.setBounds(131, 126, 177, 23);
		frmProjectScheduler.getContentPane().add(btnAddPrerequisite);

		JButton btnRemove = new JButton("Remove Prerequisite");
		btnRemove.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prerequisitesModel.removeElement((prerequisitesList.getSelectedValue()));
			}
		});
		btnRemove.setBounds(131, 177, 177, 23);
		frmProjectScheduler.getContentPane().add(btnRemove);

		JButton btnAddTask = new JButton("Add Task");
		btnAddTask.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnAddTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtTaskName.getText().isEmpty()){
					JOptionPane.showMessageDialog(frmProjectScheduler, "Task Name Can't Be Empty!", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (txtEstimatedTime.getText().isEmpty()){
					JOptionPane.showMessageDialog(frmProjectScheduler, "Estimated Time Can't Be Empty!", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!isInteger(txtEstimatedTime.getText())){
					JOptionPane.showMessageDialog(frmProjectScheduler, "Estimated Time Must Be A Number!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Task currentTask = new Task(txtTaskName.getText(), chkboxisHard.isSelected(),
					Integer.parseInt(txtEstimatedTime.getText()));
					tasksModel.addElement(currentTask);
					for (int i = 0; i < prerequisitesModel.size(); i++) {
						currentTask.addPrerequisit(prerequisitesModel.getElementAt(i));
					}
					prerequisitesModel.clear();
					txtTaskName.setText("");
					chkboxisHard.setSelected(false);
					txtEstimatedTime.setText("");					
				}
			}
		});
		btnAddTask.setBounds(293, 11, 145, 21);
		frmProjectScheduler.getContentPane().add(btnAddTask);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(tasksModel.isEmpty()){
					JOptionPane.showMessageDialog(frmProjectScheduler, "Task List Can't Be Empty!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					for (int i = 0; i < tasksModel.size(); i++) {
						currentProject.addTask(tasksModel.getElementAt(i));
					}
					Panel3 panel3 = new Panel3(currentProject);
					tasksModel.clear();
					frmProjectScheduler.setVisible(false);
				}
			}
		});
		btnNext.setBounds(164, 227, 103, 23);
		frmProjectScheduler.getContentPane().add(btnNext);

		JButton removeTask = new JButton("Remove Task");
		removeTask.setFont(new Font("Dialog", Font.PLAIN, 12));
		removeTask.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tasksModel.removeElement((Task) tasksList.getSelectedValue());

			}
		});
		removeTask.setBounds(293, 53, 145, 21);
		frmProjectScheduler.getContentPane().add(removeTask);
		
		JPanel panelTasks = new JPanel(new BorderLayout());
		panelTasks.setBounds(318, 118, 103, 98);
		panelTasks.add(tasksScroll, BorderLayout.CENTER);
		frmProjectScheduler.getContentPane().add(panelTasks);
		
		JPanel panelPrerequisites = new JPanel(new BorderLayout());
		panelPrerequisites.setBounds(20, 118, 103, 98);
		panelPrerequisites.add(prerequisiteScroll, BorderLayout.CENTER);
		frmProjectScheduler.getContentPane().add(panelPrerequisites);

		frmProjectScheduler.setVisible(true);
	}
}
