package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LecPrograms {
	private String program_name;
	private int number_of_lectures=0;
	public LecPrograms() {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM lecture_courses");
			while(result.next()) {
				number_of_lectures++;
				//System.out.println(number_of_lectures);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String[] getCourses(String lec_Name) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			String Details [] =new String[7];
			ResultSet rs =stm.executeQuery("SELECT *FROM lecture_courses");
			while(rs.next()) {
				program_name =rs.getString("lecture");
				if(program_name.equals(lec_Name))
				{
					
					Details[0] =rs.getString("lecture");
					Details[1] =rs.getString("course1");
					Details[2] =rs.getString("course2");
					Details[3] =rs.getString("course3");
				}
			}
			conn.close();
			return Details;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public String[][]getLec_Courses() {
		
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		String lectureC[][] =new String [number_of_lectures][4];
		int i =0;
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM lecture_courses");
			while(rs.next()) {
				lectureC[i][0]=rs.getString("lecture");
				lectureC[i][1]=rs.getString("course1");
				lectureC[i][2]=rs.getString("course2");
				lectureC[i][3]=rs.getString("course3");
				i++;
			}
			
			conn.close();
			return lectureC;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public void removelecture(String name) {
		String url = "jdbc:mysql://localhost:3306/student_system";
	    String username = "root";
	    String password = "";

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "DELETE FROM lecture_courses WHERE lecture ='"+name+"'";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	public void assignLectures(String[] enter) {
		 //System.out.println(enter[1]+"this");
			String url = "jdbc:mysql://localhost:3306/student_system"; // replace "mydatabase" with your actual database name
		    String username = "root"; // replace with your actual database username
		    String password = ""; // replace with your actual database password

		    try {
		        Connection conn = DriverManager.getConnection(url, username, password);
		        String sql = "INSERT INTO lecture_courses (lecture,course1,course2,course3) VALUES (?,?,?,?)";
		        PreparedStatement statement = conn.prepareStatement(sql);
		        statement.setString(1,enter[0]);
		        //System.out.println(enter[0]);
		        statement.setString(2, enter[1]);
		        statement.setString(3,enter[2]);
		        statement.setString(4,enter[3]);
		        statement.executeUpdate();
		        conn.close();
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		
	}
}