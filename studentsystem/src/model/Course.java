
//modeling the course
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Course {
	private String course_Code;
	private String course_Title;
	private int number_of_courses=0;
	
	public Course(){
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM courses");
			while(result.next()) {
				number_of_courses++;
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
			ResultSet result =data.executeQuery("SELECT *FROM courses");
			while(result.next()) {
				course_Title =result.getString("title");
				if(previousName.equals(course_Title)) {
					course_Code = result.getString("code");
					String setInfo = "UPDATE courses SET title='" + newName + "' WHERE code ='" + course_Code + "'";
					data.executeUpdate(setInfo);
				}
			}
		
		conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	public void setCode(String code,String courseName) {
		Connection conn =null;
		try {
			String url ="jdbc:mysql://localhost:3306/student_system";
			String database_name ="root";
			String database_password ="";
			conn = DriverManager.getConnection(url,database_name,database_password);
			Statement data =conn.createStatement();
			String setInfo = "UPDATE courses SET code='" + code + "' WHERE title='" + courseName + "'";
			data.executeUpdate(setInfo);
			conn.close();
		}catch (Exception e1) {
				e1.printStackTrace();
		}
		//database
	}
	
	public void addStudents(String courseName) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM courses");
			while(rs.next()) {
				if(courseName.equals(rs.getString("title"))) {
					int std = rs.getInt("students");
					std +=1;
					String update ="UPDATE courses SET students ='"+std+"' WHERE title ='"+courseName+"'";
					stm =conn.createStatement();
					stm.executeUpdate(update);
				}
				
			}
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public void removeStudents(String courseName) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM courses");
			while(rs.next()) {
				if(courseName.equals(rs.getString("title"))) {
					int std = Integer.parseInt(rs.getString("students"));
					std -=1;
					String update ="UPDATE courses SET students ='"+std+"' WHERE title ='"+courseName+"'";
					stm =conn.createStatement();
					stm.executeUpdate(update);
				}
				
			}
			conn.close();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	public void addLecturer(String courseName) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM courses");
			while(rs.next()) {
				if(courseName.equals(rs.getString("title"))) {
					int std = Integer.parseInt(rs.getString("lectures"));
					std +=1;
					//System.out.println(std);
					String update ="UPDATE courses SET lectures = "+std+" WHERE title ='"+courseName+"'";
					stm =conn.prepareStatement(update);
					stm.executeUpdate(update);
				}
				
			}
			conn.close();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		
	}
	public void removeLecturer(String courseName) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM courses");
			while(rs.next()) {
				if(courseName.equals(rs.getString("title"))) {
					int std = rs.getInt("lectures");
					std -=1;
					String update ="UPDATE courses SET lectures ='"+std+"' WHERE title ='"+courseName+"'";
					stm =conn.createStatement();
					stm.executeUpdate(update);
				}
			}
			conn.close();
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public String[] searchCourse(String name) {
		Connection conn =null;
		Statement stm =null;
		ResultSet result =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		String course[] =new String [number_of_courses];//when implementint remember to add the function of substituting null
		int i =0;
		String sql ="SELECT *FROM courses WHERE title LIKE '"+name+"%'";
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
	public String[] searchCode(String name) {
		Connection conn =null;
		Statement stm =null;
		ResultSet result =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		String course[] =new String [number_of_courses];//when implementint remember to add the function of substituting null
		int i =0;
		String sql ="SELECT *FROM courses WHERE code LIKE '"+name+"%'";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			while(result.next()) {
				course[i]=result.getString("code");
				i++;
			}
			return course;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String [] getcourseDetails(String Title) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			String Details [] =new String[4];
			ResultSet rs =stm.executeQuery("SELECT *FROM courses");
			while(rs.next()) {
				course_Title =rs.getString("title");
				if(course_Title.equals(Title))
				{
					Details[0] =rs.getString("title");
					Details[1] =rs.getString("code");
					Details[2] =rs.getString("students");
					Details[3] =rs.getString("lectures");
				}
				
			}
			conn.close();
			return Details;
			
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}
	public String[][] getCourses() {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		String courses[][] =new String [number_of_courses][4];
		int i =0;
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet rs =stm.executeQuery("SELECT *FROM courses");
			while(rs.next()) {
				courses[i][0]=rs.getString("title");
				courses[i][1]=rs.getString("code");
				courses[i][2]=rs.getString("students");
				courses[i][3] =rs.getString("lectures");
				i++;
			}
			
			conn.close();
			return courses;
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		return null;
	}
	public void addcourse(String []course) {
		String url = "jdbc:mysql://localhost:3306/student_system"; // replace "mydatabase" with your actual database name
	    String username = "root"; // replace with your actual database username
	    String password = ""; // replace with your actual database password

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "INSERT INTO courses (title,code,students,lectures) VALUES (?,?,?,?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1,course[0]);
	        statement.setString(2, course[1]);
	        statement.setString(3,course[2]);
	        statement.setString(4,course[3]);
	        
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	public void removecourse(String title) {
		
		String url = "jdbc:mysql://localhost:3306/student_system";
	    String username = "root";
	    String password = ""; 

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "DELETE FROM courses WHERE title ='"+title+"'";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	    public String getcoursecode(String name) {
	    	Connection conn =null;
			Statement stm =null;
			ResultSet result =null;
			String url ="jdbc:mysql://localhost:3306/student_system";
			String d_name ="root";
			String d_password ="";
			String sql ="SELECT *FROM courses";
			try {
				conn =DriverManager.getConnection(url,d_name,d_password);
				stm =conn.createStatement();
				result = stm.executeQuery(sql);
				while(result.next()) {
					if(result.getString("title").equals(name)) {
						return result.getString("code");
					}
				}
				
			}catch (Exception e) {
				e.printStackTrace();
			}
				return null;	   
			}
}
