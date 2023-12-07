package course_scheduling_mvc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SlotsView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel EnterLectureSlots;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SlotsView frame = new SlotsView();
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
	public SlotsView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 400);
		EnterLectureSlots = new JPanel();
		EnterLectureSlots.setBackground(new Color(240, 240, 240));
		EnterLectureSlots.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(EnterLectureSlots);
		EnterLectureSlots.setLayout(null);
		
		JLabel EnterValidSlot = new JLabel("Enter Lecture Slot");
		EnterValidSlot.setFont(new Font("Tahoma", Font.BOLD, 15));
		EnterValidSlot.setBounds(66, 140, 141, 38);
		EnterLectureSlots.add(EnterValidSlot);
		
		textField = new JTextField();
		textField.setBounds(261, 148, 171, 27);
		EnterLectureSlots.add(textField);
		textField.setColumns(10);
		
		JButton nextBtn = new JButton("Next");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String slot=textField.getText();
				SlotsController sc =new SlotsController();
				sc.addSlot(slot);
				dispose();
				SlotsView ls = new SlotsView();
				ls.setVisible(true);
				
			}
		});
		nextBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		nextBtn.setBounds(115, 251, 109, 38);
		EnterLectureSlots.add(nextBtn);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String slot=textField.getText();
				SlotsController sc =new SlotsController();
				sc.addSlot(slot);
				dispose();
				DashboardView db1 = new DashboardView();
				db1.setVisible(true);
			}
		});
		submitBtn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		submitBtn.setBounds(256, 254, 115, 35);
		EnterLectureSlots.add(submitBtn);
		
		JLabel Heading = new JLabel("Add Lecture Slot Details");
		Heading.setFont(new Font("Tahoma", Font.BOLD, 16));
		Heading.setBounds(149, 27, 208, 38);
		EnterLectureSlots.add(Heading);
	}
}
