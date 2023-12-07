package course_scheduling_mvc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;

public class PGWithPrefModel 
{
	public void schedPGWithPref(String[] timeSlots, int[][] rooms, String[][] sched,HashSet<String> course)
	{
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "harishruti");
		
			String sql = "select * from pgcoursepref_info where PreferredLectureTimes!=''";
		
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				String courseId = resultSet.getString("CourseNumber");
				int enroll = resultSet.getInt("ExpectedEnrollment");
				String pref = resultSet.getString("PreferredLectureTimes");
				
				int slot=0;
				slot=findSlot(timeSlots,pref);
				int room=0;
				room=findRoom(rooms,enroll);
				
				if(course.contains(courseId))
				{
					while(room!=-1 && slot!=-1)
					{
						if(!sched[slot][room].equals("") || room==-1 || slot==-1) break;
						else if(sched[slot][room].equals("")) sched[slot][room]=courseId;
					
					}
				}
			}		
			resultSet.close();
			preparedStatement.close();
		connection.close();
		}
	
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}
	
	public int findRoom(int[][] rooms,int enroll)
	{
		for(int i=0;i<rooms.length;i++)
		{
			if(enroll<rooms[i][1])
			{
				return i;
			}
		}
		return -1;
		
	}
	public int findSlot(String[] timeSlots, String pref)
	{
		for(int i=0;i<timeSlots.length;i++)
		{
			if(pref.equals(timeSlots[i])) return i;
		}
		return -1;
		
	}
}
