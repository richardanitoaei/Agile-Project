import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Panel1 {

	private JFrame frmProjectScheduler;
	private JTextField txtProjectName;
	private JTextField txtManager;

	public Panel1() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmProjectScheduler = new JFrame();
		frmProjectScheduler.setResizable(false);
		frmProjectScheduler.setAlwaysOnTop(true);
		frmProjectScheduler.setTitle("Project Scheduler");
		frmProjectScheduler.setBounds(100, 100, 450, 300);
		frmProjectScheduler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProjectScheduler.getContentPane().setLayout(null);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtProjectName.getText().isEmpty()){
					JOptionPane.showMessageDialog(frmProjectScheduler, "Project Name Can't Be Empty!", "Error", JOptionPane.ERROR_MESSAGE);
				} else if(txtManager.getText().isEmpty()){
					JOptionPane.showMessageDialog(frmProjectScheduler, "Manager Name Can't Be Empty!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					Project currentProject = new Project(txtProjectName.getText(), txtManager.getText());
					Panel2 panel2 = new Panel2(currentProject);

					frmProjectScheduler.setVisible(false);
				}
			} 
		});
		btnNext.setBounds(154, 197, 106, 32);
		frmProjectScheduler.getContentPane().add(btnNext);

		txtProjectName = new JTextField();
		txtProjectName.setBounds(38, 87, 97, 31);
		frmProjectScheduler.getContentPane().add(txtProjectName);
		txtProjectName.setColumns(10);

		JLabel lblProjectName = new JLabel("Project Name");
		lblProjectName.setHorizontalAlignment(SwingConstants.CENTER);
		lblProjectName.setBounds(28, 66, 107, 16);
		frmProjectScheduler.getContentPane().add(lblProjectName);

		JLabel lblManagerName = new JLabel("Manager Name");
		lblManagerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblManagerName.setBounds(275, 63, 107, 19);
		frmProjectScheduler.getContentPane().add(lblManagerName);

		txtManager = new JTextField();
		txtManager.setColumns(10);
		txtManager.setBounds(275, 87, 107, 31);
		frmProjectScheduler.getContentPane().add(txtManager);

		frmProjectScheduler.setVisible(true);
	}
}
