package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.*;

public class User{

	private static JFrame frame;
	private static JPanel panel;
	private static JLabel title;
	private static JLabel loginAs;
	private static JLabel user;
	private static JLabel password;
	private static JTextField user_name;
	private static JPasswordField user_password;
	private static JButton loginButton;
	private static JButton cancelButton;
	private static JLabel forgetPassword;
	private static JComboBox<Object> box;
	public static String username;//remember during database
	public static int userId;//assign during entering to data base
	public static String logintype;//assign during entering to datebase
	public static String userpassword;//assign during entering to database
	public static void main(String[] args) {
		
		frame = new JFrame();
		
		frame.setTitle("student system");
		frame.setBounds(20,20,500,700);
		frame.getContentPane().setBackground(Color.gray);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		
		
		
		
		
		
		
		panel =new JPanel();
		panel.setBounds(20,20,450,600);
		panel.setLayout(null);
		panel.setBackground(Color.white);
		
		
		
		try {
			 // Load the image from a file
	        BufferedImage image = ImageIO.read(new File("C:\\Users\\meshack nehemia\\Desktop\\student system\\studentsystem\\src\\studentsystem\\logo.png"));
	        
	        // Resize the image to a new width and height
	        int newWidth = 80;
	        int newHeight = 80;
	        BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, image.getType());
	        Graphics2D g = resizedImage.createGraphics();
	        g.drawImage(image, 0, 0, newWidth, newHeight, null);
	        g.dispose();
	        
	        // Save the resized image to a new file
	        File output = new File("resized_image.png");
	        ImageIO.write(resizedImage, "png", output);
	        ImageIcon img =new ImageIcon(output.getAbsolutePath());
	        JLabel label =new JLabel(img);
	        label.setBounds(70,20,100,100);
	        panel.add(label);
	        System.out.println("Image resized and saved to: " + output.getAbsolutePath());
	    } catch (IOException e) {
	        System.err.println("Failed to process the image: " + e.getMessage());
	    }
			
		
		
		loginAs = new JLabel("Select one");
		loginAs.setBounds(75,120,230,50);
		loginAs.setFont(new Font("serif",Font.BOLD+Font.ITALIC,17));
		loginAs.setFont(new Font("serif",Font.ITALIC+Font.BOLD,20));
		
		String loginType[]= {"Student","Lecturer","Admin"};
		box =new JComboBox<Object>(loginType);
		box.setBounds(220,130,150,30);
		
		
		
		user = new JLabel("Enter userName");
		user.setBounds(75,180,230,50);
		user.setFont(new Font("serif",Font.BOLD+Font.ITALIC,17));
		
		
		title =new JLabel(" LOGIN /REGISTER");
		title.setBounds(220,40,190,50);
		title.setVerticalAlignment(JLabel.CENTER);
		title.setFont(new Font("serif",Font.BOLD+Font.ITALIC,20));
		title.setForeground(Color.red);
		title.setBackground(Color.cyan);
		title.setOpaque(true);
		  
		user_password =new JPasswordField();
		user_password.setBounds(220,250,150,30);
		
		password = new JLabel("Enter password");
		password.setBounds(75,240,350,50);
		password.setFont(new Font("serif",Font.BOLD+Font.ITALIC,17));
		
		user_name =new JTextField();
		user_name.setBounds(220,190,150,30);
		
		loginButton =new JButton("LOG IN");
		loginButton.setBounds(100 ,330,100,35);
		loginButton.setFocusable(false);
		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				login();
			}});
		
		cancelButton =new JButton("CANCEL");
		cancelButton.setBounds(250 ,330,100,35);
		cancelButton.setFocusable(false);
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user_name.setText("");
				user_password.setText("");
				user_name.setBorder(BorderFactory.createLineBorder(Color.black));
				user_password.setBorder(BorderFactory.createLineBorder(Color.black));
				
			}
			
		});
		
		forgetPassword =new JLabel("Forgot password ?");
		forgetPassword.setBounds(180 ,400,200,35);
		//forgetPassword.setFocusable(false);
		forgetPassword.setFont(new Font("serif",Font.ITALIC,15));
		forgetPassword.setForeground(Color.BLUE);
		forgetPassword.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        forGetPassword();
		    }
		  });

		panel.add(loginAs);
		panel.add(box);
		panel.add(cancelButton);
		panel.add(forgetPassword);
		panel.add(loginButton);
		panel.add(user_password);
		panel.add(password);
		panel.add(user_name);
		panel.add(user);
		panel.add(title);
		frame.add(panel);
		panel.setVisible(true);
		frame.setVisible(true);
		
	}
	@SuppressWarnings("deprecation")
	public static void login() {
		if(user_name.getText().isEmpty()||user_password.getPassword().length==0) {
			if(user_name.getText().isEmpty()) {
				user_name.setBorder(BorderFactory.createLineBorder(Color.RED));
			}else {
				user_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			if(user_password.getPassword().length==0) {
				user_password.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}else {
				user_password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		}else {
			username =user_name.getText().toLowerCase();
			userpassword =user_password.getText();
			String url ="jdbc:mysql://localhost:3306/student_system";
			String database_name ="root";
			String database_password ="";
			Connection conn =null;
			Statement stm =null;
			ResultSet result =null;
			logintype =(String) box.getSelectedItem();
			if(logintype=="Student") {
					try {
						conn =DriverManager.getConnection(url,database_name,database_password);
						stm = conn.createStatement();
						
						 result = stm.executeQuery("SELECT *FROM student_enrolled");
						while(result.next()) {
							String dusername =result.getString("username");
							String dpassword =result.getString("password");
							if(dusername.equals(username)) {
								
								if(dpassword.equals(userpassword)) {
									System.out.print("login successfull as a student");
									frame.setVisible(false);
									conn.close();
									//connect to student class
									System.exit(0);
								}
								user_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
								user_password.setBorder(BorderFactory.createLineBorder(Color.red));
								break;
							}	
							user_name.setBorder(BorderFactory.createLineBorder(Color.red));
							user_password.setBorder(BorderFactory.createLineBorder(Color.black));
							
							
						}
						conn.close();
						
					}catch (Exception e) {
						e.printStackTrace();
					} 
					
			}else if(logintype=="Lecturer") {
				String sql ="SELECT *FROM lecturer";
				try {
					conn =DriverManager.getConnection(url,database_name,database_password);
					stm = conn.createStatement();
					result =stm.executeQuery(sql);
					while(result.next()) {
						String dusername =result.getString("username");
						String dpassword =result.getString("password");
						if(dusername.equals(username)) {
							
							if(dpassword.equals(userpassword)) {
								System.out.print("login successfull as a lecture");
								frame.setVisible(false);
								conn.close();
								//connect to student class
								System.exit(0);
							}
							user_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							user_password.setBorder(BorderFactory.createLineBorder(Color.red));
							break;
						}	
						user_name.setBorder(BorderFactory.createLineBorder(Color.red));
						user_password.setBorder(BorderFactory.createLineBorder(Color.black));
						
						
					}
					conn.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				//confirm in database username and id if match in database 
			}else if(logintype=="Admin"){
				
				String sql ="SELECT *FROM admin";
				try {
					conn =DriverManager.getConnection(url,database_name,database_password);
					stm = conn.createStatement();
					result =stm.executeQuery(sql);
					while(result.next()) {
						String dusername =result.getString("username");
						String dpassword =result.getString("password");
						if(dusername.equals(username)) {
							
							if(dpassword.equals(userpassword)) {
								System.out.print("login successfull as a admin");
								frame.setVisible(false);
								conn.close();
								//connect to admin class
								System.exit(0);
							}
							user_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							user_password.setBorder(BorderFactory.createLineBorder(Color.red));
							break;
						}	
						user_name.setBorder(BorderFactory.createLineBorder(Color.red));
						user_password.setBorder(BorderFactory.createLineBorder(Color.black));
					}
					conn.close();
					
				}catch(Exception e) {
					e.printStackTrace();
				}
				//confirm in database username and id if match in database
			}else {
				System.exit(0);
			}
			
		}
		
	}
	public static void forGetPassword() {
		cancelButton.setVisible(false);
		password.setVisible(false);
		forgetPassword.setVisible(false);
		loginButton.setVisible(false);
		user_password.setVisible(false);
		
		JLabel id = new JLabel("Enter ID Number");
		id.setBounds(75,240,350,50);
		id.setFont(new Font("serif",Font.BOLD+Font.ITALIC,17));
		
		JLabel new_Password = new JLabel("New Password");
		new_Password.setBounds(75,300,350,50);
		new_Password.setFont(new Font("serif",Font.BOLD+Font.ITALIC,17));
		
		JLabel confirm_Password = new JLabel("Confirm Password");
		confirm_Password.setBounds(75,350,350,50);
		confirm_Password.setFont(new Font("serif",Font.BOLD+Font.ITALIC,17));
		
		JTextField user_Id =new JTextField();
		user_Id.setBounds(220,250,150,30);
		
		JPasswordField user_NewPassword =new JPasswordField();
		user_NewPassword.setBounds(220,310,150,30);
		
		JPasswordField user_ConfirmPassword =new JPasswordField();
		user_ConfirmPassword.setBounds(220,360,150,30);
		
		JButton reset =new JButton("CANCEL");
		reset.setBounds(250 ,430,100,35);
		reset.setFocusable(false);
		reset.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				user_name.setText("");
				user_Id.setText("");
				user_NewPassword.setText("");
				user_ConfirmPassword.setText("");
				user_Id.setBorder(BorderFactory.createLineBorder(Color.black));
				user_NewPassword.setBorder(BorderFactory.createLineBorder(Color.black));
				user_ConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.black));
				user_name.setBorder(BorderFactory.createLineBorder(Color.black));
			}
			
		});
		
		JButton back =new JButton(" BACK  ");
		back.setBounds(180 ,500,100,35);
		back.setFocusable(false);
		back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				main(null);
			}
			
		});
		JButton submit =new JButton("Submit");
		submit.setBounds(100 ,430,100,35);
		submit.setFocusable(false);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(user_name.getText().isEmpty()||user_Id.getText().isEmpty()||
				user_NewPassword.getPassword().length==0||user_ConfirmPassword.getPassword().length==0) {
				
					if(user_name.getText().isEmpty()) {
						user_name.setBorder(BorderFactory.createLineBorder(Color.RED));
					}else {
						user_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					if(user_Id.getText().isEmpty()) {
						user_Id.setBorder(BorderFactory.createLineBorder(Color.red));
						
					}else {
						user_Id.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					
					if(user_NewPassword.getPassword().length==0) {
						user_NewPassword.setBorder(BorderFactory.createLineBorder(Color.RED));
					}else {
						user_NewPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
					if(user_ConfirmPassword.getPassword().length==0) {
						user_ConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.red));
						
					}else {
						user_ConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}
				}else {
						@SuppressWarnings("deprecation")
						String mypassword =user_ConfirmPassword.getText();
						@SuppressWarnings("deprecation")
						String confirmpassword =user_NewPassword.getText();
					if(mypassword.equals(confirmpassword)) {
						
						user_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						user_Id.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						user_NewPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						user_ConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						//check if there is such data in database id and user name
						String id =user_Id.getText();
						String userName =user_name.getText().toLowerCase();
						@SuppressWarnings("deprecation")
						String userpassword =user_NewPassword.getText();
						String url ="jdbc:mysql://localhost:3306/student_system";
						String database_name ="root";
						String database_password ="";
						Connection conn =null;
						Statement data=null;
						logintype =(String) box.getSelectedItem();
						if(logintype=="Student") {
							
							//connection to database
							try {
								conn =DriverManager.getConnection(url,database_name,database_password);
								data =conn.createStatement();
								String getFrom ="SELECT *FROM student_enrolled";
								ResultSet result = data.executeQuery(getFrom);
								while(result.next()) {
									String d_Id = result.getString("user_id");
									String d_username =result.getString("username");
									if(d_Id.equals(id)&&d_username.equals(userName)) {
										String setInfo ="UPDATE student_enrolled SET password='" + userpassword + "' WHERE username='" + userName + "'";
										data.executeUpdate(setInfo);
										System.out.println("password changed successfull");
										frame.setVisible(false);
										conn.close();
										//connect to student class
										System.exit(0);
									}
									user_name.setBorder(BorderFactory.createLineBorder(Color.red));
									user_Id.setBorder(BorderFactory.createLineBorder(Color.red));
									
								}
								conn.close();
								
							}catch (Exception e1) {
								e1.printStackTrace();
							}
							//change in database username and id if match in database 
							System.out.println("login student");
							
						}else if(logintype=="Lecturer") {
							try {
								conn = DriverManager.getConnection(url,database_name,database_password);
								data =conn.createStatement();
								ResultSet result =data.executeQuery("SELECT *FROM lecturer");
								while(result.next()) {
									String d_Id = result.getString("user_id");
									String d_username =result.getString("username");
									if(d_Id.equals(id)&&d_username.equals(userName)) {
										String setInfo = "UPDATE lecturer SET password='" + userpassword + "' WHERE username='" + userName + "'";
										data.executeUpdate(setInfo);
										System.out.println("password changed successfull");
										frame.setVisible(false);
										conn.close();
										//connect to lecturer class
										System.exit(0);
									}
									user_name.setBorder(BorderFactory.createLineBorder(Color.red));
									user_Id.setBorder(BorderFactory.createLineBorder(Color.red));
									
								}
								
								conn.close();
							}catch (Exception e1) {
								e1.printStackTrace();
							}
						}else if(logintype=="Admin"){
							try {
								conn = DriverManager.getConnection(url,database_name,database_password);
								data =conn.createStatement();
								ResultSet result =data.executeQuery("SELECT *FROM admin");
								while(result.next()) {
									String d_Id = result.getString("user_id");
									String d_username =result.getString("username");
									if(d_Id.equals(id)&&d_username.equals(userName)) {
										String setInfo = "UPDATE admin SET password='" + userpassword + "' WHERE username='" + userName + "'";
										data.executeUpdate(setInfo);
										System.out.println("password changed successfull");
										frame.setVisible(false);
										conn.close();
										//connect to admin class
										System.exit(0);
									}
									user_name.setBorder(BorderFactory.createLineBorder(Color.red));
									user_Id.setBorder(BorderFactory.createLineBorder(Color.red));
									
								}
								
								conn.close();
							}catch (Exception e1) {
								e1.printStackTrace();
							}
						}else {
							System.exit(0);
						}
							
						}
					else {
						
						user_name.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						user_Id.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						user_NewPassword.setBorder(BorderFactory.createLineBorder(Color.BLACK));
						user_ConfirmPassword.setBorder(BorderFactory.createLineBorder(Color.RED));		
					}
					
				}
				
			}
			
		});
		panel.add(back);
		panel.add(user_ConfirmPassword);
		panel.add(user_NewPassword);
		panel.add(user_Id);
		panel.add(confirm_Password);
		panel.add(new_Password);
		panel.add(id);
		panel.add(submit);
		panel.add(reset);
		panel.repaint();
	}

}