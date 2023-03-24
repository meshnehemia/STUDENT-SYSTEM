package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdminModel extends person{
	private int number_of_admin;
	public AdminModel(){
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM admin");
			while(result.next()) {
				number_of_admin++;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void changeUserName(String Pvname, String NwName) {
		//database
				Connection conn =null;
				try {
					String url ="jdbc:mysql://localhost:3306/student_system";
					String database_name ="root";
					String database_password ="";
					conn = DriverManager.getConnection(url,database_name,database_password);
					Statement data =conn.createStatement();
					ResultSet result =data.executeQuery("SELECT *FROM admin");
					while(result.next()) {
						String pvDname =result.getString("username");
						if(Pvname.equals(pvDname)) {
							String fname = result.getString("first_name");
							String setInfo = "UPDATE admin SET username='" + NwName + "' WHERE first_name ='" + fname + "'";
							data = conn.createStatement();
							data.executeUpdate(setInfo);
						}
					}
				
				conn.close();
				}catch (Exception e1) {
					e1.printStackTrace();
				}
				
		
	}
	public void setPassword(String UserName, String NwPassword) {
		Connection conn =null;
		try {
			String url ="jdbc:mysql://localhost:3306/student_system";
			String database_name ="root";
			String database_password ="";
			conn = DriverManager.getConnection(url,database_name,database_password);
			Statement data =conn.createStatement();
			ResultSet result =data.executeQuery("SELECT *FROM admin");
			while(result.next()) {
				String pvDname =result.getString("username");
				if(UserName.equals(pvDname)) {
					String setInfo = "UPDATE admin SET password='" + NwPassword + "' WHERE username ='" + UserName + "'";
					data =conn.createStatement();
					data.executeUpdate(setInfo);
				}
			}
		
		conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	public void addAdmin(String Details[]) {
		String url = "jdbc:mysql://localhost:3306/student_system"; // replace "mydatabase" with your actual database name
	    String username = "root"; // replace with your actual database username
	    String password = ""; // replace with your actual database password

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "INSERT INTO admin (first_name,second_name,last_name,Date_of_birth,gender,username,password,work_number,email,phone,user_id,image,admins) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1,Details[0]);
	        statement.setString(2, Details[1]);
	        statement.setString(3,Details[2]);
	        statement.setString(4,Details[3]);
	        statement.setString(5,Details[4]);
	        statement.setString(6, Details[5]);
	        statement.setString(7,Details[6]);
	        statement.setString(8,Details[7]);
	        statement.setString(9,Details[8]);
	        statement.setString(10, Details[9]);
	        statement.setString(11,Details[10]);
	        statement.setString(12,Details[11]);
	        statement.setString(13,Details[12]);
	        
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	public void removeAdmin(String worknumber) {
		String url = "jdbc:mysql://localhost:3306/student_system";
	    String username = "root";
	    String password = ""; 

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "DELETE FROM admin WHERE work_number ='"+worknumber+"'";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		//database
	}
	public String[] []checkAdminList() {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		String admin[][]=new String [number_of_admin][3];
		int i =0;
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM admin");
			while(rs.next()) {
				admin[i][0]=rs.getString("first_name");
				admin[i][1]=rs.getString("last_name");
				admin[i][2]=rs.getString("image");
				i++;
			}
			
			conn.close();
			return admin;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public String getPassword(String userName) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		ResultSet result =null;
		String sql ="SELECT *FROM admin";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			while(result.next()) {
				if(result.getString("username").equals(userName)) {
					return result.getString("password");
				}
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public String[] getUserName() {
		
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		ResultSet result =null;
		int i=0;
		String Usernames[] =new String[number_of_admin];
		String sql ="SELECT *FROM admin";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			while(result.next()) {
				Usernames[i] =result.getString("username");
				i++;
			}
			conn.close();
			return Usernames;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String[] getDetails(String username) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		ResultSet result =null;
		String sql ="SELECT *FROM admin";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			String details[] =new String[11];
			while(result.next()) {
				if(result.getString("username").equals(username)) {
					details[0] =result.getString("first_name");
					details[1] =result.getString("second_name");
					details[2] =result.getString("last_name");
					details[3] =result.getString("Date_of_birth");
					details[4] =result.getString("gender");
					details[5] =result.getString("username");
					details[6] =result.getString("work_number");
					details[7] =result.getString("email");
					details[8] =result.getString("phone");
					details[9] =result.getString("user_id");
					details[10] =result.getString("image");
				}
			}
			conn.close();
			return details;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public int getNumberOfAdmin() {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		ResultSet result =null;
		int pvAdmin=0;
		String sql ="SELECT *FROM admin";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			while(result.next()) {
				int newad = result.getInt("admins");
				if(pvAdmin<newad) {
					pvAdmin =newad;
				}
			}
			return pvAdmin;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return 0;
 }
}

