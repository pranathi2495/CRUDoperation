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



	public static void main(String[] args) throws Exception {

		Connection con = ConnectDatabase.getConnection();
/*
		//INSERT
		try {
			PreparedStatement preparedStatement= con.prepareStatement(query);
			preparedStatement.setInt(1,6 );
			preparedStatement.setString(2,"Abhishek");
			preparedStatement.setString(3, "abhsiekvishal");
			preparedStatement.setString(4, "Abhishek Vishal");
			preparedStatement.setString(5, "abishekvishal@gmail.com");
			int rowsInserted=preparedStatement.executeUpdate();
			if(rowsInserted>0){
				System.out.println("A new user was inserted successfully!");
			}
			con.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
*/
		/*
		//SELECT
		try{
			Statement statement=con.createStatement();
			ResultSet rs=statement.executeQuery(query1);
			String userdata="";
			while (rs.next()){
				userdata=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+
						" "+rs.getString(4)+" "+rs.getString(5); //fetch data
				System.out.println(userdata);
			}
			con.close();

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		*/
/*
		//UPDATE
		try{
			PreparedStatement preparedStatement= con.prepareStatement(query2);
			preparedStatement.setString(1, "bhanu123");
			preparedStatement.setString(2, "K Bhanu Priya");
			preparedStatement.setString(3, "bhanupriya245@gmail.com");
			preparedStatement.setInt(4, 3);
			int rowsupdated=preparedStatement.executeUpdate();
			if(rowsupdated>0){
				System.out.println("An existing user was updated successfully!");
			}
			preparedStatement.close();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		*/
		
		//DELETE
		try{
			PreparedStatement preparedStatement=con.prepareStatement(query3);
			preparedStatement.setInt(1, 6);
			int rowsdeleted=preparedStatement.executeUpdate();
			if(rowsdeleted>0){
				System.out.println("A user was deleted successfully!");
			}
			con.close();
		}

		catch (SQLException e) {
			e.printStackTrace();

		}
		
	}

}
