import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

public class CoursePref {

    private JFrame frmCoursePreferencesSubmission;
    private JTextField cno;
    private JTextField expectedEnrollmentValue;
    private JTextField preferredLectureTimesValue;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CoursePref window = new CoursePref();
                    window.frmCoursePreferencesSubmission.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
    }

    public CoursePref() 
    {
        initialize();
    }

    private void initialize() 
    {
        frmCoursePreferencesSubmission = new JFrame();
        frmCoursePreferencesSubmission.setTitle("Course Preferences Submission");
        frmCoursePreferencesSubmission.setBounds(100, 100, 496, 539);
        frmCoursePreferencesSubmission.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmCoursePreferencesSubmission.getContentPane().setLayout(null);
        
        ButtonGroup buttonGroup = new ButtonGroup();

        JRadioButton pgRadioButton = new JRadioButton("PG Course");
        pgRadioButton.setBounds(226, 61, 109, 23);
        frmCoursePreferencesSubmission.getContentPane().add(pgRadioButton);

        JRadioButton ugRadioButton = new JRadioButton("UG Course");
        ugRadioButton.setBounds(337, 61, 109, 23);
        frmCoursePreferencesSubmission.getContentPane().add(ugRadioButton);
        
        buttonGroup.add(pgRadioButton);
        buttonGroup.add(ugRadioButton);
        cno = new JTextField();
        cno.setBounds(286, 119, 120, 22);
        frmCoursePreferencesSubmission.getContentPane().add(cno);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                	Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "hema1suma2");

                    String courseType;
                    if (ugRadioButton.isSelected()) {
                        courseType = "UG";
                    } else if (pgRadioButton.isSelected()) {
                        courseType = "PG";
                    } else {
                        // Handle the case where neither UG nor PG is selected, if needed.
                        courseType = ""; // or set a default value
                    }

                    String sql = "INSERT INTO " + courseType.toLowerCase() + "coursepref_info (CourseNumber, ExpectedEnrollment, PreferredLectureTimes) VALUES (?, ?, ?)";
                    PreparedStatement pstmt = con.prepareStatement(sql);
                    pstmt.setString(1, cno.getText());
                    pstmt.setString(2, expectedEnrollmentValue.getText());
                    pstmt.setString(3, preferredLectureTimesValue.getText());

                    pstmt.executeUpdate();

                    JOptionPane.showMessageDialog(null, "Course preferences added successfully");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnNewButton.setBounds(197, 313, 89, 23);
        frmCoursePreferencesSubmission.getContentPane().add(btnNewButton);

        expectedEnrollmentValue = new JTextField();
        expectedEnrollmentValue.setBounds(286, 176, 120, 22);
        frmCoursePreferencesSubmission.getContentPane().add(expectedEnrollmentValue);

        JLabel Jlabel1 = new JLabel("Enter Course Number");
        Jlabel1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Jlabel1.setBounds(40, 123, 148, 14);
        frmCoursePreferencesSubmission.getContentPane().add(Jlabel1);

        JLabel lblNewLabel_1 = new JLabel("Select Course Type");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblNewLabel_1.setBounds(40, 65, 148, 14);
        frmCoursePreferencesSubmission.getContentPane().add(lblNewLabel_1);

        JLabel Jlabel2 = new JLabel("Enter Expected Enrollment");
        Jlabel2.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Jlabel2.setBounds(40, 180, 148, 14);
        frmCoursePreferencesSubmission.getContentPane().add(Jlabel2);

        JLabel Jlabel3 = new JLabel("Enter Preferred Lecture Times");
        Jlabel3.setFont(new Font("Tahoma", Font.PLAIN, 12));
        Jlabel3.setBounds(40, 244, 191, 14);
        frmCoursePreferencesSubmission.getContentPane().add(Jlabel3);

        preferredLectureTimesValue = new JTextField();
        preferredLectureTimesValue.setBounds(286, 242, 120, 20);
        frmCoursePreferencesSubmission.getContentPane().add(preferredLectureTimesValue);
        preferredLectureTimesValue.setColumns(10);
        
        JButton generateTT = new JButton("Generate Time Table");
        generateTT.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) 
        	{
        		ViewTimeTable.main(new String[] {});
        	}
        });
        generateTT.setFont(new Font("Tahoma", Font.BOLD, 15));
        generateTT.setBounds(128, 432, 236, 31);
        frmCoursePreferencesSubmission.getContentPane().add(generateTT);
    }
}
