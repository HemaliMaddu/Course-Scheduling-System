package course_scheduling_mvc;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TimeTableView extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel TimeTable;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public TimeTableView(JTextArea textArea) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 547);
		TimeTable = new JPanel();
		TimeTable.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(TimeTable);
		TimeTable.setLayout(null);
        
        
        this.textArea=textArea;
        textArea.setBounds(62, 57, 605, 405);
        TimeTable.add(textArea);

	}

}
