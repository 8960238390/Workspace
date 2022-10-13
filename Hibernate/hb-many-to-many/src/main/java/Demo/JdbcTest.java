package Demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

	public static void main(String[] args) {
		
		String url = "jdbc:mysql://127.0.0.1:3306/hb-05-many-to-many";
		String userName = "hbstudent";
		String password = "hbstudent";
		
		Connection con=null;
		
		try {
			
			con = DriverManager.getConnection(url,userName,password);
			
			if(con!=null) {
				System.out.println("Successfully connected to database...");
			}
			
		}
		catch(SQLException sqle) {
			sqle.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			
			try {
				if(con!=null) {
					con.close();
				}
			}
			catch(SQLException sqle) {
				sqle.printStackTrace();
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

}
