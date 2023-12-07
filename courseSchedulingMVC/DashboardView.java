package course_scheduling_mvc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DashboardView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardView frame = new DashboardView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashboardView() {
		setTitle("Dashboard");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Submit Course Preferences");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CoursePrefView.main(new String[] {});
			}
		});
		btnNewButton.setBounds(132, 165, 199, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("View Scheduling Status");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				TimeTableController.main(new String[] {});
			}
		});
		btnNewButton_1.setBounds(132, 214, 199, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Add Room Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				RoomsView ra1 = new RoomsView();
				ra1.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(132, 28, 192, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Add Lecture Slot Details");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SlotsView ls1 = new SlotsView();
				ls1.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(132, 78, 199, 23);
		contentPane.add(btnNewButton_3);
		
		JButton button = new JButton("New button");
		button.setBounds(198, 93, 0, -3);
		contentPane.add(button);
		
		JButton btnNewButton_4 = new JButton("Add Course Details");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CoursesAvailableView csa1 = new CoursesAvailableView();
				csa1.setVisible(true);
			}
		});
		btnNewButton_4.setBounds(132, 120, 199, 23);
		contentPane.add(btnNewButton_4);
	}

}
