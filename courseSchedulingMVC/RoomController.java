package course_scheduling_mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

public class RoomController {

	public void addRoom(String roomNo, String capacity) {
		try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "harishruti");
            String sql = "INSERT INTO rooms (room_no, capacity) VALUES (?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setString(1, roomNo);
            pstmt.setString(2, capacity);
            
            pstmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "room slot added successfully");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
		
	}

}
