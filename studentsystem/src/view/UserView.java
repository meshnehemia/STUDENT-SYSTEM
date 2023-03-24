package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.SoftBevelBorder;

import controller.UserController;

public class UserView{
	String key2="";
	JLabel label = new JLabel("    changed sucessful go back and login now");
	private JFrame frame ;
	private JPanel panel1;
	private JPanel panel2;
	private JLabel Laddmision;
	private JLabel Lpassword;
	private JPasswordField password;
	private JPasswordField confirm_password;
	private JTextField taddmission;
	private JTextField tId;
	private JButton login;
	private JButton cancel;
	private JButton Back;
	private JComboBox<Object> loginAs;
	private JLabel LloginAs;
	
	private JLabel forget;
	UserController user =new UserController();
	private ImageIcon image;
	public UserView() {
		@SuppressWarnings("unused")
		UserController users =new UserController();
		image =new ImageIcon("photos\\logo.png");
		
		frame =new JFrame();
		frame.setBounds(100,50,1000,600);
		frame.setResizable(false);
		frame.setIconImage(image.getImage());
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("Welcome to chuka university please login to continue");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1 =new JPanel();
		panel1.setBounds(10,10,400,540);
		panel1.setBackground(Color.lightGray);
		SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.white, Color.white);
		panel1.setBorder(border);
		panel1.setLayout(null);
		
		String icon = user.resizeEmage("photos\\logo.png",80, 80,"loginlogo");
		ImageIcon img =new ImageIcon(icon);
		JLabel label =new JLabel(img);
        label.setBounds(5,20,100,100);
        panel1.add(label);
		JLabel title =new JLabel("welcome to chuka university");
		title.setBounds(130,20,300,50);
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,18));
		JLabel title1 =new JLabel("LOGIN TO CONTINUE");
		title1.setBounds(130,60,300,50);
		title1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC+Font.ROMAN_BASELINE,18));
		
		LloginAs =new JLabel("Login Type");
		LloginAs.setBounds(20 ,70,200,200);
		LloginAs.setFont(new Font("Arial",Font.ITALIC,16));
	
		
		String list [] = {"student","lecturer","admin","librarian"};
		loginAs = new JComboBox<Object>(list);
		loginAs.setBounds(190 ,155,180,30);
		loginAs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(loginAs.getSelectedItem()=="admin") {
					Laddmision.setText("administration number");
				}else if(loginAs.getSelectedItem()=="lecturer") {
					Laddmision.setText("lecture number");
				}else if(loginAs.getSelectedItem()=="student") {
					Laddmision.setText("Admission Number");
				}else {
					Laddmision.setText("library Number");
				}
			}
			
		});
		
		Laddmision = new JLabel("Admission Number");
		Laddmision.setBounds(20 ,135,200,200);
		Laddmision.setFont(new Font("Arial",Font.ITALIC,16));
		
		taddmission =new JTextField();
		taddmission.setBounds(190 ,220,180,30);
		
		Lpassword =new JLabel("Enter  Password");
		Lpassword.setBounds(20 ,200,200,200);
		Lpassword.setFont(new Font("Arial",Font.ITALIC,16));
		
		password =new JPasswordField();
		password.setBounds(190 ,290,180,30);
		
		

		
		login =new JButton("Login");
		login.setBounds(80,350,100,30);
		login.setFocusable(false);
		login.setBackground(Color.MAGENTA);
		login.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
            	login();
			}
		});
		
		cancel =new JButton("Cancel");
		cancel.setBounds(260,350,100,30);
		cancel.setFocusable(false);
		cancel.setBackground(Color.MAGENTA);
		tId =new JTextField();
		confirm_password =new JPasswordField();
		cancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				taddmission.setText("");
				password.setText("");
				tId.setText("");
				confirm_password.setText("");
				taddmission.setBorder(BorderFactory.createLineBorder(Color.black));
				password.setBorder(BorderFactory.createLineBorder(Color.black));
				tId.setBorder(BorderFactory.createLineBorder(Color.black));
				confirm_password.setBorder(BorderFactory.createLineBorder(Color.black));
				
			}
			
		});
		
		forget =new JLabel("     forget password ? please click to change");
		forget.setBounds(80,400,280, 30);
		forget.setForeground(Color.white);
		forget.setBackground(Color.red);
		forget.setOpaque(true);
		forget.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	forget.setVisible(false);
		    	forGetPassword();
		    	
		    }
		  });
		
		panel2 =new JPanel();
		panel2.setBounds(430,10,535,538);
		JLabel title21 =new JLabel("THE WORLD MOST RESPECTED UNIVERSITY");
		title21.setFont(new Font("Areal",Font.BOLD+Font.ITALIC,23));
		title21.setBounds(2,20,500,30);
		title21.setForeground(Color.red);
		ImageIcon img1 =new ImageIcon("photos\\Screenshot (30).png");
		JLabel image21 =new JLabel(img1);
		image21.setBackground(Color.gray);
		image21.setBounds(-3,100,535,500);
		panel2.add(image21);
		panel2.setBackground(Color.gray);
		//SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.white, Color.white);
		panel2.setBorder(border);
		panel2.setLayout(null);
		
		panel2.add(title21);
		panel1.add(forget);
		panel1.add(cancel);
		panel1.add(login);
		panel1.add(LloginAs);
		panel1.add(loginAs);
		panel1.add(password);
		panel1.add(Lpassword);
		panel1.add(taddmission);
		panel1.add(Laddmision);
		panel1.add(title1);
		panel1.add(title);
		frame.add(panel2);
		frame.add(panel1);
		frame.setVisible(true);
	}
	public  void login() {
		if(taddmission.getText().isEmpty()||password.getPassword().length==0) {
			if(taddmission.getText().isEmpty()) {
				taddmission.setBorder(BorderFactory.createLineBorder(Color.RED));
				}else {
				taddmission.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
			if(password.getPassword().length==0) {
				password.setBorder(BorderFactory.createLineBorder(Color.red));
				
			}else {
				password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			}
		}else {
			password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			taddmission.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			String logintype =(String) loginAs.getSelectedItem();
			if(logintype=="student") {
				@SuppressWarnings("deprecation")
				String response = user.loginAsStudent(taddmission.getText(),password.getText());
				if(response=="username") {
					taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
					label.setText("    that user name does not exist in the database");
					label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
					label.setForeground(Color.white);
					label.setBackground(Color.BLACK);
					label.setBounds(5,50,500,50);
					label.setOpaque(true);
					panel2.add(label);
					panel2.repaint();
				}else if(response=="password"){
					taddmission.setBorder(BorderFactory.createLineBorder(Color.blue));
					password.setBorder(BorderFactory.createLineBorder(Color.red));
					label.setText("    you have entered the wrog password ");
					label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
					label.setForeground(Color.white);
					label.setBackground(Color.BLACK);
					label.setBounds(5,50,500,50);
					label.setOpaque(true);
					panel2.add(label);
					panel2.repaint();
				}else {
					
					frame.setVisible(false);
					user.transferToStudent(taddmission.getText());
				}
				
			}
			else if(logintype=="lecturer") {
				
				@SuppressWarnings("deprecation")
				String response = user.loginAslecture(taddmission.getText(),password.getText());
				if(response=="username") {
					taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
					label.setText("    that user name does not exist in the database");
					label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
					label.setForeground(Color.white);
					label.setBackground(Color.BLACK);
					label.setBounds(5,50,500,50);
					label.setOpaque(true);
					panel2.add(label);
					panel2.repaint();
				}else if(response=="password"){
					taddmission.setBorder(BorderFactory.createLineBorder(Color.blue));
					password.setBorder(BorderFactory.createLineBorder(Color.red));
					label.setText("    you have entered the wrog password ");
					label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
					label.setForeground(Color.white);
					label.setBackground(Color.BLACK);
					label.setBounds(5,50,500,50);
					label.setOpaque(true);
					panel2.add(label);
					panel2.repaint();
				}else {
					
					frame.setVisible(false);
					user.transferToLecturer(taddmission.getText());
				}
				
		}else if(logintype=="librarian") {
				
				@SuppressWarnings("deprecation")
				String response = user.loginAsLibrarian(taddmission.getText(),password.getText());
				if(response=="username") {
					taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
					label.setText("    that user name does not exist in the database");
					label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
					label.setForeground(Color.white);
					label.setBackground(Color.BLACK);
					label.setBounds(5,50,500,50);
					label.setOpaque(true);
					panel2.add(label);
					panel2.repaint();
				}else if(response=="password"){
					taddmission.setBorder(BorderFactory.createLineBorder(Color.blue));
					password.setBorder(BorderFactory.createLineBorder(Color.red));
					label.setText("    you have entered the wrog password ");
					label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
					label.setForeground(Color.white);
					label.setBackground(Color.BLACK);
					label.setBounds(5,50,500,50);
					label.setOpaque(true);
					panel2.add(label);
					panel2.repaint();
				}else {
					
					frame.setVisible(false);
					user.transferToLibrary(taddmission.getText());
				}
				
		}else if(logintype=="admin"){
			@SuppressWarnings("deprecation")
			String response = user.loginAsAdmin(taddmission.getText(),password.getText());
			if(response=="username") {
				taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
				label.setText("    that user name does not exist in the database");
				label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
				label.setForeground(Color.white);
				label.setBackground(Color.BLACK);
				label.setBounds(5,50,500,50);
				label.setOpaque(true);
				panel2.add(label);
				panel2.repaint();
			}else if(response=="password"){
				taddmission.setBorder(BorderFactory.createLineBorder(Color.blue));
				password.setBorder(BorderFactory.createLineBorder(Color.red));
				label.setText("    you have entered the wrog password ");
				label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
				label.setForeground(Color.white);
				label.setBackground(Color.BLACK);
				label.setBounds(5,50,500,50);
				label.setOpaque(true);
				panel2.add(label);
				panel2.repaint();
			}else {
				frame.setVisible(false);
				user.transferToAdmin(taddmission.getText());
			}
			
		}
	}
	
}
	public void forGetPassword() {
		login.setVisible(false);
		cancel.setBounds(280,500,100,30);
		Back =new JButton("Back");
		Back.setBounds(150,500,100,30);
		Back.setFocusable(false);
		Back.setBackground(Color.MAGENTA);
		Back.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new UserView();
				
			}
			
		});
		Lpassword.setBounds(20 ,270,200,200);
		password.setBounds(190,350,180,30);
		JLabel id = new JLabel("Enter your id");
		id.setBounds(20 ,200,200,200);
		id.setFont(new Font("Arial",Font.ITALIC,16));
		tId.setBounds(190 ,290,180,30);
		tId.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {	
				if(e.getKeyCode()==8) {
					key2=tId.getText();
				}
			else if((e.getKeyChar()=='0'||e.getKeyChar()=='1'||e.getKeyChar()=='2'||e.getKeyChar()=='3'||
							e.getKeyChar()=='4'||e.getKeyChar()=='5'||e.getKeyChar()=='6'||e.getKeyChar()=='7'||
							e.getKeyChar()=='8'||e.getKeyChar()=='9')&&(tId.getText().length()<=8)) {
						key2 =key2 + e.getKeyChar();
					}
					tId.setText(key2);
			}
			
		});
		
		JLabel confirmpassword =new JLabel("Confirm_password");
		confirmpassword.setBounds(20 ,340,200,200);
		confirmpassword.setFont(new Font("Arial",Font.ITALIC,16));
		confirm_password.setBounds(190 ,420,180,30);
		
		JButton reset =new JButton("reset");
		reset.setBounds(20,500,100,30);
		reset.setFocusable(false);
		reset.setBackground(Color.MAGENTA);
		reset.addActionListener(new ActionListener() {

			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(taddmission.getText().isEmpty()||tId.getText().isEmpty()||
						password.getPassword().length==0||confirm_password.getPassword().length==0) {
						
							if(taddmission.getText().isEmpty()) {
								taddmission.setBorder(BorderFactory.createLineBorder(Color.RED));
							}else {
								taddmission.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							}
							if(tId.getText().isEmpty()) {
								tId.setBorder(BorderFactory.createLineBorder(Color.red));
								
							}else {
								tId.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							}
							
							if(password.getPassword().length==0) {
								password.setBorder(BorderFactory.createLineBorder(Color.RED));
							}else {
								password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							}
							if(confirm_password.getPassword().length==0) {
								confirm_password.setBorder(BorderFactory.createLineBorder(Color.red));
								
							}else {
								confirm_password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							}
						}else {
							if(confirm_password.getText().equals(password.getText())) {
								
								taddmission.setBorder(BorderFactory.createLineBorder(Color.BLACK));
								tId.setBorder(BorderFactory.createLineBorder(Color.BLACK));
								password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
								confirm_password.setBorder(BorderFactory.createLineBorder(Color.BLACK));
								
								String logintype =(String)loginAs.getSelectedItem();
							if(logintype=="student") {
								String response =user.ChangePasswordForStudents(taddmission.getText(),tId.getText(),password.getText());
								if(response=="username") {
									label.setText("    please check your reg_number and try again");
									label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
									label.setForeground(Color.white);
									taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
									label.setBackground(Color.BLACK);
									label.setBounds(5,50,500,50);
									label.setOpaque(true);
									panel2.add(label);
									panel2.repaint();
								}
								if(response=="id") {
									label.setText("    your  id does not match with your reg_number");
									label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
									taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
									tId.setBorder(BorderFactory.createLineBorder(Color.red));
									label.setForeground(Color.white);
									label.setBackground(Color.BLACK);
									label.setBounds(5,50,500,50);
									label.setOpaque(true);
									panel2.add(label);
									panel2.repaint();
									
								}
								if(response=="successful") {
									taddmission.setText("");
									password.setText("");
									tId.setText("");
									confirm_password.setText("");
									label.setText("    changed sucessful go back and login now");
									label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
									label.setForeground(Color.white);
									label.setBackground(Color.BLACK);
									label.setBounds(5,50,500,50);
									label.setOpaque(true);
									panel2.add(label);
									panel2.repaint();
								}
								}
								else if(logintype=="lecturer") {
									String response =user.ChangePasswordForlecture(taddmission.getText(),tId.getText(),password.getText());
									if(response=="username") {
										label.setText("    please check your lec_number and try again");
										label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
										label.setForeground(Color.white);
										taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
										label.setBackground(Color.BLACK);
										label.setBounds(5,50,500,50);
										label.setOpaque(true);
										panel2.add(label);
										panel2.repaint();
									}
									if(response=="id") {
										label.setText("    your  id does not match with your reg_number");
										label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
										taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
										tId.setBorder(BorderFactory.createLineBorder(Color.red));
										label.setForeground(Color.white);
										label.setBackground(Color.BLACK);
										label.setBounds(5,50,500,50);
										label.setOpaque(true);
										panel2.add(label);
										panel2.repaint();
										
									}
									if(response=="successful") {
										taddmission.setText("");
										password.setText("");
										tId.setText("");
										confirm_password.setText("");
										label.setText("    changed sucessful go back and login now");
										label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
										label.setForeground(Color.white);
										label.setBackground(Color.BLACK);
										label.setBounds(5,50,500,50);
										label.setOpaque(true);
										panel2.add(label);
										panel2.repaint();
									}
									
							}else if(logintype=="librarian") {
									String response =user.ChangePasswordForLibrarian(taddmission.getText(),tId.getText(),password.getText());
									if(response=="username") {
										label.setText("    please check your lib_number and try again");
										label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
										label.setForeground(Color.white);
										taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
										label.setBackground(Color.BLACK);
										label.setBounds(5,50,500,50);
										label.setOpaque(true);
										panel2.add(label);
										panel2.repaint();
									}
									if(response=="id") {
										label.setText("    your  id does not match with your reg_number");
										label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
										taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
										tId.setBorder(BorderFactory.createLineBorder(Color.red));
										label.setForeground(Color.white);
										label.setBackground(Color.BLACK);
										label.setBounds(5,50,500,50);
										label.setOpaque(true);
										panel2.add(label);
										panel2.repaint();
										
									}
									if(response=="successful") {
										taddmission.setText("");
										password.setText("");
										tId.setText("");
										confirm_password.setText("");
										label.setText("    changed sucessful go back and login now");
										label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
										label.setForeground(Color.white);
										label.setBackground(Color.BLACK);
										label.setBounds(5,50,500,50);
										label.setOpaque(true);
										panel2.add(label);
										panel2.repaint();
									}
									
							}
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								
								else if(logintype=="admin"){
								String response =user.ChangePasswordForAdmin(taddmission.getText(),tId.getText(),password.getText());
								if(response=="username") {
									label.setText("    please check your username and try again");
									label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
									label.setForeground(Color.white);
									taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
									label.setBackground(Color.BLACK);
									label.setBounds(5,50,500,50);
									label.setOpaque(true);
									panel2.add(label);
									panel2.repaint();
								}
								if(response=="id") {
									label.setText("    your  id does not match with your user name");
									label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
									label.setForeground(Color.white);
									taddmission.setBorder(BorderFactory.createLineBorder(Color.red));
									tId.setBorder(BorderFactory.createLineBorder(Color.red));
									label.setBackground(Color.BLACK);
									label.setBounds(5,50,500,50);
									label.setOpaque(true);
									panel2.add(label);
									panel2.repaint();
									
								}
								if(response=="successful") {
									taddmission.setText("");
									password.setText("");
									tId.setText("");
									confirm_password.setText("");
									label.setText("    changed sucessful go back and login now");
									label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
									label.setForeground(Color.white);
									label.setBackground(Color.BLACK);
									label.setBounds(5,50,500,50);
									label.setOpaque(true);
									panel2.add(label);
									panel2.repaint();
								}
							}				
								
							}else {
								taddmission.setBorder(BorderFactory.createLineBorder(Color.BLACK));
								tId.setBorder(BorderFactory.createLineBorder(Color.BLACK));
								password.setBorder(BorderFactory.createLineBorder(Color.red));
								confirm_password.setBorder(BorderFactory.createLineBorder(Color.red));
							}
				}
			}	
		});
		
		
		panel1.add(reset);
		panel1.add(tId);
		panel1.add(id);
		panel1.add(confirmpassword);
		panel1.add(confirm_password);
		panel1.add(Back);

		
	}

}
