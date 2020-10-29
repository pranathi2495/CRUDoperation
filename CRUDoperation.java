import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CRUDoperation {

	private static String query = "INSERT INTO student (student_id, username, password,fullname,email) "
			+ "VALUES (?, ?, ?, ?, ?)"; //INSERT
	private static  String query1="Select * from student";//SELECT
	private static String query2="UPDATE student SET password=?, fullname=?, email=? WHERE student_id=?";//UPDATING
	private static String query3 = "DELETE FROM student WHERE student_id=?";//DELETING
	private static String query4="select username from student where student_id=2";



	public static void insertuser(){
		try(Connection connection=ConnectDatabase.getConnection();
				PreparedStatement preparedstatement = connection.prepareStatement(query);){
			preparedstatement.setInt(1,6 );
			preparedstatement.setString(2,"Abhishek");
			preparedstatement.setString(3, "abhsiekvishal");
			preparedstatement.setString(4, "Abhishek Vishal");
			preparedstatement.setString(5, "abishekvishal@gmail.com");
			preparedstatement.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		

	}

	public static boolean updateuser() throws Exception{
		boolean rowsupdated;
		try(Connection connection=ConnectDatabase.getConnection();
				PreparedStatement preparedStatement= connection.prepareStatement(query2);)	{		
			preparedStatement.setString(1, "bhanu123");
			preparedStatement.setString(2, "K Bhanu Priya");
			preparedStatement.setString(3, "bhanupriya245@gmail.com");
			preparedStatement.setInt(4, 3);
			rowsupdated=preparedStatement.executeUpdate()>0;
			System.out.println("An existing user was updated successfully");

		}
		return rowsupdated;
		
	}
	
	

	public static void selectAlluser(){
		try(Connection connection=ConnectDatabase.getConnection();
				Statement Statement= connection.createStatement();){
			ResultSet rs=Statement.executeQuery(query1);
			String userdata="";
			while(rs.next()){
				userdata=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+
						" "+rs.getString(4)+" "+rs.getString(5); //fetch data
				System.out.println(userdata); 
				
			}
			connection.close();
			Statement.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static void selectuser(){
		try(Connection connection=ConnectDatabase.getConnection();
				Statement Statement= connection.createStatement();){
			ResultSet rs=Statement.executeQuery(query4);
			while(rs.next()){
				String name =rs.getString("username");  // where conditiom
				System.out.println(name);
				
			}
			connection.close();
			Statement.close();

		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static boolean deleteuser() throws Exception{
		boolean rowdeleted;
		try(Connection connection=ConnectDatabase.getConnection();
				PreparedStatement preparedStatement=connection.prepareStatement(query3);){
			preparedStatement.setInt(1, 5);
			rowdeleted=preparedStatement.executeUpdate()>0;
			System.out.println("A user was deleted successfully!");
		}
		return rowdeleted;
		
		
	}


	public static void main(String[] args) throws Exception {
	
		//insertuser();
		//update();
		//selectAlluser();
		selectuser();
		//deleteuser();
	
		


	}



}


