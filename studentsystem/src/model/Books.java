//BOOK MODEL CLASS
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Books {
	private String title;
	private String edition;
	private int number=0;
	
	public Books(){
		
		Connection conn =null;
		Statement stm =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		try {
			conn = DriverManager.getConnection(url,database_name,database_password);
			stm =conn.createStatement();
			ResultSet result = stm.executeQuery("SELECT *FROM books");
			while(result.next()) {
				number++;
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	public void setTitle(String previousTitle,String newTitle) {
		//database
		Connection conn =null;
		try {
		String url ="jdbc:mysql://localhost:3306/student_system";
		String database_name ="root";
		String database_password ="";
		conn = DriverManager.getConnection(url,database_name,database_password);
		Statement data =conn.createStatement();
		ResultSet result =data.executeQuery("SELECT *FROM books");
		while(result.next()) {
			title =result.getString("title");
			if(previousTitle.equals(title)) {
				edition = result.getString("edition");
				String setInfo = "UPDATE books SET title='" + newTitle + "' WHERE edition='" + edition + "'";
				 data =conn.createStatement();
				data.executeUpdate(setInfo);
				//conn.close();
			}
		}
		
		conn.close();
	}catch (Exception e1) {
		e1.printStackTrace();
	}
		
	}
	public void setversion(String Version,String Title) {
		Connection conn =null;
		try {
				String url ="jdbc:mysql://localhost:3306/student_system";
				String database_name ="root";
				String database_password ="";
				conn = DriverManager.getConnection(url,database_name,database_password);
				Statement data =conn.createStatement();
				String setInfo = "UPDATE books SET version='" + Version + "' WHERE title='" + Title + "'";
				data.executeUpdate(setInfo);
				conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		//database
	}
	public void setISNN(String iSNN,String Title) {
		Connection conn =null;
		try {
				String url ="jdbc:mysql://localhost:3306/student_system";
				String database_name ="root";
				String database_password ="";
				conn = DriverManager.getConnection(url,database_name,database_password);
				Statement data =conn.createStatement();
				String setInfo = "UPDATE books SET isnn='" + iSNN + "' WHERE title='" + Title + "'";
				data.executeUpdate(setInfo);
				conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		//database
	}
	public void setEdition(String Edition,String Title) {
		Connection conn =null;
		try {
				String url ="jdbc:mysql://localhost:3306/student_system";
				String database_name ="root";
				String database_password ="";
				conn = DriverManager.getConnection(url,database_name,database_password);
				Statement data =conn.createStatement();
				String setInfo = "UPDATE books SET edition='" + Edition + "' WHERE title='" + Title + "'";
				data.executeUpdate(setInfo);
				conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		//database
	}
	public void setPublisher(String Publisher,String Title) {
		Connection conn =null;
		try {
				String url ="jdbc:mysql://localhost:3306/student_system";
				String database_name ="root";
				String database_password ="";
				conn = DriverManager.getConnection(url,database_name,database_password);
				Statement data =conn.createStatement();
				String setInfo = "UPDATE books SET publisher='" + Publisher + "' WHERE title='" + Title + "'";
				data.executeUpdate(setInfo);
				conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		//database
	}
	public void setImage(String imageLocation,String Title) {
		Connection conn =null;
		try {
				String url ="jdbc:mysql://localhost:3306/student_system";
				String database_name ="root";
				String database_password ="";
				conn = DriverManager.getConnection(url,database_name,database_password);
				Statement data =conn.createStatement();
				String setInfo = "UPDATE books SET image='" + imageLocation + "' WHERE title='" + Title + "'";
				data.executeUpdate(setInfo);
				conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		//database
	}
	public void addbook(String []bookdetails) {
		String url = "jdbc:mysql://localhost:3306/student_system"; // replace "mydatabase" with your actual database name
	    String username = "root"; // replace with your actual database username
	    String password = ""; // replace with your actual database password

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "INSERT INTO books (title,version,isnn,edition,publisher,image,available,reserved) VALUES (?,?, ?,?,?,?,?,?)";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.setString(1,bookdetails[0]);
	        statement.setString(2, bookdetails[1]);
	        statement.setString(3,bookdetails[2]);
	        statement.setString(4, bookdetails[3]);
	        statement.setString(5,bookdetails[4]);
	        statement.setString(6,bookdetails[5]);
	        statement.setString(7, bookdetails[6]);
	        statement.setString(8, bookdetails[7]);
	        
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
	}
	public void removebook(String title) {
		
		String url = "jdbc:mysql://localhost:3306/student_system";
	    String username = "root";
	    String password = ""; 

	    try {
	        Connection conn = DriverManager.getConnection(url, username, password);
	        String sql = "DELETE FROM books WHERE title ='"+title+"'";
	        PreparedStatement statement = conn.prepareStatement(sql);
	        statement.executeUpdate();
	        conn.close();
	    } catch (SQLException ex) {
	        ex.printStackTrace();
	    }
		//database
	}
	public void setNumberOfBooks(int numberOfBooks,String Title) {
		Connection conn =null;
		try {
				String url ="jdbc:mysql://localhost:3306/student_system";
				String database_name ="root";
				String database_password ="";
				conn = DriverManager.getConnection(url,database_name,database_password);
				Statement data =conn.createStatement();
				String setInfo = "UPDATE books SET available='" + numberOfBooks + "' WHERE title='" + Title + "'";
				data.executeUpdate(setInfo);
				conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		//database
	}

	public String[][] getBooks() {	
		Connection conn =null;
		Statement stm =null;
		ResultSet result=null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		String books[][]=new String[number][8];
		int i=0;
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery("SELECT *FROM books");
			while(result.next()){
				books[i][0]=result.getString("title");
				books[i][1]=result.getString("version");
				books[i][2]=result.getString("publisher");
				books[i][3]=result.getString("isnn");
				books[i][4]=result.getString("edition");
				books[i][5]=result.getString("image");
				books[i][6]=result.getString("available");
				books[i][7]=result.getString("reserved");
				i++;
			}
			return books;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void returnBook(String Title) {
		Connection conn= null;
		Statement stmt=null;
		String url =("jdbc:mysql://localhost:3306/student_system");
		String d_name="root";
		String d_password="";
		String sql="SELECT * FROM  books";
		try {
			conn=DriverManager.getConnection(url,d_name,d_password);
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String d_title=rs.getString("title");
				boolean reserved = rs.getBoolean("reserved");
				if(d_title.equals(Title)) {
					int available =rs.getInt("available");
					if(!reserved)
					available +=1;
					sql="UPDATE books SET available = '"+available+"' WHERE title ='"+Title+"'";
					
					stmt=conn.prepareStatement(sql);
					stmt.executeUpdate(sql);
					stmt.executeUpdate("UPDATE books SET reserved = false WHERE title ='"+Title+"'");
					
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//database
		
	}
	public String[] searchBook(String name) {
		Connection conn =null;
		Statement stm =null;
		ResultSet result =null;
		String url ="jdbc:mysql://localhost:3306/student_system";
		String d_name ="root";
		String d_password ="";
		String books[] =new String [number];//when implementint remember to add the function of substituting null
		int i =0;
		String sql ="SELECT *FROM books WHERE title LIKE '"+name+"%'";
		try {
			conn =DriverManager.getConnection(url,d_name,d_password);
			stm =conn.createStatement();
			result = stm.executeQuery(sql);
			while(result.next()) {
				books[i]=result.getString("title");
				i++;
			}
			return books;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void borrowBook(String Title) {
		Connection conn= null;
		Statement stmt=null;
		String url =("jdbc:mysql://localhost:3306/student_system");
		String d_name="root";
		String d_password="";
		String sql="SELECT * FROM  books";
		try {
			conn=DriverManager.getConnection(url,d_name,d_password);
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String d_title=rs.getString("title");
				if(d_title.equals(Title)) {
					int available =rs.getInt("available");
					if(available>0) {
						available -=1;
						sql="UPDATE books SET available = '"+available+"' WHERE title ='"+Title+"'";
						stmt=conn.prepareStatement(sql);
						stmt.executeUpdate(sql);
					}else {
					}
				}
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	public void reserveBook(String Title) {
		Connection conn =null;
		try {
				String url ="jdbc:mysql://localhost:3306/student_system";
				String database_name ="root";
				String database_password ="";
				conn = DriverManager.getConnection(url,database_name,database_password);
				Statement data =conn.createStatement();
				String setInfo = "UPDATE books SET reserved=true WHERE title='" + Title + "'";
				data.executeUpdate(setInfo);
				conn.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		//database
	}
}
