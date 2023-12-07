package course_scheduling_mvc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

public class inputDetailsModel 
{
	public int[][] getRoomValues(int roomNum)
	{
		int[][] rooms = null;
		try
		{
			Connection connectionRooms = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "harishruti");
		
			String sqlRooms = "select * from rooms";
		
			PreparedStatement preparedStatementRooms = connectionRooms.prepareStatement(sqlRooms);
			ResultSet resultSetRooms = preparedStatementRooms.executeQuery();
		
			int i=0;
			rooms = new int[roomNum][2];
			while(resultSetRooms.next())
			{
				int roomNo = resultSetRooms.getInt("room_no");
				int capacity = resultSetRooms.getInt("capacity");
				rooms[i][0]=roomNo;
				rooms[i][1]=capacity;
				i++;			
				
			}
			resultSetRooms.close();
			preparedStatementRooms.close();
			connectionRooms.close();
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return rooms;
	}
	
	public String[] getSlotValues(int numSlots)
	{
		String[] slots = null;
		try
		{
			Connection connectionSlots = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "harishruti");
		
			String sqlSlots = "select * from timeslots";
		
			PreparedStatement preparedStatementSlots = connectionSlots.prepareStatement(sqlSlots);
			ResultSet resultSetSlots = preparedStatementSlots.executeQuery();
		
			int i=0;
			slots = new String[numSlots];
			while(resultSetSlots.next())
			{
				String slt=resultSetSlots.getString("slot");
				slots[i]=slt;
				i++;			
				
			}
			
			resultSetSlots.close();
			preparedStatementSlots.close();
			connectionSlots.close();
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return slots;
	}
	
	public HashSet<String> getCourseValues()
	{
		HashSet<String> course = new HashSet<>();;
		try
		{
			Connection connectionCourse = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "harishruti");
		
			String sqlCourse = "select * from courses";
		
			PreparedStatement preparedStatementCourse = connectionCourse.prepareStatement(sqlCourse);
			ResultSet resultSetCourse = preparedStatementCourse.executeQuery();
			
			while(resultSetCourse.next())
			{
				String temp=resultSetCourse.getString("course_no");
				course.add(temp);			
				
			}
			
			resultSetCourse.close();
			preparedStatementCourse.close();
			connectionCourse.close();
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return course;
	}

}
