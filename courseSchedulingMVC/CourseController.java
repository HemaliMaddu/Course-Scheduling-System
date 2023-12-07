package course_scheduling_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class CourseController {

	void addCoursePref(String courseType, String courseNo, String enrollment, String pref) {
		
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "harishruti");
            String sql = "INSERT INTO " + courseType.toLowerCase() + "coursepref_info (CourseNumber, ExpectedEnrollment, PreferredLectureTimes) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, courseNo);
            pstmt.setString(2, enrollment);
            pstmt.setString(3, pref);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Course preferences added successfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
		
	}

	public void addCourseAvailable(String courseNo) {
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "harishruti");
            String sql = "INSERT INTO courses (course_no) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, courseNo);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Course added successfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
		
	}
}
