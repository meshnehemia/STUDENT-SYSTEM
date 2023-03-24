package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Programmes{
	private String program_name;
	private int number_Of_programs=0;
	public Programmes() {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM programs");
			while(result.next()) {
				number_Of_programs++;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		//database
		
	}
	public String[] getCourses(String program_Name) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			String Details [] =new String[7];
			ResultSet rs =stm.executeQuery("SELECT *FROM programs");
			while(rs.next()) {
				program_name =rs.getString("title");
				if(program_name.equals(program_Name))
				{
					Details[0] =rs.getString("title");
					Details[1] =rs.getString("course1");
					Details[2] =rs.getString("course2");
					Details[3] =rs.getString("course3");
					Details[4] =rs.getString("course4");
					Details[5] =rs.getString("course5");
					Details[6] =rs.getString("students");
				}
				
			}
			conn.close();
			return Details;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public String[][]getPrograms() {
		
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		String program[][] =new String [number_Of_programs][8];
		int i =0;
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM programs");
			while(rs.next()) {
				program[i][0]=rs.getString("title");
				program[i][1]=rs.getString("code");
				program[i][2]=rs.getString("course1");
				program[i][3]=rs.getString("course2");
				program[i][4]=rs.getString("course3");
				program[i][5]=rs.getString("course4");
				program[i][6]=rs.getString("course5");
				program[i][7]=rs.getString("students");
				i++;
			}
			
			conn.close();
			return program;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public void addPrograms(String addprogram[]) {
		String url = "jdbc:mysql://localhost:3306/student_system"; // replace "mydatabase" with your actual database name
	    String username = "root"; // replace with your actual database username
	    String password = ""; // replace with your actual database password

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "INSERT INTO programs (title,course1,course2,course3,course4,course5,code,students) VALUES (?,?,?,?,?,?,?,?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1,addprogram[0]);
	        statement.setString(2, addprogram[1]);
	        statement.setString(3,addprogram[2]);
	        statement.setString(4,addprogram[3]);
	        statement.setString(5,addprogram[4]);
	        statement.setString(6,addprogram[5]);
	        statement.setString(7,addprogram[6]);
	        statement.setString(8,addprogram[7]);
	        
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	public void removeProgram(String title) {
		String url = "jdbc:mysql://localhost:3306/student_system";
	    String username = "root";
	    String password = ""; 

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "DELETE FROM programs WHERE title ='"+title+"'";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		//database
	}
	public void changeCourse(String programName,String previousCourse ,String newCourse) {
		
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn =DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM programs");
			while(rs.next()) {
				String d_title = rs.getString("title");
				if(d_title.equals(programName)) {
					for(int i =1;i<=5;i++) {
						String dname ="course"+i;
						String dCourse = rs.getString(dname);
						if(dCourse.equals(previousCourse)) {
							String setInfo = "UPDATE programs SET "+dname+"='" + newCourse + "' WHERE title ='" + programName + "'";
							stm =conn.createStatement();
							stm.executeUpdate(setInfo);
						}
					}
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setTitle(String previousName,String newName) {
		//database
		Connection conn =null;
		try {
			String url ="jdbc:mysql://localhost:3306/student_system";
			String database_name ="root";
			String database_password ="";
			conn = DriverManager.getConnection(url,database_name,database_password);
			Statement data =conn.createStatement();
			ResultSet result =data.executeQuery("SELECT *FROM programs");
			while(result.next()) {
				String program_Title =result.getString("title");
				if(previousName.equals(program_Title)) {
					 String code = result.getString("code");
					String setInfo = "UPDATE programs SET title='" + newName + "' WHERE code ='" + code + "'";
					data.executeUpdate(setInfo);
					conn.close();
					break;
				}
			}
		
		conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	public void addStudent(String programName) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM programs");
			while(rs.next()) {
				if(programName.equals(rs.getString("title"))) {
					int std = Integer.parseInt(rs.getString("students"));
					std +=1;
					//System.out.println(std);
					String update ="UPDATE programs SET students = "+std+" WHERE title ='"+programName+"'";
					stm =conn.prepareStatement(update);
					stm.executeUpdate(update);
				}
				
			}
			conn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void removestudents(String programName) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM programs");
			while(rs.next()) {
				if(programName.equals(rs.getString("title"))) {
					int std = rs.getInt("students");
					if(std!=0)
					std -=1;
					String update ="UPDATE programs SET students ='"+std+"' WHERE title ='"+programName+"'";
					stm =conn.createStatement();
					stm.executeUpdate(update);
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String[] searchProgram(String name) {
		Connection conn =null;
		Statement stm =null;
		ResultSet result =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		String course[] =new String [number_Of_programs];//when implementint remember to add the function of substituting null
		int i =0;
		String sql ="SELECT *FROM programs WHERE title LIKE '"+name+"%'";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			while(result.next()) {
				course[i]=result.getString("title");
				i++;
			}
			return course;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String[] getProgram(String coursename) {
		Connection conn =null;
		Statement stm = null;
		ResultSet result =null;
		String [] name =new String[number_Of_programs];
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password="";
		int i =0;
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			String sql = "SELECT *FROM programs";
			result = stm.executeQuery(sql);
			while(result.next()) {
				if(result.getString("course1").equals(coursename)) {
					name[i]=result.getString("title");
				}
				if(result.getString("course2").equals(coursename)) {
					name[i]=result.getString("title");
				}
				if(result.getString("course3").equals(coursename)) {
					name[i]=result.getString("title");
				}
				if(result.getString("course4").equals(coursename)) {
					name[i]=result.getString("title");
				}
				if(result.getString("course5").equals(coursename)) {
					name[i]=result.getString("title");
				}
				i++;
				
			}
			conn.close();
			return name;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
