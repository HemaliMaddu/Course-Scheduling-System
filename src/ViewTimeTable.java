import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class ViewTimeTable extends JFrame 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel TimeTable;
	JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		try
		{
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/coursepref", "root", "hema1suma2");
		
			String sql = "select count(*) as numOfRooms from rooms ";
		
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			int numRooms=0;
			
			if(resultSet.next()) 
			{
				numRooms = resultSet.getInt("numOfRooms");
			}
			
			resultSet.close();
			preparedStatement.close();
			//connection.close();
			
			String[] timeSlots = new String[15];
			int [][] rooms= new int[numRooms][2];
			HashSet<String> course = new HashSet<>();
			
			String sql1 = "select count(*) as numOfSlots from timeslots ";
			
			PreparedStatement preparedStatement1 = connection.prepareStatement(sql1);
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			
			int numSlots = 0;
			if(resultSet1.next()) numSlots=resultSet1.getInt("numOfSlots");
			
			resultSet1.close();
			preparedStatement1.close();
			connection.close();
		
			String[][] sched = new String[numSlots][numRooms];
			for (String[] row : sched)
				Arrays.fill(row,"");		
		
			JTextArea textArea = new JTextArea();
			textArea.setBounds(62, 57, 605, 405);
			EventQueue.invokeLater(new Runnable() 
			{
				public void run() 
				{
					try 
					{
						ViewTimeTable frame = new ViewTimeTable(textArea);
						frame.setVisible(true);
					} 
					catch (Exception e) 
					{
						e.printStackTrace();
					}
				}
			});
			
			inputDetails id = new inputDetails();
			timeSlots=id.getSlotValues(numSlots);
			rooms=id.getRoomValues(numRooms);
			course=id.getCourseValues();
		
			PGWithPref pg1 = new PGWithPref();
			pg1.schedPGWithPref(timeSlots,rooms,sched,course);
		
			PGWithoutPref pg2 = new PGWithoutPref();
			pg2.schedPGWithoutPref(timeSlots,rooms,sched,course);
		
			UGWithPref pg3 = new UGWithPref();
			pg3.schedUGWithPref(timeSlots,rooms,sched,course);
		
			UGWithoutPref pg4 = new UGWithoutPref();
			pg4.schedUGWithoutPref(timeSlots,rooms,sched,course);
		
		
			textArea.append("\t\t");
			for(int i=0;i<numRooms;i++)
			{
				textArea.append(rooms[i][0]+"\t\t");
			}
			textArea.append("\n");
			for(int i=0;i<numSlots;i++)
			{
				textArea.append(timeSlots[i]+"\t\t");
				for(int j=0;j<numRooms;j++)
				{
					if(sched[i][j].equals("")) textArea.append("-\t\t");
					else textArea.append(sched[i][j]+"\t\t");
				}
				textArea.append("\n");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}

	/**
	 * Create the frame.
	 */
	public ViewTimeTable(JTextArea textArea) 
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

