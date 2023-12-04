import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CoursesAvailable extends JFrame {

	private JPanel addCourses;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CoursesAvailable frame = new CoursesAvailable();
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
	public CoursesAvailable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 400);
		addCourses = new JPanel();
		addCourses.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(addCourses);
		addCourses.setLayout(null);
		
		JLabel heading = new JLabel("Add Course Details");
		heading.setFont(new Font("Tahoma", Font.BOLD, 16));
		heading.setBounds(191, 33, 159, 28);
		addCourses.add(heading);
		
		JLabel course = new JLabel("Add Course");
		course.setFont(new Font("Tahoma", Font.BOLD, 15));
		course.setBounds(84, 131, 107, 28);
		addCourses.add(course);
		
		textField = new JTextField();
		textField.setBounds(236, 136, 114, 22);
		addCourses.add(textField);
		textField.setColumns(10);
		
		JButton nextbtn = new JButton("Next");
		nextbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				CoursesAvailable ca = new CoursesAvailable();
				ca.setVisible(true);
			}
		});
		nextbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nextbtn.setBounds(116, 236, 107, 25);
		addCourses.add(nextbtn);
		
		JButton submitbtn = new JButton("Submit");
		submitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Dashboard db2 = new Dashboard();
				db2.setVisible(true);
			}
		});
		submitbtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		submitbtn.setBounds(274, 233, 88, 28);
		addCourses.add(submitbtn);
	}

}
