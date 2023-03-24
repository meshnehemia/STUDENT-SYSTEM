package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Lecturer extends person{
	private int number=0;
	public Lecturer() {
			
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM lecturer");
			while(result.next()) {
				number++;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void addLecturer(String add[]) {
		String url = "jdbc:mysql://localhost:3306/student_system"; // replace "mydatabase" with your actual database name
	    String username = "root"; // replace with your actual database username
	    String password = ""; // replace with your actual database password

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "INSERT INTO  lecturer (first_name, second_name, last_name, Date_of_birth, gender, password, lec_number, email, id, profile,number_of_lecture) VALUES (?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1,add[0]);
	        statement.setString(2,add[1]);
	        statement.setString(3,add[2]);
	        statement.setString(4,add[3]);
	        statement.setString(5,add[4]);
	        statement.setString(6,add[5]);
	        statement.setString(7,add[6]);
	        statement.setString(8,add[7]);
	        statement.setString(9,add[8]);
	        statement.setString(10,add[9]);
	        statement.setString(11,add[10]);
	        
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
  public void rmlecturer(String lec_number) {
	  String url = "jdbc:mysql://localhost:3306/student_system";
	    String username = "root";
	    String password = ""; 

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "DELETE FROM  lecturer WHERE lec_number ='"+lec_number+"'";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
  public String []search_lecturer(String name){
	  Connection conn =null;
		Statement stm =null;
		ResultSet result =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		String  lecturer[] =new String [number];//when implementint remember to add the function of substituting null
		int i =0;
		String sql ="SELECT *FROM lecturer WHERE lec_number LIKE '"+name+"%'";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			while(result.next()) {
				 lecturer[i]=result.getString("lec_number");
				i++;
			}
			return  lecturer;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
  }
  public String[][] get_Lecturer_details(){
	  Connection conn =null;
		Statement stm =null;
		ResultSet result=null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		String  lecturer[][]=new String[number][10];
		int i=0;
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery("SELECT *FROM  lecturer");
			while(result.next()){
				 lecturer[i][0]=result.getString("first_name");
				 lecturer[i][1]=result.getString("second_name");
				 lecturer[i][2]=result.getString("last_name");
				 lecturer[i][3]=result.getString("date_of_birth");
				 lecturer[i][4]=result.getString("gender");
				 lecturer[i][5]=result.getString("lec_number");
				 lecturer[i][6]=result.getString("email");
				 lecturer[i][7]=result.getString("id");
				 lecturer[i][8]=result.getString("profile");
				i++;
			}
			return  lecturer;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
  public void forgot_password( String lec_number,String NwPassword) {
	  Connection conn =null;
		try {
			String url ="jdbc:mysql://localhost:3306/student_system";
			String database_name ="root";
			String database_password ="";
			conn = DriverManager.getConnection(url,database_name,database_password);
			Statement data =conn.createStatement();
			ResultSet result =data.executeQuery("SELECT *FROM  lecturer");
			while(result.next()) {
					String setInfo = "UPDATE  lecturer SET password='" + NwPassword + "' WHERE lec_number ='" + lec_number + "'";
					data =conn.createStatement();
					data.executeUpdate(setInfo);
			}
		conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
  }
  public int	getNumberOflectures() {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		ResultSet result =null;
		int pvstudent=0;
		String sql ="SELECT *FROM lecturer";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			while(result.next()) {
				int newad = result.getInt("number_of_lecture");
				if(pvstudent<newad) {
					pvstudent =newad;
				}
			}
			return pvstudent;
	}catch(Exception e) {
		e.printStackTrace();
	}
		return 0;
  }
  public String getPassword(String lec_number) {
	  Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		ResultSet result =null;
		String sql ="SELECT *FROM lecturer";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			while(result.next()) {
				if(result.getString("lec_number").equals(lec_number)) {
					String password =result.getString("password");
					conn.close();
					return password;
				}
			}
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
		String Usernames[] =new String[number];
		String sql ="SELECT *FROM lecturer";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			while(result.next()) {
				Usernames[i] =result.getString("lec_number");
				i++;
			}
			conn.close();
			return Usernames;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
 }

