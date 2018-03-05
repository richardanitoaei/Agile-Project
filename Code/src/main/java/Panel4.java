import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class Panel4 {

	private JFrame frmProjectScheduler;
	private Project currentProject;

	public Panel4(Project project) {
		currentProject = project;
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		JPanel panel = new JPanel(new BorderLayout());
		String titleString = "   Project: " + currentProject.getProjectName()
				+ "                                   Manager Name: "
				+ currentProject.getProjectManager();
		panel.setBorder(new TitledBorder(new EtchedBorder(), titleString));

		JTextArea display = new JTextArea();
		display.setText(currentProject.printProject());
		display.setEditable(false);
		display.setLineWrap(false);
		display.setWrapStyleWord(false);
		display.setFont(new Font("monospaced", Font.PLAIN, 12));

		JScrollPane scroll = new JScrollPane(display);
		panel.add(scroll,BorderLayout.CENTER);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		frmProjectScheduler = new JFrame();
		frmProjectScheduler.setTitle("Project Scheduler");
		frmProjectScheduler.add(panel);
		frmProjectScheduler.setResizable(true);
		frmProjectScheduler.pack();
		frmProjectScheduler.setLocationRelativeTo(null);
		frmProjectScheduler.setVisible(true);
		frmProjectScheduler.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
