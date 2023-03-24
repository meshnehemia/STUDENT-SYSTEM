package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Initialize {
	public static void main(String[] args) {
		
		//this starts the operations
		new  UserView();
		
		
		
		//to create database and tables and for the login if there where no previous
		//sets the first addmin to username to admin/1/23
		//password is 1234 for the firstlogin.
		//for this program to work well place this folder/workspace in the desktop
		try {
			prepareDatabase();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	//initialization model
	//for the first time login in initialize this statements to create the database name and there corresponding tables

	public static void prepareDatabase() throws SQLException {
	
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306";
		String database_name ="root";
		String database_password ="";
		try {
			conn =DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			stm.execute("create database if not exists student_system");
		}catch(Exception e) {
			e.printStackTrace();
		}
		 url ="jdbc:mysql://localhost:3306/student_system";
		 conn = DriverManager.getConnection(url, database_name,database_password);
	     String sql = "CREATE TABLE IF NOT EXISTS admin(first_name varchar(30),second_name varchar(30),last_name varchar(30),Date_of_birth varchar(30),gender varchar(30),username varchar(30),password varchar(30),work_number varchar(30),email varchar(100),phone varchar(30),user_id varchar(30),image varchar(255),admins varchar(30))";
	     stm =conn.createStatement(); 
	     stm.execute(sql);
	     
	    // conn = DriverManager.getConnection(url, database_name,database_password);
	     sql = "CREATE TABLE IF NOT EXISTS books (title varchar(30),version varchar(30),isnn varchar(30),edition varchar(30),publisher varchar(30),image varchar(255),available varchar(30),reserved varchar(30))";
	     stm =conn.createStatement(); 
	     stm.execute(sql);
	     
	     
	     sql = "CREATE TABLE IF NOT EXISTS book (title varchar(30),status varchar(30),borrower varchar(30), reserver varchar(30),booknumber varchar(30))";
	     stm =conn.createStatement(); 
	     stm.execute(sql);
	     
	     sql = "CREATE TABLE IF NOT EXISTS courses (title varchar(30),code varchar(30),students varchar(30),lectures varchar(30))";
	     stm =conn.createStatement(); 
	     stm.execute(sql);
	     
	     
	     
	     sql = "CREATE TABLE IF NOT EXISTS lecture_courses (lecture varchar(30),course1 varchar(30),course2 varchar(30),course3 varchar(30))";
	     stm =conn.createStatement(); 
	     stm.execute(sql);
	     
	     
	     sql = "CREATE TABLE IF NOT EXISTS lecturer (first_name varchar(30), second_name varchar(30), last_name varchar(30), Date_of_birth varchar(30), gender varchar(30), password varchar(30), lec_number varchar(30), email varchar(100), id varchar(30), profile varchar(255),number_of_lecture varchar(30))";
	     stm =conn.createStatement(); 
	     stm.execute(sql);
	     
	     
	     
	     sql = "CREATE TABLE IF NOT EXISTS librarian (first_name varchar(30), second_name varchar(30), last_name varchar(30), Date_of_birth varchar(30), gender varchar(30), password varchar(30), worknumber varchar(30), email varchar(30), id varchar(30),profile varchar(255),number varchar(30))";
	     stm =conn.createStatement(); 
	     stm.execute(sql);
	     
	     sql = "CREATE TABLE IF NOT EXISTS programs (title varchar(30),course1 varchar(30),course2 varchar(30),course3 varchar(30),course4 varchar(30),course5 varchar(30),code varchar(30),students varchar(30))";
	     stm =conn.createStatement(); 
	     stm.execute(sql);
	     
	     
	     sql ="CREATE TABLE IF NOT EXISTS scores (reg_number varchar(30), course1 varchar(30), course1_cat varchar(30), "
					+ "course1_exam varchar(30), course1_average varchar(30), course1_grade varchar(30), course2 varchar(30),course2_cat varchar(30),"
					+ "course2_exam varchar(30),course2_average varchar(30),course2_grade varchar(30),course3 varchar(30),course3_cat varchar(30), "
					+ "course3_exam varchar(30),course3_average varchar(30),course3_grade varchar(30),course4 varchar(30),course4_cat varchar(30),"
					+ " course4_exam varchar(30),course4_average varchar(30),course4_grade varchar(30),course5 varchar(30),course5_cat varchar(30),course5_exam varchar(30),"
					+ "course5_average varchar(30),course5_grade varchar(30),average_score varchar(30),average_grade varchar(30))";
	     stm =conn.createStatement(); 
	     stm.execute(sql);
	     
	     sql = "CREATE TABLE IF NOT EXISTS student (first_name varchar(30), second_name varchar(30), last_name varchar(30), Date_of_birth varchar(30), gender varchar(30), password varchar(30), admission_number varchar(30), email varchar(30), id varchar(30),programe varchar(30), profile varchar(30),numberofstd varchar(30))";
	     stm =conn.createStatement(); 
	     stm.execute(sql);
	     
	     stm =conn.createStatement();
	     ResultSet rs= stm.executeQuery("SELECT *FROM admin");
	     String check =null;
	     while(rs.next()) {
	    	 check =rs.getString("work_number");
	     }
	     if(check==null) {
	    	 String addnew ="INSERT INTO `admin` (`first_name`, `second_name`, `last_name`, `Date_of_birth`, `gender`, `username`, `password`, `work_number`, `email`, `phone`, `user_id`, `image`, `admins`) VALUES ('meshack', 'nehemia', 'nyaruati', '2022-3-4', 'male', 'admin/1/23', '1234', 'admin/1/23', 'meshnehemia7@gmail.com', '+254757316903', '12345678', 'photos/addadmin.png', '1')";
	    	 stm =conn.createStatement(); 
		     stm.executeUpdate(addnew);
	     } 
	}

}
