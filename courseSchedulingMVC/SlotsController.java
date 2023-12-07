package course_scheduling_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class SlotsController {

	public void addSlot(String slot) {
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "harishruti");
            String sql = "INSERT INTO timeslots (slot) VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, slot);
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "time slot added successfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
		
	}

}
