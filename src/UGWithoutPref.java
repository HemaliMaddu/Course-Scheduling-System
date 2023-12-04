import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashSet;

public class UGWithoutPref 
{
	public void schedUGWithoutPref(String[] timeSlots, int[][] rooms, String[][] sched,HashSet<String> course)
	{
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "hema1suma2");
		
			String sql = "select * from ugcoursepref_info where PreferredLectureTimes=''";
		
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
		
			while(resultSet.next())
			{
				String courseId = resultSet.getString("CourseNumber");
				int enroll = resultSet.getInt("ExpectedEnrollment");
				
				if(course.contains(courseId)) allot(courseId,enroll,sched,rooms);
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
	
	public void allot(String courseId,int enroll,String[][] sched,int[][] rooms)
	{
		for(int i=0;i<sched.length;i++)
		{
			for(int j=0;j<rooms.length;j++)
			{
				if((sched[i][j].equals("")) && (enroll<=rooms[j][1]))
				{
					sched[i][j]=courseId;
					return;
				}
			}
		}
		
	}
	
}
