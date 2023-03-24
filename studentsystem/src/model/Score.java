
//model
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Score {
	
	private int number_of_courses=0;
	public Score() {

		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM scores");
			while(result.next()) {
				number_of_courses++;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void setCatScore(String student_name,String course,int score) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM scores");
			while(result.next()) {
				for(int i=1; i<6;i++) {
					String name ="course"+ i;	
					String names=name;
					String d_result = result.getString(name);
					if(d_result.equals(course)) {
						name +="_cat";
						String update = "update scores Set "+name+"='"+score+"' where reg_number='"+student_name+"' and "+names+"='"+course+"'";
						stm =conn.createStatement();
						stm.executeUpdate(update);
						break;
					}
				}		
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//database
	}
	public void setExamScore(String student_name,String course,int score) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM scores");
			while(result.next()) {
				for(int i=1; i<6;i++) {
					String name ="course"+ i;		
					String names =name;
					String d_result = result.getString(name);
					if(d_result.equals(course)) {
						name +="_exam";
						//System.out.println(name);
						//System.out.println(score);
						//System.out.println(course);
						String update = "update scores Set "+name+"='"+score+"' where reg_number='"+student_name+"' and "+names+"='"+course+"'";
						stm =conn.createStatement();
						stm.executeUpdate(update);
						break;
					}
				}		
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//database
	}
	public String[][][] getScore() {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		int k = 0;
		String scores[][][] = new String[number_of_courses][6][5];
		try {
		    conn = DriverManager.getConnection(url,database_name,database_password);
		    stm =conn.createStatement();
		    ResultSet result = stm.executeQuery("SELECT * FROM scores");
		    while(result.next()) {
		        scores[k][0][0] = result.getString("reg_number");
		        scores[k][0][1] = result.getString("average_grade");
		        scores[k][0][2] =result.getString("average_score");
		        for(int i=1; i<6; i++) {
		            String name = "course" + i;
		            scores[k][i][0] = result.getNString(name);
		            for(int j=0; j<5; j++) {
		            	name = "course" + i;
		                if(j==1)
		                    name += "_cat";
		                if(j==2)
		                    name += "_exam";
		                if(j==3)
		                    name += "_average";
		                if(j==4)
		                    name += "_grade";
		                scores[k][i][j] = result.getString(name); 
		            }
		        }
		        k++;
		    }
		    
		    conn.close();
		    return scores;
		}catch(Exception e) {
			e.printStackTrace();
		}
		//database
		return null;
	}
	public void addStudent(String studentInfo[]) {
		Connection conn =null;
		PreparedStatement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			String sql ="INSERT INTO `scores` (`reg_number`, `course1`, `course1_cat`, "
					+ "`course1_exam`, `course1_average`, `course1_grade`, `course2`, `course2_cat`,"
					+ " `course2_exam`, `course2_average`, `course2_grade`, `course3`, `course3_cat`, "
					+ "`course3_exam`, `course3_average`, `course3_grade`, `course4`, `course4_cat`,"
					+ " `course4_exam`, `course4_average`, `course4_grade`, `course5`, `course5_cat`, `course5_exam`,"
					+ " `course5_average`, `course5_grade`, `average_score`, `average_grade`)"+
					"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			stm = conn.prepareStatement(sql);
			stm.setString(1, studentInfo[0]);
			stm.setString(2, studentInfo[1]);
			stm.setString(7, studentInfo[2]);
			stm.setString(12, studentInfo[3]);
			stm.setString(17, studentInfo[4]);
			stm.setString(22, studentInfo[5]);
			for(int i=1;i<29;i++) {
				if(i !=1 &&i !=2 && i !=7 &&i !=12 && i!=17 && i!=22) {
					stm.setString(i, "0");
				}
			}
			stm.executeUpdate();
			conn.close();
		}catch(Exception e){
			e.printStackTrace();
			
		}
	}
	public void setAvaragePerUnity(String student_name,String course,int score) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM scores");
			while(result.next()) {
				for(int i=1; i<6;i++) {
					String name ="course"+ i;		
					String names =name;
					String d_result = result.getString(name);
					if(d_result.equals(course)) {
						name +="_average";
						String update = "update scores Set "+name+"='"+score+"' where reg_number='"+student_name+"' and "+names+"='"+course+"'";
						stm =conn.createStatement();
						stm.executeUpdate(update);
						break;
					}
				}		
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//database
	}
	public void setGeneralAvarage(String student_name,char score) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			String update = "update scores Set average_grade='"+score+"' where reg_number='"+student_name+"'";
			stm.executeUpdate(update);
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//database
	}
	public void setUnityGrade(String student_name,String course,char score) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM scores");
			while(result.next()) {
				for(int i=1; i<6;i++) {
					String name ="course"+ i;		
					String names =name;
					String d_result = result.getString(name);
					if(d_result.equals(course)) {
						name +="_grade";
						String update = "update scores Set "+name+"='"+score+"' where reg_number='"+student_name+"' and "+names+"='"+course+"'";
						stm =conn.createStatement();
						stm.executeUpdate(update);
						break;
					}
				}		
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		//database
	}
	public String []studentScore(String student_name){
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		String scores[]=new String[28];
		int k=2;
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			String sql ="SELECT *FROM scores";
			ResultSet result = stm.executeQuery(sql);
			
			while(result.next()) {
				if(result.getString("reg_number").equals(student_name)) {
				
					scores[0] = result.getString("reg_number");
			        scores[1] = result.getString("average_grade");
			        scores[27]=result.getString("average_score");
			        for(int i=1; i<6; i++) {
			            String name = "course" + i;
			            String d_name;
			            scores[k] = result.getString(name);
			            k++;
			            d_name = name+"_cat";
			          	scores[k] = result.getString(d_name);
			          	k++;
			            d_name = name+"_exam";
			            scores[k] = result.getString(d_name);
			            k++;
			            d_name = name+"_average";
			            scores[k] = result.getString(d_name);
			            k++;
			            d_name = name+"_grade";
			            scores[k] = result.getString(d_name); 
			            k++;
			        }
				}
	        }
	        conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return scores;
	}
	public void removeStudent(String student) {
		
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			String sql ="SELECT *FROM scores";
			ResultSet result = stm.executeQuery(sql);
			
			while(result.next()) {
				if(result.getString("reg_number").equals(student))
				{
					String info ="DELETE FROM scores WHERE reg_number='"+student+"'";
					stm =conn.createStatement();
					stm.executeUpdate(info);
				}
				
			}
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void setGeneralAvaragescores(String student_name,int score) {
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			String update = "update scores Set average_score='"+score+"' where reg_number='"+student_name+"'";
			stm.executeUpdate(update);
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
