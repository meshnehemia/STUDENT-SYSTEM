package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BorrowBook {
	private int number=0;
	public BorrowBook() {
			Connection conn =null;
			Statement stm =null;
			String url ="jdbc:mysql://localhost:3306/student_system";
			String database_name ="root";
			String database_password ="";
			try {
				conn = DriverManager.getConnection(url,database_name,database_password);
				stm =conn.createStatement();
				ResultSet result = stm.executeQuery("SELECT *FROM book");
				while(result.next()) {
					number++;
				}
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public void addbook(String add[]) {
			String url = "jdbc:mysql://localhost:3306/student_system"; // replace "mydatabase" with your actual database name
		    String username = "root"; // replace with your actual database username
		    String password = ""; // replace with your actual database password

		    try {
		        Connection conn = DriverManager.getConnection(url, username, password);
		        String sql = "INSERT INTO book (title,status,borrower, reserver,booknumber) VALUES (?,?,?,?,?)";
		        PreparedStatement statement = conn.prepareStatement(sql);
		        statement.setString(1,add[0]);
		        statement.setString(2,add[1]);
		        statement.setString(3,add[2]);
		        statement.setString(4,add[3]);
		        statement.setString(5,add[4]);
		        statement.executeUpdate();
		        conn.close();
		    } catch (SQLException ex) {
		        ex.printStackTrace();
		    }
		}
	  public String[][] get_book_details(){
		  Connection conn =null;
			Statement stm =null;
			ResultSet result=null;
			String url ="jdbc:mysql://localhost:3306/student_system";
			String d_name ="root";
			String d_password ="";
			String student[][]=new String[number][5];
			int i=0;
			try {
				conn =DriverManager.getConnection(url,d_name,d_password);
				stm =conn.createStatement();
				result = stm.executeQuery("SELECT *FROM book");
				while(result.next()){
					student[i][0]=result.getString("title");
					student[i][1]=result.getString("status");
					student[i][2]=result.getString("borrower");
					student[i][3]=result.getString("reserver");
					student[i][4]=result.getString("booknumber");
					i++;
				}
				conn.close();
				return student;
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}	  
	  public void returnbook(String number) {
		  Connection conn =null;
			Statement stm =null;
			String url ="jdbc:mysql://localhost:3306/student_system";
			String d_name ="root";
			String d_password ="";
			try {
				conn =DriverManager.getConnection(url,d_name,d_password);
				stm =conn.createStatement();
				stm.executeUpdate("DELETE FROM book WHERE borrower ='"+number+"'");
				stm =conn.createStatement();
				stm.executeUpdate("DELETE FROM book WHERE reserver ='"+number+"'");
				conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	  public void confirm(String number) {
		  	Connection conn =null;
			Statement stm =null;
			String url ="jdbc:mysql://localhost:3306/student_system";
			String d_name ="root";
			String d_password ="";
			try {
				conn =DriverManager.getConnection(url,d_name,d_password);
				stm =conn.createStatement();
				stm.executeUpdate("update book set status ='checked' where borrower ='"+number+"'");
				stm =conn.createStatement();
				stm.executeUpdate("update book set status ='checked' where reserver ='"+number+"'");
				conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	  public void confirmbooknumber(String number,String lecNumber) {
		  	Connection conn =null;
			Statement stm =null;
			String url ="jdbc:mysql://localhost:3306/student_system";
			String d_name ="root";
			String d_password ="";
			try {
				conn =DriverManager.getConnection(url,d_name,d_password);
				stm =conn.createStatement();
				stm.executeUpdate("update book set booknumber ='"+number+"' where borrower ='"+lecNumber+"'");
				stm =conn.createStatement();
				stm.executeUpdate("update book set booknumber ='"+number+"' where reserver ='"+lecNumber+"'");
				conn.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
