package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import controller.AdminController;
import controller.LectureControll;
import controller.ProgrammController;
import controller.StudentController;
import controller.UserController;
import controller.bookController;
import controller.courseController;
import controller.librarianController;

public class AdminView {

	JPanel pane1 = new JPanel();
	JScrollPane scroll1 = new JScrollPane(pane1);
	private ProgrammController pg;
	private courseController cs;
	private String  pvname="";
	private bookController bk;
	String mypiclocation="" ;
	private String key2="";
	private JPanel panel5;
	private JTextField srch;
	private JLabel seach;
	private JPanel panel4;
	private JButton dashboard;
	private JButton registerStudent;
	private JButton registerLecture;
	private JLabel ImageTitle;
	private JButton addbook;
	private JButton addprogram;
	private JButton addcourse;
	
	private JLabel mainLabel;
	private JPanel panel3=new JPanel();
	private JFrame frame = new JFrame();
	private JPanel panel1 =new JPanel();
	private JLabel label;
	private String username;
	private String firstName;
	private String lastname;
	private String Image;
	private AdminController dm;
	private UserController us;
	public AdminView(String name) {
		username =name;
		dm = new AdminController();
		String info[] = dm.getinfor(username);
		firstName =info[0];
		lastname =info[1];
		Image =info[2];
		frame.setBounds(100,50,1000,600);
		frame.setResizable(false);
		ImageIcon myimage=new ImageIcon(Image);
		frame.setIconImage(myimage.getImage());
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
		
		String location = dm.Imageresize(Image, 80, 80,firstName);
		ImageIcon image =new ImageIcon (location);
		label =new JLabel(image);
		frame.setIconImage(image.getImage());
		label.setBounds(-40,-40,200,200);
		String nametitle = firstName +"   "+lastname;
		JLabel NameTitle = new JLabel (nametitle);
		NameTitle.setBounds(120,20,300,50);
		NameTitle.setFont(new Font("Arial",Font.BOLD,25));
		
		JLabel Title = new JLabel ("ADMINISTRATOR");
		Title.setBounds(120,60,300,50);
		Title.setFont(new Font("Arial",Font.BOLD,25));
		
		
		JPanel panel2 =new JPanel();
		panel2.setBounds(68,150,250,350);
		panel2.setBackground(Color.lightGray);
		//SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.white, Color.white);
		panel2.setBorder(border);
		panel2.setLayout(new FlowLayout());


		
		
		
		
		
		dashboard =new JButton("🏡 dashboard ");
		dashboard.setFocusable(false);
		dashboard.setBackground(Color.magenta);
		dashboard.setBounds(10,20,230,40);
		dashboard.setFont(new Font("Arial",Font.BOLD,25));
		dashboard.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		dashboard.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dashBoard();
			}
			
		});
		
		registerStudent =new JButton("🏡 Student");
		registerStudent.setFocusable(false);
		registerStudent.setBackground(Color.magenta);
		registerStudent.setBounds(10,80,230,40);
		registerStudent.setFont(new Font("Arial",Font.BOLD,25));
		registerStudent.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		registerStudent.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Students();
				
			}
			
		});
		
		
		registerLecture =new JButton("🏡Lecturer");
		registerLecture.setFocusable(false);
		registerLecture.setBackground(Color.magenta);
		registerLecture.setBounds(10,140,230,40);
		registerLecture.setFont(new Font("Arial",Font.BOLD,25));
		registerLecture.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		registerLecture.addMouseListener(new MouseAdapter() {
			public void mouseClicked (MouseEvent e) {
				Lectures();
			}
			
		});
		
		addbook =new JButton("🏡 Library");
		addbook.setFocusable(false);
		addbook.setBackground(Color.magenta);
		addbook.setBounds(10,197,230,40);
		addbook.setFont(new Font("Arial",Font.BOLD,25));
		addbook.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addbooktoLibrary();
			}
		});
		addbook.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		
		addprogram =new JButton("🏡 program");
		addprogram.setFocusable(false);
		addprogram.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		addprogram.setBackground(Color.magenta);
		addprogram.setBounds(10,250,230,40);
		addprogram.setFont(new Font("Arial",Font.BOLD,25));
		addprogram.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				programs();
			}
			
		});
		
		addcourse =new JButton("🏡 courses");
		addcourse.setFocusable(false);
		addcourse.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		addcourse.setBackground(Color.magenta);
		addcourse.setBounds(10,300,230,40);
		addcourse.setFont(new Font("Arial",Font.BOLD,25));
		addcourse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				explorecourses();
			}
			
		});
		
		panel2.setLayout(null);
		panel2.add(dashboard);
		panel2.add(addcourse);
		panel2.add(registerStudent);
		panel2.add(addbook);
		panel2.add(addprogram);
		panel2.add(registerLecture);
		
		panel3.setBounds(430,10,550,540);
		panel3.setBackground(Color.white);
		border = new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.cyan, Color.orange);
		panel3.setBorder(border);
		panel3.setLayout(null);
		
		us =new UserController();
		String mainpng ="photos\\chuka1.jpg";
		String webpage = us.resizeEmage(mainpng, 530, 420,"mainLogo");
		ImageIcon mainImage =new ImageIcon(webpage);
		mainLabel = new JLabel(mainImage);
		mainLabel.setBounds(0,0,530,420);
		ImageTitle = new JLabel("   welcome to chuka you are logged in as admin  ");
		ImageTitle.setBounds(20,10,500,70);
		ImageTitle.setFont(new Font("Arial",Font.BOLD,20));
		ImageTitle.setBackground(Color.CYAN);
		ImageTitle.setOpaque(true);
		
		panel5 =new JPanel();
		panel5.setBounds(10,100,530,420);
		panel5.setBackground(Color.lightGray);
		panel5.setBorder(border);
		panel5.setLayout(null);
		panel5.add(mainLabel);
		panel3.add(panel5);
		
		panel3.add(ImageTitle);
		panel1.add(panel2);
		panel1.add(Title);
		panel1.add(NameTitle);
		panel1.add(label);
		frame.add(panel3);
		frame.setVisible(true);
		frame.add(panel1);
	}
	public void dashBoard() {
		panel5.setBounds(10,100,530,420);
		scroll1.setVisible(false);
		panel5.removeAll();
		ImageTitle.setVisible(false);
		mainLabel.setVisible(false);
		panel4 =new JPanel();
		panel4.setBounds(0,0,550,540);
		SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.cyan, Color.orange);
		panel4.setBorder(border);
		panel4.setBackground(Color.BLUE);
		
		 seach =new JLabel("search");
		 seach.setBounds(20,20,100,40);
		 seach.setFont(new  Font("Arial",Font.BOLD+Font.ITALIC,20));
		 panel4.add(seach);
		 

		    JButton Sbutton =new JButton("Search");
			Sbutton.setBounds(410,20,100,30);
			Sbutton.setFocusable(false);
			Sbutton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String availableIn =dm.SearchReturn(srch.getText());
					if(availableIn.equals("book")) {
						getBookdetails(srch.getText());
						srch.setText("");
					}else if(availableIn.equals("student")){
						stdmyinformation(srch.getText());
						srch.setText("");
					}else if(availableIn.equals("course")){
						coursedetails(srch.getText());
						srch.setText("");
					}else if(availableIn.equals("lecturer")){
						lcmyinformation(srch.getText());
						srch.setText("");
					}
				}
				
			});
			panel4.add(Sbutton);
		 
		 
		 
		 srch =new JTextField();
		 srch.setBounds(100,20,300,30);
		 panel4.add(srch);
		 srch.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				search(srch.getText());
			}
			 
		 });
		panel4.setLayout(null);
		
		
		
		us =new UserController();
		String mainpng ;
		String webpage ;
		
		mainpng ="photos\\info.jpeg";
		webpage = us.resizeEmage(mainpng, 80, 80 ,"info");
		ImageIcon myinfo =new ImageIcon(webpage);
		JLabel Lmyinfo = new JLabel(myinfo);
		Lmyinfo.setPreferredSize(new Dimension(80, 80));
		JLabel l1 =new JLabel("my info");
		Lmyinfo.setBounds(30,10,80,80);
		l1.setBounds(35,90,80,20);
		Lmyinfo.addMouseListener(new MouseAdapter() {

			 @Override
			    public void mouseClicked(MouseEvent e) {
			    	myInformation(username);
			    	
			    }
			
			
		});
		
		
		panel5.add(l1);
		
		mainpng ="photos\\addlecturer.png";
		webpage = us.resizeEmage(mainpng, 80, 80,"Lecture");
		ImageIcon lc =new ImageIcon(webpage);
		JLabel lec = new JLabel(lc);
		lec.setPreferredSize(new Dimension(80, 80));
		JLabel l2 =new JLabel("Lecturer");
		lec.setBounds(160,10,80,80);
		l2.setBounds(165,90,80,20);
		lec.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				Lectures();
			}
			
			
		});
		panel5.add(l2);
		
		
		mainpng ="photos\\addstudent.jpeg";
		webpage = us.resizeEmage(mainpng, 80, 80,"addstudent");
		ImageIcon RegisterStudent =new ImageIcon(webpage);
		JLabel LRegisterStudent = new JLabel(RegisterStudent);
		LRegisterStudent.setPreferredSize(new Dimension(80, 80));
		JLabel l3 =new JLabel("Student");
		LRegisterStudent.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				Students();
			}
			
			
		});
		LRegisterStudent.setBounds(280,10,80,80);
		l3.setBounds(285,90,80,20);
		panel5.add(l3);
		
		
		mainpng ="photos\\addadmin.png";
		webpage = us.resizeEmage(mainpng, 80, 80,"addadmin");
		ImageIcon AddAdmin =new ImageIcon(webpage);
		JLabel LAddAdmin = new JLabel(AddAdmin);
		LAddAdmin.setPreferredSize(new Dimension(80, 80));
		JLabel l4 =new JLabel("add admin ");
		LAddAdmin.setBounds(400,10,80,80);
		l4.setBounds(410,90,80,20);
		LAddAdmin.addMouseListener(new MouseAdapter() {

			 @Override
			    public void mouseClicked(MouseEvent e) {
			    	addadmin();
			    	
			    }
			
			
		});
		panel5.add(l4);
		
		
		mainpng ="photos\\addprogram.jpeg";
		webpage = us.resizeEmage(mainpng, 80, 80,"addprogram");
		ImageIcon addProgram =new ImageIcon(webpage);
		JLabel LaddProgramd = new JLabel(addProgram);
		LaddProgramd.setPreferredSize(new Dimension(80, 80));
		JLabel l5 =new JLabel("programe");
		LaddProgramd.setBounds(30,130,80,80);
		LaddProgramd.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				programs();
			}
			
		});
		l5.setBounds(35,210,80,20);
		panel5.add(l5);
		
		
		mainpng ="photos\\addbook.png";
		webpage = us.resizeEmage(mainpng, 80, 80,"Library");
		ImageIcon addBook =new ImageIcon(webpage);
		JLabel LaddBook = new JLabel(addBook);
		LaddBook.setPreferredSize(new Dimension(80, 80));
		JLabel l6 =new JLabel("Library");
		l6.setBounds(295,215,80,20);
		LaddBook.setBounds(285,130,80,80);
		LaddBook.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e){
				addbooktoLibrary();
			}
			
		});
		panel5.add(l6);
		
		mainpng ="photos\\assignlecture.png";
		webpage = us.resizeEmage(mainpng, 80, 80,"assignlecture");		
		ImageIcon assignLecture =new ImageIcon(webpage);
		JLabel LassignLecture = new JLabel(assignLecture);
		LassignLecture.setPreferredSize(new Dimension(80, 80));
		JLabel l7 =new JLabel("assign lecture");
		l7.setBounds(165,210,100,20);
		LassignLecture.setBounds(160,130,80,80);
		LassignLecture.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				assignLectureCourses();
			}
		});
		panel5.add(l7);
		
		mainpng ="photos\\removeadmin.png";
		webpage = us.resizeEmage(mainpng, 80, 80,"removeadmin");
		ImageIcon removeAdmin =new ImageIcon(webpage);
		JLabel LremoveAdmin = new JLabel(removeAdmin);
		LremoveAdmin.setPreferredSize(new Dimension(80, 80));
		JLabel l12 =new JLabel("remove Admin");
		l12.setBounds(400,210,100,20);
		LremoveAdmin.setBounds(400,130,80,80);
		LremoveAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	removeadmin();
		    	
		    }
			
		});
		panel5.add(l12);
		
		
		mainpng ="photos\\office.jpg";
		webpage = us.resizeEmage(mainpng, 80, 80,"addlibrarian");
		ImageIcon librarian =new ImageIcon(webpage);
		JLabel Llibrarian = new JLabel(librarian);
		Llibrarian.setPreferredSize(new Dimension(80, 80));
		JLabel l13 =new JLabel("Add librarian");
		l13.setBounds(30,340,100,20);
		Llibrarian.setBounds(30,250,80,80);
		Llibrarian.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		    	addlibrarian();
		    	
		    }
			
		});
		panel5.add(l13);
		panel5.add(Llibrarian);
		
		
		mainpng ="photos\\librarian.png";
		webpage = us.resizeEmage(mainpng, 80, 80,"rmlibrarian");
		ImageIcon rmlibrarian =new ImageIcon(webpage);
		JLabel Lrmlibrarian = new JLabel(rmlibrarian);
		Lrmlibrarian.setPreferredSize(new Dimension(80, 80));
		JLabel l14 =new JLabel("rm librarian");
		l14.setBounds(160,340,100,20);
		Lrmlibrarian.setBounds(160,250,80,80);
		Lrmlibrarian.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeLibrarian();
		    	
		    }
			
		});
		panel5.add(l14);
		panel5.add(Lrmlibrarian);
		
		
		
		
		
		
		JButton btn=new JButton("validate exam");
		btn.setBounds(325,250 ,150, 50);
		btn.setFocusable(false);
		btn.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btn.setText("validated");
				dm.validateScores();
				
			}
			
		});
		
		panel5.add(btn);
		panel5.add(LremoveAdmin);
		panel5.add(LassignLecture);
		panel5.add(LaddBook);
		panel5.add(LaddProgramd);
		panel5.add(Lmyinfo);
		panel5.add(lec);
		panel5.add(LRegisterStudent);
		panel5.add(LAddAdmin);
		
		
		panel3.repaint();
		panel3.add(panel4);
		panel1.add(label);
		frame.add(panel3);
		frame.setVisible(true);
		frame.add(panel1);
		
	}
	public void search(String value) {
	    pane1.setBackground(Color.LIGHT_GRAY);
	    pane1.setLayout(new GridLayout(0, 1));
	    scroll1.setVisible(true);
	    pane1.removeAll();

	    int x = 20;
	    String[] response = dm.Search(value);
	    for (String addSearch  : response) {
	    	if (addSearch!=null) {
	    	JLabel newButton = new JLabel();
	        newButton.setText(addSearch);
	        newButton.setFocusable(false);
	        newButton.setBackground(null);
	        newButton.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		srch.setText(addSearch);
	        	}
	        });
	        if (x < 100) {
	            x += 20;
	        }
	        scroll1.repaint();
	        pane1.add(newButton);
	    	}
	    }
	    
	   panel5.setVisible(true);
	   panel5.setLocation(10, 200);
	   panel5.setSize(530,300);
	   panel5.repaint();
	    panel4.add(scroll1);
	    scroll1.setBounds(100, 50, 300, x);
	    panel4.repaint();
	    pane1.revalidate();
	    pane1.repaint();
	}
	
	public void myInformation(String n) {
		panel5.removeAll();
		scroll1.setVisible(false);
		panel5.repaint();
		panel5.setBounds(10,100,530,420);
		String mydetails[] = dm.getMyinformation(n);
		
		////System.out.println(mydetails[10]);
		String MyimageLocation = us.resizeEmage(mydetails[10], 150, 150, lastname);
		ImageIcon myImage =new ImageIcon( MyimageLocation);
		JLabel myin =new JLabel(myImage);
		myin.setBounds(20,20,150,150);
		panel5.add(myin);
		
		JLabel first1 = new JLabel("First name :");
		first1.setBounds(20,200,150,30);
		panel5.add(first1);
		
		JLabel first2 = new JLabel(mydetails[0]);
		first2.setBounds(100,200,150,30);
		panel5.add(first2);
		
		JLabel sec1 = new JLabel("second  name :");
		sec1.setBounds(20,250,150,30);
		panel5.add(sec1);
		
		JLabel sec2 = new JLabel(mydetails[1]);
		sec2.setBounds(120,250,150,30);
		panel5.add(sec2);
		
		JLabel third1 = new JLabel("Last name :");
		third1.setBounds(20,300,150,30);
		panel5.add(third1);
		
		JLabel third2 = new JLabel(mydetails[2]);
		third2.setBounds(120,300,150,30);
		panel5.add(third2);
		
		JLabel date1 = new JLabel("Date of birth:");
		date1.setBounds(20,350,150,30);
		panel5.add(date1);
		
		JLabel date2 = new JLabel(mydetails[3]);
		date2.setBounds(120,350,150,30);
		panel5.add(date2);
		
		JLabel type = new JLabel("ADMINISTRATOR");
		type.setBounds(250,50,300,50);
		type.setForeground(Color.red);
		type.setFont(new Font("arial",Font.BOLD+Font.ITALIC,25));
		panel5.add(type);
		
		
		JLabel id1 = new JLabel("ID :");
		id1.setBounds(250,100,150,30);
		panel5.add(id1);
		
		JLabel id2 = new JLabel(mydetails[9]);
		id2.setBounds(300,100,150,30);
		panel5.add(id2);
		
		JLabel Phone1 = new JLabel("Phone Number :");
		Phone1.setBounds(250,150,150,30);
		panel5.add(Phone1);
		
		JLabel Phone2 = new JLabel(mydetails[8]);
		Phone2.setBounds(350,150,150,30);
		panel5.add(Phone2);
		
		JLabel gender1 = new JLabel("gender :");
		gender1.setBounds(250,200,150,30);
		panel5.add(gender1);
		
		JLabel gender2 = new JLabel(mydetails[4]);
		gender2.setBounds(300,200,150,30);
		panel5.add(gender2);
		
		JLabel user1 = new JLabel("username :");
		user1.setBounds(250,250,150,30);
		panel5.add(user1);
		
		JLabel user2 = new JLabel(mydetails[5]);
		user2.setBounds(350,250,150,30);
		panel5.add(user2);
		
		JLabel work1 = new JLabel("work number :");
		work1.setBounds(250,300,150,30);
		panel5.add(work1);
		
		JLabel work2 = new JLabel(mydetails[6]);
		work2.setBounds(350,300,150,30);
		panel5.add(work2);
		
		JLabel email1 = new JLabel("email:");
		email1.setBounds(250,350,150,30);
		panel5.add(email1);
		
		JLabel email2 = new JLabel(mydetails[7]);
		email2.setBounds(300,350,150,30);
		panel5.add(email2);
	
		
	}
public void addadmin() {
	panel5.removeAll();
	scroll1.setVisible(false);
	panel5.setBounds(10,100,530,420);
	JLabel atitle = new JLabel("ENTER THE ADMIN DETAILS");
	atitle.setBounds(20,20,500,30);
	atitle.setForeground(Color.red);
	atitle.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
	panel5.add(atitle);
	
	JLabel fname =new JLabel("First name:");
	fname.setBounds(20,50,100,30);
	panel5.add(fname);
	
	JTextField firstname =new JTextField();
	firstname.setBounds(100,55,150,25);
	panel5.add(firstname);
	
	JLabel sname =new JLabel("second name:");
	sname.setBounds(20,100,100,30);
	panel5.add(sname);
	
	JTextField secondname =new JTextField();
	secondname.setBounds(100,105,150,25);
	panel5.add(secondname);
	
	JLabel lname =new JLabel("last name:");
	lname.setBounds(20,150,100,30);
	panel5.add(lname);
	
	JTextField lastname =new JTextField();
	lastname.setBounds(100,155,150,25);
	panel5.add(lastname);
	
	JLabel date =new JLabel("date of birth:");
	date.setBounds(20,200,100,30);
	panel5.add(date);
	
	
	JTextField dateofbirth =new JTextField("yyyy-mm-dd");
	dateofbirth.setBounds(100,205,150,25);
	panel5.add(dateofbirth);
	
	JLabel gen =new JLabel("gender:");
	gen.setBounds(20,250,100,30);
	panel5.add(gen);
	
	
	String gende [] = {"male","Female","others"};
	JComboBox<Object> gender =new JComboBox<Object>(gende);
	gender.setBounds(100,250,150,25);
	panel5.add(gender);
	
	JLabel em =new JLabel("Email:");
	em.setBounds(300,50,100,30);
	panel5.add(em);
	
	JTextField email =new JTextField("email@gmail.com");
	email.setBounds(350,55,150,25);
	panel5.add(email);
	
	JLabel pone =new JLabel("Phone:");
	pone.setBounds(300,100,100,30);
	panel5.add(pone);
	
	JTextField phone =new JTextField();
	phone.setBounds(350,105,150,25);
	panel5.add(phone);
	
	JLabel idNumber =new JLabel("Id:");
	idNumber.setBounds(300,150,100,30);
	panel5.add(idNumber);
	
	JTextField Id =new JTextField();
	Id.setBounds(350,155,150,25);
	
	Id.addKeyListener(new KeyListener() {
		public void keyTyped(KeyEvent e) {
		}
		public void keyPressed(KeyEvent e) {
		}
		public void keyReleased(KeyEvent e) {	
			if(e.getKeyCode()==8) {
				key2=Id.getText();
			}
		else if((e.getKeyChar()=='0'||e.getKeyChar()=='1'||e.getKeyChar()=='2'||e.getKeyChar()=='3'||
						e.getKeyChar()=='4'||e.getKeyChar()=='5'||e.getKeyChar()=='6'||e.getKeyChar()=='7'||
						e.getKeyChar()=='8'||e.getKeyChar()=='9')&&(Id.getText().length()<=8)) {
					key2 =key2 + e.getKeyChar();
				}
				Id.setText(key2);
		}
		
	});
	panel5.add(Id);
	
	JLabel pr =new JLabel("profile:");
	pr.setBounds(300,200,100,30);
	panel5.add(pr);
	JButton  profilepic =new JButton("click to choose");
	profilepic.setBounds(350,205,150,25);
	profilepic.setFocusable(false);
	profilepic.setBackground(Color.green);
	panel5.add(profilepic);
	profilepic.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
			JFileChooser myfile = new JFileChooser();
			myfile.setFileFilter(filter);
			int result = myfile.showOpenDialog(frame);
			if(result == JFileChooser.APPROVE_OPTION)
			{
				int  rm =(int)Math.random()*1000;
				File myprofile =myfile.getSelectedFile();
				mypiclocation =myprofile.getAbsolutePath().replace("\\", "/");
				String path =dm.Imageresize(myprofile.getAbsolutePath().replace("\\", "/"), 150, 150, "image"+rm);
				ImageIcon prof =new  ImageIcon(path);
				JLabel profimage =new JLabel(prof);
				profimage.setBounds(350, 250, 150, 150);
				panel5.add(profimage);
				profimage.repaint();
				panel5.repaint();
				
			}
		}
		
		
		
	});
	
	JButton submit =new JButton("submit/validate");
	submit.setBounds(50,330,200,40);
	submit.setFocusable(false);
	submit.setForeground(Color.MAGENTA);
	submit.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
	submit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			   if(firstname.getText().isEmpty() ||secondname.getText().isEmpty()||lastname.getText().isEmpty()||
				dateofbirth.getText().isEmpty()||email.getText().isEmpty()||Id.getText().isEmpty()||
				phone.getText().isEmpty()||mypiclocation.isBlank()) {
				JLabel val = new JLabel ("please fill all the fields");
				val.setBounds(50,280,300,40);
				val.setForeground(Color.red);
				val.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
				panel5.add(val);
				panel5.repaint();
			}else {
				String ddata []= {firstname.getText(),secondname.getText(),lastname.getText(),dateofbirth.getText(),
									(String)gender.getSelectedItem(),email.getText(),phone.getText(),Id.getText(),mypiclocation};
				String responce1 [] =dm.addAdmin(ddata);
			
				panel5.removeAll();
				
				String message ="you have added another admin sucessfull";
				String username ="your work number is :"+ responce1[0];
				String password ="your id which is :"+ responce1[1];
				String congratulation ="Welcome appload";
				
				
				JLabel mess = new JLabel(message);
				mess.setForeground(Color.red);
				mess.setBounds(20,20,500,40);
				mess.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
				JLabel use = new JLabel(username);
				use.setForeground(Color.red);
				use.setBounds(20,65,500,40);
				use.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
				JLabel pass = new JLabel(password);
				pass.setForeground(Color.red);
				pass.setBounds(20,105,500,40);
				pass.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
				JLabel cong =new JLabel(congratulation);
				cong.setForeground(Color.red);
				cong.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
				cong.setBounds(20,150,500,40);
				
				String off = us.resizeEmage("photos\\office.jpg", 500, 280, "ofice");
				
				ImageIcon image =new ImageIcon (off);
				JLabel office =new JLabel(image);
				office.setBounds(10,200,500,200);
				panel5.add(pass);
				panel5.add(office);
				panel5.add(mess);
				panel5.add(cong);
				panel5.add(use);
				
				panel5.repaint();
			
			}
			
		}
		
	});
	
	panel5.add(submit);
	panel5.repaint();
}
public void removeadmin() {
	scroll1.setVisible(false);
	panel5.setBounds(10,100,530,420);
	panel5.removeAll();
	panel5.repaint();
	JLabel tt =new JLabel("this is the list of the admin available ");
	
	tt.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
	tt.setForeground(Color.red);
	String listAvailable [][] = dm.adminList();
	JPanel list = new JPanel();
	list.setBackground(Color.cyan);
	list.setLayout(new GridLayout(0,3,10,5));
	JScrollPane sc =new JScrollPane(list);
	for(String name[] :listAvailable ) {
			String lspc =us.resizeEmage(name[2],80,80,name[1]);
			ImageIcon mypc =new ImageIcon(lspc);
			JLabel newList = new JLabel(mypc);
			list.add(newList);
			JLabel newList1 = new JLabel(name[0]);
			list.add(newList1);
			JLabel newList2 = new JLabel(name[1]);
			list.add(newList2);
			list.revalidate();
			list.repaint();
	}
	list.revalidate();
	list.repaint();
	tt.setBounds(0,0,500,30);
	list.setBounds(20,80,480,1000);
	sc.setViewportView(list);
	sc.setBounds(20,50,500,300);
	
	JLabel subt = new JLabel("security purposes:Enter work number of admin you want to remove");
	subt.setForeground(Color.red);
	subt.setBounds(20,350,500,30);
	subt.setFont(new Font("arial",Font.BOLD+Font.ITALIC,15));
	subt.setBackground(Color.green);
	subt.setOpaque(true);
	JLabel security =new JLabel("work Number:");
	security.setBounds(20,390,100,20);
	
	JTextField st =new JTextField();
	st.setBounds(120, 390,150,20);
	JButton button =new JButton("Click And Check The List");
	button.setFocusable(false);
	button.setBounds(300,390,200,20);
	button.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			dm.removeAdmin(st.getText());
			removeadmin();
		}
		
	});
	panel5.add(button);
	panel5.add(st);
	panel5.add(security);
	panel5.add(subt);
	panel5.add(sc);
	panel5.add(tt);
	panel5.repaint();
			
}	

ImageIcon bookimage1;
JLabel bookimage =new JLabel();
public void addbooktoLibrary() {
	panel5.setBounds(10,100,530,420);
		panel5.removeAll();
		panel5.repaint();
		scroll1.setVisible(false);
		JLabel btitle =new JLabel("Fill in this for to add the book");
		btitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		btitle.setForeground(Color.BLUE);
		btitle.setBounds(10,0,500,30);
		
		
		JLabel ltitle =new JLabel("Title:");
		ltitle.setBounds(20,50,100,30);
		panel5.add(ltitle);
		
		JTextField title =new JTextField();
		title.setBounds(100,55,150,25);
		panel5.add(title);
		
		JLabel lversion =new JLabel("Version:");
		lversion.setBounds(20,100,100,30);
		panel5.add(lversion);
		
		JTextField version =new JTextField();
		version.setBounds(100,105,150,25);
		panel5.add(version);
		
		JLabel lISNN =new JLabel("ISNN:");
		lISNN.setBounds(20,150,100,30);
		panel5.add(lISNN);
		
		JTextField ISNN =new JTextField();
		ISNN.setBounds(100,155,150,25);
		panel5.add(ISNN);
		
		JLabel ledition =new JLabel("edition:");
		ledition.setBounds(20,200,100,30);
		panel5.add(ledition);
		
		
		JTextField edition =new JTextField();
		edition.setBounds(100,205,150,25);
		panel5.add(edition);
		
		JLabel lPublisher =new JLabel("publisher:");
		lPublisher.setBounds(20,250,100,30);
		panel5.add(lPublisher);
		
		JTextField publisher =new JTextField();
		publisher.setBounds(100,255,150,25);
		panel5.add(publisher);
		
		JLabel lavailable =new JLabel("Available:");
		lavailable.setBounds(20,300,100,30);
		panel5.add(lavailable);
		
		
		JTextField available =new JTextField();
		available.setBounds(100,305,150,25);
		panel5.add(available);
		
		
		JLabel lreserve =new JLabel("reserve");
		lreserve.setBounds(20,350,150,25);
		panel5.add(lreserve);
		
		JTextField reserve =new JTextField("0");
		reserve.setEditable(false);
		reserve.setBounds(100,355,150,25);
		panel5.add(reserve);
		
		
		JButton remov =new JButton("dispose");
		remov.setBounds(100,385,75,25);
		remov.setFocusable(false);
		remov.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				bk.removebook(title.getText());
				addbooktoLibrary();
			
			}
		});
		
		panel5.add(remov);
		
		
		
		JButton addbook =new JButton("cover");
		addbook.setBounds(10,385,80,25);
		addbook.setFocusable(false);
		addbook.addActionListener(new ActionListener() {

			
			@Override
			public void actionPerformed(ActionEvent e) {


				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
				JFileChooser mybook =new JFileChooser();
				mybook.setFileFilter(filter);
				int result = mybook.showOpenDialog(frame);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					mypiclocation ="";
					File myprofile =mybook.getSelectedFile();
					mypiclocation =myprofile.getAbsolutePath().replace("\\", "/");
					int  rm =(int)Math.random()*1000;
					String path =us.resizeEmage(myprofile.getAbsolutePath().replace("\\", "/"), 80, 100, "image"+rm);
					bookimage1 =new  ImageIcon(path);
					bookimage.setIcon(bookimage1);
					bookimage.setBounds(400, 315, 150, 100);
					panel5.add(bookimage);
					panel5.repaint();
				}
				
			}
			
			
		});
		
		
		JButton btn = new JButton("update");
		btn.setVisible(false);
		
		
		JButton submit = new JButton("addBook");
		submit.setBounds(190,385,80,25);
		submit.setFocusable(false);
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(title.getText().isEmpty()||version.getText().isEmpty()||publisher.getText().isEmpty()||
						ISNN.getText().isEmpty()||edition.getText().isEmpty()||available.getText().isEmpty()||
						reserve.getText().isEmpty()||mypiclocation.isBlank()) {
					
					JLabel ctitle =new JLabel("fill all fields before adding the  book");
					ctitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
					ctitle.setForeground(Color.red);
					ctitle.setBounds(20,20,500,30);
					panel5.add(ctitle);
					panel5.repaint();
				}else {
					String update [] = {title.getText().toLowerCase(),version.getText().toLowerCase(),ISNN.getText().toLowerCase(),
							edition.getText().toLowerCase(),publisher.getText().toLowerCase(),mypiclocation,available.getText(),"0"};
							 bk.addbook(update);
							 addbooktoLibrary();
				}
				
			}
			
		});
		
		panel5.add(addbook);
		panel5.add(submit);
		JPanel list = new JPanel();
		list.setBackground(Color.cyan);
		list.setLayout(new GridLayout(0,2,5,5));
		JScrollPane sc =new JScrollPane(list);
		bk =new bookController();
		String listAvailable [][]= bk.getbooksList();
	
		for(String name[] :listAvailable ) {
			pvname =name[0];
			String lspc =us.resizeEmage(name[5],50,50,name[0]);
			ImageIcon mypc =new ImageIcon(lspc);
			JLabel newList = new JLabel(mypc);
			newList.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					title.setText(name[0]);
					pvname =name[0];
					version.setText(name[1]);
					ISNN.setText(name[3]);
					edition.setText(name[4]);
					publisher.setText(name[2]);
					available.setText(name[6]);
					reserve.setText(name[7]);
					mypiclocation =name[5];
					Random rand = new Random();
					int rm = rand.nextInt(1000);
					String path =us.resizeEmage(name[5], 80, 100, "imae"+rm);
					ImageIcon bookimage1 =new  ImageIcon(path);
					JLabel bookimage =new JLabel(bookimage1);
					////System.out.println(rm);
					bookimage.setBounds(250, 315, 150, 100);
					panel5.add(bookimage);
					panel5.repaint();
					
					btn.setVisible(true);
					submit.setVisible(false);
				}
				
			});
			newList.setPreferredSize(new Dimension(50,50));
			list.add(newList);
			JLabel newList2 = new JLabel("🌂🌂"+name[0]);
			newList2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					title.setText(name[0]);
					pvname =name[0];
					version.setText(name[1]);
					ISNN.setText(name[3]);
					edition.setText(name[4]);
					publisher.setText(name[2]);
					available.setText(name[6]);
					reserve.setText(name[7]);
					mypiclocation =name[5];
					
					int  rm =(int)Math.random()*1000;
					String path =us.resizeEmage(name[5], 80, 100, "imae"+rm);
					ImageIcon bookimage1 =new  ImageIcon(path);
					JLabel bookimage =new JLabel(bookimage1);
					bookimage.setBounds(250, 315, 150, 100);
					panel5.add(bookimage);
					panel5.repaint();
					btn.setVisible(true);
					submit.setVisible(false);
					
				}
				
				
			});
			list.add(newList2);
			list.revalidate();
			list.repaint();
	}
		btn.setBounds(180,385,80,25);
		btn.setFocusable(false);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(title.getText().isEmpty()||version.getText().isEmpty()||publisher.getText().isEmpty()||
						ISNN.getText().isEmpty()||edition.getText().isEmpty()||available.getText().isEmpty()||
						reserve.getText().isEmpty()||mypiclocation.isBlank()) {
					
					JLabel ctitle =new JLabel("fill all fields before updating the  book");
					ctitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
					ctitle.setForeground(Color.red);
					ctitle.setBounds(20,20,500,30);
					panel5.add(ctitle);
					panel5.repaint();
				}else {
					String update [] = {title.getText(),version.getText(),edition.getText(),
					ISNN.getText(),available.getText(),mypiclocation,publisher.getText()};
					 bk.updateBook(pvname, update);
					 addbooktoLibrary();
					
					}
				}
				
			
			
		});
		panel5.add(btn);
		list.revalidate();
		list.repaint();
		panel5.add(sc);
		panel5.add(btitle);
		sc.setViewportView(list);
		sc.setBounds(270,10,250,300);
	}
	public void explorecourses() {
		panel5.removeAll();
		scroll1.setVisible(false);
		panel5.setBounds(10,100,530,420);
		panel5.repaint();
		JLabel ctitle =new JLabel("you can add course");
		ctitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		ctitle.setForeground(Color.BLUE);
		ctitle.setBounds(20,20,500,30);
		panel5.add(ctitle);
		
		
		JLabel ltitle =new JLabel("Title:");
		ltitle.setBounds(20,50,100,30);
		panel5.add(ltitle);
		
		JTextField title =new JTextField();
		title.setBounds(100,55,150,25);
		panel5.add(title);
		
		JLabel lcode =new JLabel("code:");
		lcode.setBounds(20,100,100,30);
		panel5.add(lcode);
		
		JTextField code =new JTextField();
		code.setBounds(100,105,150,25);
		panel5.add(code);
		
		
		JPanel list = new JPanel();
		list.setBackground(Color.cyan);
		list.setLayout(new GridLayout(0,5,1,1));
		JScrollPane sc =new JScrollPane(list);
		cs = new courseController();
		String courses [][] =cs.getdetails();
		int k=1;
		for(String course[] : courses) {
			JLabel numbers =new JLabel(k+"");
			k++;
			list.add(numbers);
			for(String inner: course) {
				JLabel newLabel = new JLabel(inner);
				newLabel.addMouseListener(new MouseAdapter() {
					
					public void mouseClicked(MouseEvent e) {
						title.setText(course[0]);
						code.setText(course[1]);
					}
					
				});
				list.add(newLabel);
			
				
			}
		}
		list.revalidate();
		list.repaint();
		//tt.setBounds(0,0,500,30);
		list.setBounds(20,80,480,1000);
		sc.setViewportView(list);
		sc.setBounds(20,150,500,250);
		panel5.add(sc);
		
		
		JButton addc =new JButton ("add course");
		addc.setBounds(300,50,100,30);
		
		addc.setFocusable(false);
		addc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(title.getText().isEmpty()||code.getText().isEmpty()) {
					JLabel newj =new JLabel("please fill all the fields");
					newj.setForeground(Color.red);
					newj.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
					newj.setBounds(250,20,200,20);
					panel5.add(newj);
					panel5.repaint();
				}else {
				cs.addCourse(title.getText(),code.getText());
				explorecourses();
				}
				
			}
			
			
		});
		panel5.add(addc);
		
		JButton remc =new JButton ("remove course");
		remc.setBounds(300,100,100,30);
		remc.setFocusable(false);
		remc.setBackground(Color.red);
		remc.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cs.removecourse(title.getText());
				explorecourses();
			}
			
		});
		panel5.repaint();
		panel5.add(remc);
		
	}
	int i=0;
	JScrollPane sc;
	public void programs() {
		panel5.setBounds(10,100,530,420);
		panel5.removeAll();
		scroll1.setVisible(false);
		panel5.repaint();
		JLabel addTitle =new JLabel("Remember you will affect all student if you delete the program");
		addTitle.setBounds(7,5,500,20);
		addTitle.setForeground(Color.red);
		addTitle.setFont(new Font("arial",Font.BOLD+Font.ITALIC,15));
		panel5.add(addTitle);
		
		JPanel pane =new JPanel();
		pane.setLayout(new GridLayout(0,8,10,10));
		//pane.setBackground(Color.darkGray);
		cs =new courseController();
		sc = new JScrollPane(pane);
		sc.setBounds(250,40,270,320);
		pane.setBounds(250,40,270,320);
		pg =new ProgrammController();
		String programs [][]= pg.getProgramsDetail();
		String copy[]=new String[cs.getdetails().length];
		String n [][]=cs.getdetails();
		for(int i =0;i<cs.getdetails().length;i++) {
			copy[i]=n[i][0];
		}
	
		
		JLabel name =new JLabel("Name:");
		name.setBounds(20,30,100,30);
		panel5.add(name);
		
		JTextField prname =new JTextField();
		prname.setBounds(90,35,130,25);
		panel5.add(prname);
		
		JLabel code =new JLabel("Code:");
		code.setBounds(20,80,100,30);
		panel5.add(code);
		
		JTextField prcode =new JTextField();
		prcode.setBounds(90,85,130,25);
		panel5.add(prcode);
		
		JLabel course1 =new JLabel("course1:");
		course1.setBounds(20,130,100,30);
		panel5.add(course1);
		
		JComboBox<?> prcourse1 =new JComboBox<Object>(copy);
		prcourse1.setBounds(90,135,130,25);
		panel5.add(prcourse1);
		
		JLabel course2 =new JLabel("course2:");
		course2.setBounds(20,180,100,30);
		panel5.add(course2);
		
		
		JComboBox<?> prcourse2 =new JComboBox<Object>(copy);
		prcourse2.setBounds(90,185,130,25);
		panel5.add(prcourse2);
		
		JLabel course3 =new JLabel("course3:");
		course3.setBounds(20,230,100,30);
		panel5.add(course3);
		
		JComboBox<?> prcourse3 =new JComboBox<Object>(copy);
		prcourse3.setBounds(90,235,130,25);
		panel5.add(prcourse3);
		
		JLabel course4 =new JLabel("course4:");
		course4.setBounds(20,280,100,30);
		panel5.add(course4);
		
		
		JComboBox<?> prcourse4 =new JComboBox<Object>(copy);
		prcourse4.setBounds(90,285,130,25);
		panel5.add(prcourse4);
		
		
		JLabel course5 =new JLabel("Course5");
		course5 .setBounds(20,330,150,25);
		panel5.add(course5 );
		
		JComboBox<?> prcourse5 =new JComboBox<Object>(copy);
		prcourse5.setEditable(false);
		prcourse5.setBounds(90,335,130,25);
		panel5.add(prcourse5);
		
		
		JButton btn = new JButton("submit");
		btn.setBounds(20,385,80,25);
		btn.setFocusable(false);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(prname.getText().isEmpty()||prcode.getText().isEmpty()) {
					if(prname.getText().isEmpty())
					prname.setBorder(BorderFactory.createLineBorder(Color.red));
					else
						prcode.setBorder(BorderFactory.createLineBorder(Color.red));
					
				}else {
					String add[] =new String[8];
					add[0]=prname.getText().toLowerCase();
					add[1]=(String) prcourse1.getSelectedItem();
					add[2]=(String) prcourse2.getSelectedItem();
					add[3]=(String) prcourse3.getSelectedItem();
					add[4]=(String) prcourse4.getSelectedItem();
					add[5]=(String) prcourse5.getSelectedItem();
					add[6]=prcode.getText().toLowerCase();
					add[7]="0";
					pg.addtodata(add);
					programs();
				}
			}
		});
		
		JButton del = new JButton("delete");
		del.setBounds(150,385,80,25);
		del.setFocusable(false);
		del.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(prname.getText().isEmpty()){
					prname.setBorder(BorderFactory.createLineBorder(Color.red));
					
				}else {
					pg.rmoveprogram(prname.getText());
					programs();
					
				}
				
			}
			
			
		});
		for( i=0;i<programs.length;i++) {
			for(String j :programs[i]) {
				JLabel newlabel =new JLabel(j);
				pane.add(newlabel);
				newlabel.addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent e) {
						prname.setText(newlabel.getText());
						
					pane.validate();
					pane.repaint();
					}
				});
			}
		}
		
		JButton upt = new JButton("Update ");
		upt.setBounds(270,385,80,25);
		upt.setFocusable(false);
		upt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(prname.getText().isEmpty()||prcode.getText().isEmpty()) {
					if(prname.getText().isEmpty())
					prname.setBorder(BorderFactory.createLineBorder(Color.red));
					else
						prcode.setBorder(BorderFactory.createLineBorder(Color.red));
					
				}else {
					String add[] =new String[8];
					add[0]=prname.getText();
					add[1]=(String) prcourse1.getSelectedItem();
					add[2]=(String) prcourse2.getSelectedItem();
					add[3]=(String) prcourse3.getSelectedItem();
					add[4]=(String) prcourse4.getSelectedItem();
					add[5]=(String) prcourse5.getSelectedItem();
					add[6]=prcode.getText();
					add[7]="0";
					pg.updateProgram(add);
					programs();
				}
			}
		});
		
		
		sc.validate();
		sc.repaint();
		
		panel5.add(upt);
		panel5.add(del);
		panel5.add(btn);
		panel5.add(sc);
	}
	StudentController st ;
	public void Students() {
		panel5.removeAll();
		scroll1.setVisible(false);
		panel5.setBounds(10,100,530,420);
		panel5.repaint();
		JLabel title =new JLabel("this is the list of the students availble");
		title.setBounds(20,0,500,30);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		
		panel5.add(title);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Number");
		model.addColumn("name");
		model.addColumn("admission");
		model.addColumn("program");
		st=new StudentController();
		String students [][]=st.studentDetails();
		int i=1;
		for (String std[] : students) {
			model.addRow(new Object[]{i,std[0]+"  "+std[2], std[5],std[8]});
			i++;
		}
		
		
		
		JTable table = new JTable(model);
		
		JScrollPane scroll =new JScrollPane(table);
		scroll.setBounds(20,30,500,350);
		panel5.add(scroll);
		panel5.repaint();

		JButton button =new JButton("add Student");
		button.setBounds(418,385,100,30);
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addStudent();
				
			}
			
		});
		
		panel5.add(button);
		panel5.repaint();
		
		
		JLabel lb =new JLabel("admission number");
		lb.setBounds(20,385,200,30);
		lb.setFocusable(false);
		panel5.add(lb);
		
		
		
		JTextField tx =new JTextField();
		tx.setBounds(150,385,140,30);
		
		panel5.add(tx);
		
		JButton but =new JButton("remove student");
		but.setBounds(300,385,100,30);
		but.setFocusable(false);
		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				st.removeStudent(tx.getText());
				Students();
				
			}
			
		});
		
		panel5.add(but);
		panel5.add(button);
		panel5.repaint();
		
		
		
	}
	private LectureControll lc;
	public void Lectures() {
		panel5.removeAll();
		panel5.setBounds(10,100,530,420);
		panel5.repaint();
		scroll1.setVisible(false);
		JLabel title =new JLabel("this is the list of the lectures availble");
		title.setBounds(20,0,500,30);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,15));
		
		panel5.add(title);
		
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Number");
		model.addColumn("name");
		model.addColumn("Lec Number");
		model.addColumn("Email");
		lc=new LectureControll ();
		String lecture [][]=lc.lectureDetails();
		int i=1;
		for (String lcs[] : lecture) {
			model.addRow(new Object[]{i,lcs[0]+"  "+lcs[2], lcs[5],lcs[6]});
			i++;
		}
		
		
		
		JTable table = new JTable(model);
		
		JScrollPane scroll =new JScrollPane(table);
		scroll.setBounds(20,30,500,350);
		panel5.add(scroll);
		panel5.repaint();
		JButton button =new JButton("add lecture");
		button.setBounds(418,385,100,30);
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				addlecture();
				
			}
			
		});
		
		panel5.add(button);
		panel5.repaint();
		
		
		JLabel lb =new JLabel("lec_number");
		lb.setBounds(20,385,200,30);
		lb.setFocusable(false);
		panel5.add(lb);
		
		
		
		JTextField tx =new JTextField();
		tx.setBounds(150,385,140,30);
		
		panel5.add(tx);
		
		JButton but =new JButton("remove lecture");
		but.setBounds(300,385,100,30);
		but.setFocusable(false);
		but.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lc.removelec(tx.getText());
				Lectures();
				
			}
			
		});
		
		panel5.add(but);
		panel5.add(button);
		panel5.repaint();
		
		
		
		
	}
	JLabel profimage =new JLabel();
	public void addStudent() {
		panel5.removeAll();
		scroll1.setVisible(false);
		panel5.setBounds(10,100,530,420);
		JLabel atitle = new JLabel("ENTER THE STUDENT DETAILS");
		atitle.setBounds(20,20,500,30);
		atitle.setForeground(Color.red);
		atitle.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
		panel5.add(atitle);
		
		JLabel fname =new JLabel("First name:");
		fname.setBounds(20,50,100,30);
		panel5.add(fname);
		
		JTextField firstname =new JTextField();
		firstname.setBounds(100,55,150,25);
		panel5.add(firstname);
		
		JLabel sname =new JLabel("second name:");
		sname.setBounds(20,100,100,30);
		panel5.add(sname);
		
		JTextField secondname =new JTextField();
		secondname.setBounds(100,105,150,25);
		panel5.add(secondname);
		
		JLabel lname =new JLabel("last name:");
		lname.setBounds(20,150,100,30);
		panel5.add(lname);
		
		JTextField lastname =new JTextField();
		lastname.setBounds(100,155,150,25);
		panel5.add(lastname);
		
		JLabel date =new JLabel("date of birth:");
		date.setBounds(20,200,100,30);
		panel5.add(date);
		
		
		JTextField dateofbirth =new JTextField("yyyy-mm-dd");
		dateofbirth.setBounds(100,205,150,25);
		panel5.add(dateofbirth);
		
		JLabel gen =new JLabel("gender:");
		gen.setBounds(20,250,100,30);
		panel5.add(gen);
		
		
		String gende [] = {"male","Female","others"};
		JComboBox<Object> gender =new JComboBox<Object>(gende);
		gender.setBounds(100,250,150,25);
		panel5.add(gender);
		
		
		JLabel pr =new JLabel("program:");
		pr.setBounds(20,300,100,30);
		panel5.add(pr);
		
		pg =new ProgrammController();
		String programs [][]=pg.getProgramsDetail();
		String detai[] =new String[programs.length];
		i=0;
		for(String[] progr :programs) {
			detai[i]=progr[0];
			i++;
		}
		
		JComboBox<Object> program =new JComboBox<Object>(detai);
		program.setBounds(100,305,150,25);
		panel5.add(program);
		
		JLabel em =new JLabel("Email:");
		em.setBounds(300,50,100,30);
		panel5.add(em);
		
		JTextField email =new JTextField("email@gmail.com");
		email.setBounds(350,55,150,25);
		panel5.add(email);
		
		JLabel pone =new JLabel("Phone:");
		pone.setBounds(300,100,100,30);
		panel5.add(pone);
		
		JTextField phone =new JTextField();
		phone.setBounds(350,105,150,25);
		panel5.add(phone);
		
		JLabel idNumber =new JLabel("Id:");
		idNumber.setBounds(300,150,100,30);
		panel5.add(idNumber);
		
		JTextField Id =new JTextField();
		Id.setBounds(350,155,150,25);
		
		Id.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {	
				if(e.getKeyCode()==8) {
					key2=Id.getText();
				}
			else if((e.getKeyChar()=='0'||e.getKeyChar()=='1'||e.getKeyChar()=='2'||e.getKeyChar()=='3'||
							e.getKeyChar()=='4'||e.getKeyChar()=='5'||e.getKeyChar()=='6'||e.getKeyChar()=='7'||
							e.getKeyChar()=='8'||e.getKeyChar()=='9')&&(Id.getText().length()<=8)) {
						key2 =key2 + e.getKeyChar();
					}
					Id.setText(key2);
			}
			
		});
		panel5.add(Id);
		
		JLabel pro =new JLabel("profile:");
		pro.setBounds(300,200,100,30);
		panel5.add(pro);
		JButton  profilepic =new JButton("click to choose");
		profilepic.setBounds(350,205,150,25);
		profilepic.setFocusable(false);
		profilepic.setBackground(Color.green);
		panel5.add(profilepic);
		profilepic.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
				JFileChooser myfile = new JFileChooser();
				myfile.setFileFilter(filter);
				int result = myfile.showOpenDialog(frame);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					int  rm =(int)Math.random()*1000;
					File myprofile =myfile.getSelectedFile();
					mypiclocation =myprofile.getAbsolutePath().replace("\\", "/");
					String path =dm.Imageresize(myprofile.getAbsolutePath().replace("\\", "/"), 150, 150, "image"+rm);
					ImageIcon prof =new  ImageIcon(path);
					profimage.setIcon(prof); 
					profimage.setBounds(350, 250, 150, 150);
					panel5.add(profimage);
					profimage.repaint(); 
					panel5.repaint();
					
				}
			}
			
			
			
		});
		
		JButton submit =new JButton("submit/validate");
		submit.setBounds(50,360,200,40);
		submit.setFocusable(false);
		submit.setForeground(Color.MAGENTA);
		submit.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
		submit.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				   if(firstname.getText().isEmpty() ||secondname.getText().isEmpty()||lastname.getText().isEmpty()||
					dateofbirth.getText().isEmpty()||email.getText().isEmpty()||Id.getText().isEmpty()||
					phone.getText().isEmpty()||mypiclocation.isBlank()) {
					JLabel val = new JLabel ("please fill all the fields");
					val.setBounds(50,330,300,40);
					val.setForeground(Color.red);
					val.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					panel5.add(val);
					panel5.repaint();
				}else {
					String ddata []= {firstname.getText().toLowerCase(),secondname.getText().toLowerCase(),lastname.getText().toLowerCase(),dateofbirth.getText(),
										(String)gender.getSelectedItem(),email.getText(),Id.getText(),(String)program.getSelectedItem(),mypiclocation};
					String responce1 [] =st.addstudent(ddata);
				
					panel5.removeAll();
					
					String message ="you have added another student sucessfull";
					String username ="your reg number is :"+ responce1[0];
					String password ="your id which is :"+ responce1[1];
					String congratulation ="your can login to your portal";
					
					
					JLabel mess = new JLabel(message);
					mess.setForeground(Color.red);
					mess.setBounds(20,20,500,40);
					mess.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					JLabel use = new JLabel(username);
					use.setForeground(Color.red);
					use.setBounds(20,65,500,40);
					use.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					JLabel pass = new JLabel(password);
					pass.setForeground(Color.red);
					pass.setBounds(20,105,500,40);
					pass.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					JLabel cong =new JLabel(congratulation);
					cong.setForeground(Color.red);
					cong.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					cong.setBounds(20,150,500,40);
					
					String off = us.resizeEmage("photos\\office.jpg", 500, 280, "ofice");
					
					ImageIcon image =new ImageIcon (off);
					JLabel office =new JLabel(image);
					office.setBounds(10,200,500,200);
					panel5.add(pass);
					panel5.add(office);
					panel5.add(mess);
					panel5.add(cong);
					panel5.add(use);
					panel5.repaint();
				
				}
				
			}
			
		});
		
		
		
		
		
		
		panel5.add(submit);
		panel5.repaint();
	}
	public void addlecture() {
		panel5.removeAll();
		scroll1.setVisible(false);
		panel5.setBounds(10,100,530,420);
		JLabel atitle = new JLabel("ENTER THE LECTURE DETAILS");
		atitle.setBounds(20,20,500,30);
		atitle.setForeground(Color.red);
		atitle.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
		panel5.add(atitle);
		
		JLabel fname =new JLabel("First name:");
		fname.setBounds(20,50,100,30);
		panel5.add(fname);
		
		JTextField firstname =new JTextField();
		firstname.setBounds(100,55,150,25);
		panel5.add(firstname);
		
		JLabel sname =new JLabel("second name:");
		sname.setBounds(20,100,100,30);
		panel5.add(sname);
		
		JTextField secondname =new JTextField();
		secondname.setBounds(100,105,150,25);
		panel5.add(secondname);
		
		JLabel lname =new JLabel("last name:");
		lname.setBounds(20,150,100,30);
		panel5.add(lname);
		
		JTextField lastname =new JTextField();
		lastname.setBounds(100,155,150,25);
		panel5.add(lastname);
		
		JLabel date =new JLabel("date of birth:");
		date.setBounds(20,200,100,30);
		panel5.add(date);
		
		
		JTextField dateofbirth =new JTextField("yyyy-mm-dd");
		dateofbirth.setBounds(100,205,150,25);
		panel5.add(dateofbirth);
		
		JLabel gen =new JLabel("gender:");
		gen.setBounds(20,250,100,30);
		panel5.add(gen);
		
		
		String gende [] = {"male","Female","others"};
		JComboBox<Object> gender =new JComboBox<Object>(gende);
		gender.setBounds(100,250,150,25);
		panel5.add(gender);
		
		JLabel em =new JLabel("Email:");
		em.setBounds(300,50,100,30);
		panel5.add(em);
		
		JTextField email =new JTextField("email@gmail.com");
		email.setBounds(350,55,150,25);
		panel5.add(email);
		
		JLabel pone =new JLabel("Phone:");
		pone.setBounds(300,100,100,30);
		panel5.add(pone);
		
		JTextField phone =new JTextField();
		phone.setBounds(350,105,150,25);
		panel5.add(phone);
		
		JLabel idNumber =new JLabel("Id:");
		idNumber.setBounds(300,150,100,30);
		panel5.add(idNumber);
		
		JTextField Id =new JTextField();
		Id.setBounds(350,155,150,25);
		
		Id.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {	
				if(e.getKeyCode()==8) {
					key2=Id.getText();
				}
			else if((e.getKeyChar()=='0'||e.getKeyChar()=='1'||e.getKeyChar()=='2'||e.getKeyChar()=='3'||
							e.getKeyChar()=='4'||e.getKeyChar()=='5'||e.getKeyChar()=='6'||e.getKeyChar()=='7'||
							e.getKeyChar()=='8'||e.getKeyChar()=='9')&&(Id.getText().length()<=8)) {
						key2 =key2 + e.getKeyChar();
					}
					Id.setText(key2);
			}
			
		});
		panel5.add(Id);
		
		JLabel pro =new JLabel("profile:");
		pro.setBounds(300,200,100,30);
		panel5.add(pro);
		JButton  profilepic =new JButton("click to choose");
		profilepic.setBounds(350,205,150,25);
		profilepic.setFocusable(false);
		profilepic.setBackground(Color.green);
		panel5.add(profilepic);
		profilepic.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
				JFileChooser myfile = new JFileChooser();
				myfile.setFileFilter(filter);
				int result = myfile.showOpenDialog(frame);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					int  rm =(int)Math.random()*1000;
					File myprofile =myfile.getSelectedFile();
					mypiclocation =myprofile.getAbsolutePath().replace("\\", "/");
					String path =dm.Imageresize(myprofile.getAbsolutePath().replace("\\", "/"), 150, 150, "image"+rm);
					ImageIcon prof =new  ImageIcon(path);
					JLabel profimage =new JLabel(prof);
					profimage.setBounds(350, 250, 150, 150);
					panel5.add(profimage);
					profimage.repaint();
					panel5.repaint();
					
				}
			}
			
			
			
		});
		lc =new LectureControll();
		JButton submit =new JButton("submit/validate");
		submit.setBounds(50,330,200,40);
		submit.setFocusable(false);
		submit.setForeground(Color.MAGENTA);
		submit.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
		submit.addActionListener(new ActionListener() {
	
			
			@Override
			public void actionPerformed(ActionEvent e) {
				   if(firstname.getText().isEmpty() ||secondname.getText().isEmpty()||lastname.getText().isEmpty()||
					dateofbirth.getText().isEmpty()||email.getText().isEmpty()||Id.getText().isEmpty()||
					phone.getText().isEmpty()||mypiclocation.isBlank()) {
					JLabel val = new JLabel ("please fill all the fields");
					val.setBounds(50,280,300,40);
					val.setForeground(Color.red);
					val.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					panel5.add(val);
					panel5.repaint();
				}else {
					String ddata []= {firstname.getText(),secondname.getText(),lastname.getText(),dateofbirth.getText(),
										(String)gender.getSelectedItem(),email.getText(),Id.getText(),mypiclocation};
					String responce1 [] =lc.addLecture(ddata);
					panel5.removeAll();
					
					String message ="you have added another Lecture sucessfull";
					String username ="your Lec number is :"+ responce1[0];
					String password ="your id which is :"+ responce1[1];
					String congratulation ="Welcome approad";
					
					
					JLabel mess = new JLabel(message);
					mess.setForeground(Color.red);
					mess.setBounds(20,20,500,40);
					mess.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					JLabel use = new JLabel(username);
					use.setForeground(Color.red);
					use.setBounds(20,65,500,40);
					use.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					JLabel pass = new JLabel(password);
					pass.setForeground(Color.red);
					pass.setBounds(20,105,500,40);
					pass.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					JLabel cong =new JLabel(congratulation);
					cong.setForeground(Color.red);
					cong.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					cong.setBounds(20,150,500,40);
					
					String off = us.resizeEmage("photos\\office.jpg", 500, 280, "ofice");
					
					ImageIcon image =new ImageIcon (off);
					JLabel office =new JLabel(image);
					office.setBounds(10,200,500,200);
					panel5.add(pass);
					panel5.add(office);
					panel5.add(mess);
					panel5.add(cong);
					panel5.add(use);
					panel5.repaint();
				
				}
				
			}
			
		});
		
		panel5.add(submit);
		panel5.repaint();
	}
	int j=1;
	public void assignLectureCourses() {
		panel5.removeAll();
		panel5.repaint();
		scroll1.setVisible(false);
		panel5.setBounds(10,100,530,420);
		JLabel label =new JLabel("enter the valid course name to table");
		label.setBounds(20,20,500,30);
		label.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
		label.setForeground(Color.blue);
		
		DefaultTableModel model =new DefaultTableModel();
		model.addColumn("Lec number");
		model.addColumn("Course1");
		model.addColumn("course2");
		model.addColumn("course3");
		lc =new LectureControll();
		
		String detai [][]=lc.desplayLectureCourses();
		for(String display[] : detai) {
			model.addRow(display);
		}
		i=0;
		String update []= new String[4];
		JTable table =new JTable(model);
		JButton button =new JButton("update ");
		button.setBounds(400,380,100,30);
		button.setFocusable(false);
		button.setBackground(Color.cyan);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(String display[] : detai) {
					for(j=1;j<4;j++) {
						update[0]=display[0];
						if(j<=3) {
						update[j]=(String) table.getValueAt(i, j);	
						}
					}
					//////System.out.println(update[0]+update[1]+update[2]+update[3]);
					lc.assignLecture_Course(update);
					j=1;
					i++;
				}
				assignLectureCourses();
				i=0;
				
			}
			
		});
		
		
		JScrollPane pane =new JScrollPane(table);
		pane.setBounds(20,50,500,330);
		panel5.add(pane);
		panel5.add(label);
		panel5.add(button);
		panel5.repaint();
	}
	librarianController lib =new librarianController();
	public void addlibrarian() {
		panel5.removeAll();
		scroll1.setVisible(false);
		panel5.setBounds(10,100,530,420);
		JLabel atitle = new JLabel("ENTER THE LIBRARIAN  DETAILS");
		atitle.setBounds(20,20,500,30);
		atitle.setForeground(Color.red);
		atitle.setFont(new Font("arial",Font.BOLD+Font.ITALIC,18));
		panel5.add(atitle);
		
		JLabel fname =new JLabel("First name:");
		fname.setBounds(20,50,100,30);
		panel5.add(fname);
		
		JTextField firstname =new JTextField();
		firstname.setBounds(100,55,150,25);
		panel5.add(firstname);
		
		JLabel sname =new JLabel("second name:");
		sname.setBounds(20,100,100,30);
		panel5.add(sname);
		
		JTextField secondname =new JTextField();
		secondname.setBounds(100,105,150,25);
		panel5.add(secondname);
		
		JLabel lname =new JLabel("last name:");
		lname.setBounds(20,150,100,30);
		panel5.add(lname);
		
		JTextField lastname =new JTextField();
		lastname.setBounds(100,155,150,25);
		panel5.add(lastname);
		
		JLabel date =new JLabel("date of birth:");
		date.setBounds(20,200,100,30);
		panel5.add(date);
		
		
		JTextField dateofbirth =new JTextField("yyyy-mm-dd");
		dateofbirth.setBounds(100,205,150,25);
		panel5.add(dateofbirth);
		
		JLabel gen =new JLabel("gender:");
		gen.setBounds(20,250,100,30);
		panel5.add(gen);
		
		
		String gende [] = {"male","Female","others"};
		JComboBox<Object> gender =new JComboBox<Object>(gende);
		gender.setBounds(100,250,150,25);
		panel5.add(gender);
		
		JLabel em =new JLabel("Email:");
		em.setBounds(300,50,100,30);
		panel5.add(em);
		
		JTextField email =new JTextField("email@gmail.com");
		email.setBounds(350,55,150,25);
		panel5.add(email);
		
		JLabel pone =new JLabel("Phone:");
		pone.setBounds(300,100,100,30);
		panel5.add(pone);
		
		JTextField phone =new JTextField();
		phone.setBounds(350,105,150,25);
		panel5.add(phone);
		
		JLabel idNumber =new JLabel("Id:");
		idNumber.setBounds(300,150,100,30);
		panel5.add(idNumber);
		
		JTextField Id =new JTextField();
		Id.setBounds(350,155,150,25);
		
		Id.addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}
			public void keyPressed(KeyEvent e) {
			}
			public void keyReleased(KeyEvent e) {	
				if(e.getKeyCode()==8) {
					key2=Id.getText();
				}
			else if((e.getKeyChar()=='0'||e.getKeyChar()=='1'||e.getKeyChar()=='2'||e.getKeyChar()=='3'||
							e.getKeyChar()=='4'||e.getKeyChar()=='5'||e.getKeyChar()=='6'||e.getKeyChar()=='7'||
							e.getKeyChar()=='8'||e.getKeyChar()=='9')&&(Id.getText().length()<=8)) {
						key2 =key2 + e.getKeyChar();
					}
					Id.setText(key2);
			}
			
		});
		panel5.add(Id);
		
		JLabel pro =new JLabel("profile:");
		pro.setBounds(300,200,100,30);
		panel5.add(pro);
		JButton  profilepic =new JButton("click to choose");
		profilepic.setBounds(350,205,150,25);
		profilepic.setFocusable(false);
		profilepic.setBackground(Color.green);
		panel5.add(profilepic);
		profilepic.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "jpeg", "png", "gif");
				JFileChooser myfile = new JFileChooser();
				myfile.setFileFilter(filter);
				int result = myfile.showOpenDialog(frame);
				if(result == JFileChooser.APPROVE_OPTION)
				{
					int  rm =(int)Math.random()*1000;
					File myprofile =myfile.getSelectedFile();
					mypiclocation =myprofile.getAbsolutePath().replace("\\", "/");
					String path =dm.Imageresize(myprofile.getAbsolutePath().replace("\\", "/"), 150, 150, "image"+rm);
					ImageIcon prof =new  ImageIcon(path);
					profimage.setIcon(prof); 
					profimage.setBounds(350, 250, 150, 150);
					panel5.add(profimage);
					profimage.repaint();
					panel5.repaint();
					
				}
			}
			
			
			
		});
		
		JButton submit =new JButton("submit/validate");
		submit.setBounds(50,360,200,40);
		submit.setFocusable(false);
		submit.setForeground(Color.MAGENTA);
		submit.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
		submit.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				   if(firstname.getText().isEmpty() ||secondname.getText().isEmpty()||lastname.getText().isEmpty()||
					dateofbirth.getText().isEmpty()||email.getText().isEmpty()||Id.getText().isEmpty()||
					phone.getText().isEmpty()||mypiclocation.isBlank()) {
					JLabel val = new JLabel ("please fill all the fields");
					val.setBounds(50,330,300,40);
					val.setForeground(Color.red);
					val.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					panel5.add(val);
					panel5.repaint();
				}else {
					String ddata []= {firstname.getText().toLowerCase(),secondname.getText().toLowerCase(),lastname.getText().toLowerCase(),dateofbirth.getText(),
										(String)gender.getSelectedItem(),email.getText(),Id.getText(),mypiclocation};
					String responce1 [] =lib.addLibrarian(ddata);
				
					panel5.removeAll();
					
					String message ="you have added another Librarian sucessfull";
					String username ="your work number is :"+ responce1[1];
					String password ="your id which is :"+ responce1[0];
					String congratulation ="your can login to your portal";
					
					
					JLabel mess = new JLabel(message);
					mess.setForeground(Color.red);
					mess.setBounds(20,20,500,40);
					mess.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					JLabel use = new JLabel(username);
					use.setForeground(Color.red);
					use.setBounds(20,65,500,40);
					use.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					JLabel pass = new JLabel(password);
					pass.setForeground(Color.red);
					pass.setBounds(20,105,500,40);
					pass.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					JLabel cong =new JLabel(congratulation);
					cong.setForeground(Color.red);
					cong.setFont(new Font("arial",Font.BOLD+Font.ITALIC,20));
					cong.setBounds(20,150,500,40);
					
					String off = us.resizeEmage("photos\\office.jpg", 500, 280, "ofice");
					
					ImageIcon image =new ImageIcon (off);
					JLabel office =new JLabel(image);
					office.setBounds(10,200,500,200);
					panel5.add(pass);
					panel5.add(office);
					panel5.add(mess);
					panel5.add(cong);
					panel5.add(use);
					panel5.repaint();
				
				}
				
			}
			
		});
		
		
		
		
		
		
		panel5.add(submit);
		panel5.repaint();
	}
	public void removeLibrarian() {
		panel5.removeAll();
		scroll1.setVisible(false);
		panel5.repaint();
		panel5.setBounds(10,100,530,420);
		JLabel label =new JLabel("this is the list of the librarian available");
		label.setBounds(20,20,500,30);
		label.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		panel5.add(label);
		
		
		JLabel label1 =new JLabel("enter the lib number");
		label1.setBounds(20,380,200,30);
		label1.setFont(new Font("Arial",Font.ITALIC,14));
		panel5.add(label1);
		
		
		JTextField tx =new JTextField();
		tx.setBounds(180,380,200,30);
		panel5.add(tx);
		
		JPanel panel =new JPanel();
		panel.setBackground(Color.blue);
		panel.setLayout(new GridLayout(0,3,1,1));
		JScrollPane pane =new JScrollPane(panel);
		
		String list[][]=lib.listOfLibrarian();
		for(String mylist[]: list) {
			
			String locile = us.resizeEmage(mylist[8], 40, 40, mylist[3]+mylist[2]);
			ImageIcon icon =new ImageIcon(locile);
			JLabel label2 =new JLabel(icon);
			panel.add(label2);
			
			JLabel label3 =new JLabel(mylist[5]);
			label3.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					tx.setText(label3.getText());
				}
			});
			panel.add(label3);
			JLabel label4 =new JLabel(mylist[0]+ "  "+mylist[2]);
			panel.add(label4);
		}
		
		JButton btn =new JButton("eliminate");
		btn.setBounds(390,380,100,30);
		btn.setFocusable(false);
		btn.setBackground(Color.MAGENTA);
		btn.setForeground(Color.red);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lib.removelibrarian(tx.getText());
				removeLibrarian();
				
			}
			
		});
		panel5.add(btn);
		
		
		
		pane.setBounds(20,100,500,250);
		panel.setBounds(15,10,500,250);
		panel5.add(pane);
	}
	public void stdmyinformation(String number) {
		panel5.removeAll();
		panel5.repaint();
		scroll1.setVisible(false);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		UserController us =new UserController();
		StudentController st =new StudentController();
		String mydetails[] = st.mydetails(number);
	
		////System.out.println(mydetails[8]);
		String MyimageLocation = us.resizeEmage(mydetails[9], 150, 150, mydetails[2]);
		ImageIcon myImage =new ImageIcon( MyimageLocation);
		JLabel myin =new JLabel(myImage);
		myin.setBounds(20,20,150,150);
		panel5.add(myin);
		
		JLabel first1 = new JLabel("First name :");
		first1.setBounds(20,200,150,30);
		panel5.add(first1);
		
		JLabel first2 = new JLabel(mydetails[0]);
		first2.setBounds(100,200,150,30);
		panel5.add(first2);
		
		JLabel sec1 = new JLabel("second  name :");
		sec1.setBounds(20,250,150,30);
		panel5.add(sec1);
		
		JLabel sec2 = new JLabel(mydetails[1]);
		sec2.setBounds(120,250,150,30);
		panel5.add(sec2);
		
		JLabel third1 = new JLabel("Last name :");
		third1.setBounds(20,300,150,30);
		panel5.add(third1);
		
		JLabel third2 = new JLabel(mydetails[2]);
		third2.setBounds(120,300,150,30);
		panel5.add(third2);
		
		JLabel date1 = new JLabel("Date of birth:");
		date1.setBounds(20,350,150,30);
		panel5.add(date1);
		
		JLabel date2 = new JLabel(mydetails[3]);
		date2.setBounds(120,350,150,30);
		panel5.add(date2);
		
		JLabel type = new JLabel("STUDENT");
		type.setBounds(250,50,300,50);
		type.setForeground(Color.red);
		type.setFont(new Font("arial",Font.BOLD+Font.ITALIC,25));
		panel5.add(type);
		
		
		JLabel id1 = new JLabel("ID :");
		id1.setBounds(250,100,150,30);
		panel5.add(id1);
		
		JLabel id2 = new JLabel(mydetails[7]);
		id2.setBounds(300,100,150,30);
		panel5.add(id2);
		
		JLabel gender1 = new JLabel("gender :");
		gender1.setBounds(250,150,150,30);
		panel5.add(gender1);
		
		JLabel gender2 = new JLabel(mydetails[4]);
		gender2.setBounds(300,150,150,30);
		panel5.add(gender2);
		
		JLabel work1 = new JLabel("reg number :");
		work1.setBounds(250,250,150,30);
		panel5.add(work1);
		
		JLabel work2 = new JLabel(mydetails[5]);
		work2.setBounds(350,250,150,30);
		panel5.add(work2);
		
		JLabel email1 = new JLabel("email:");
		email1.setBounds(250,200,150,30);
		panel5.add(email1);
		
		JLabel email2 = new JLabel(mydetails[6]);
		email2.setBounds(300,200,150,30);
		panel5.add(email2);
		
		JLabel program1 = new JLabel("Program: ");
		program1.setBounds(250,300,150,30);
		panel5.add(program1);
		
		JLabel program = new JLabel(mydetails[8]);
		program.setBounds(330,300,150,30);
		panel5.add(program);
	}
	
	public void coursedetails(String course) {
		scroll1.setVisible(false);
		panel5.removeAll();
		panel5.repaint();
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		
		JLabel label =new JLabel("course description ");	
		label.setBounds(150,20,500,30);
		label.setForeground(Color.MAGENTA);
		label.setFont(new Font("Areil",Font.BOLD+Font.ITALIC,18));
		panel5.add(label);
		
		
		UserController us =new UserController();
		String logolocation = us.resizeEmage("photos\\reportlogo.jpeg", 150, 150, "reportlogo");
		ImageIcon reportLogo =new ImageIcon(logolocation);
		JLabel label13 =new JLabel(reportLogo);
		label13.setBounds(20,50,150,140);
		panel5.add(label13);
		
		JLabel label15 =new JLabel("P.O BOX : 109-60400 ,CHUKA");
		label15.setBounds(200,0,500,140);
		panel5.add(label15);
		
		JLabel label16 =new JLabel("TELEPHONE : 020-2310512");
		label16.setBounds(200,30,500,140);
		panel5.add(label16);
		
		JLabel label17 =new JLabel("EMAIL :careerservices@chuka.ac.ke");
		label17.setBounds(200,60,500,140);
		panel5.add(label17);
		
		JLabel label18 =new JLabel("DECTORATE OF CAREER SERVICES");
		label18.setBounds(200,90,500,140);
		panel5.add(label18);
		
		JLabel label1 =new JLabel("CHUKA UNIVERSITY DEPARTMENT OF CAREAR AND SERVICES");
		label1.setBounds(20,230,500,20);
		label1.setForeground(Color.red);
		label1.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		panel5.add(label1);
	
		
		JLabel label2 =new JLabel("WE ARE PLEASED TO INFORM YOU THAT WE OFFER THE FOLLOWING COURSE");
		label2.setBounds(20,260,500,20);
		label2.setForeground(Color.blue);
		label2.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,12));
		panel5.add(label2);
		
		
		JLabel label3 =new JLabel("Course title:  " +course);
		label3.setBounds(20,300,500,20);
		label3.setForeground(Color.blue);
		label3.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,12));
		panel5.add(label3);
		StudentController std =new StudentController();
		JLabel label4 =new JLabel("Course code:   "+ std.getCoursecode(course));
		label4.setBounds(20,350,500,20);
		label4.setForeground(Color.blue);
		label4.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,12));
		panel5.add(label4);
		
		
		JLabel label5 =new JLabel("WELCOME AND BE A PARTICIPANT TODAY");
		label5.setBounds(20,400,500,20);
		label5.setForeground(Color.blue);
		label5.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,12));
		panel5.add(label5);
	}
	public void getBookdetails(String title) {
		panel5.removeAll();
		panel5.repaint();
		scroll1.setVisible(false);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		String book[]=lib.getbookdetails(title);
		////System.out.println(title);
		
		JLabel pageTitle =new JLabel("book description");
		pageTitle.setBounds(20,20,500,20);
		pageTitle.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		panel5.add(pageTitle);
		
		JLabel ltitle =new JLabel("Title:");
		ltitle.setBounds(20,50,100,30);
		panel5.add(ltitle);
		
		JTextField title1 =new JTextField(book[0]);
		title1.setEditable(false);
		title1.setBounds(100,55,150,25);
		panel5.add(title1);
		
		JLabel lversion =new JLabel("Version:");
		lversion.setBounds(20,100,100,30);
		panel5.add(lversion);
		
		JTextField version =new JTextField(book[1]);
		version.setEditable(false);
		version.setBounds(100,105,150,25);
		panel5.add(version);
		
		JLabel lISNN =new JLabel("ISNN:");
		lISNN.setBounds(20,150,100,30);
		panel5.add(lISNN);
		
		JTextField ISNN =new JTextField(book[2]);
		ISNN.setBounds(100,155,150,25);
		ISNN.setEditable(false);
		panel5.add(ISNN);
		
		JLabel ledition =new JLabel("edition:");
		ledition.setBounds(20,200,100,30);
		panel5.add(ledition);
		
		
		JTextField edition =new JTextField(book[3]);
		edition.setBounds(100,205,150,25);
		edition.setEditable(false);
		panel5.add(edition);
		
		JLabel lPublisher =new JLabel("publisher:");
		lPublisher.setBounds(20,250,100,30);
		panel5.add(lPublisher);
		
		JTextField publisher =new JTextField(book[4]);
		publisher.setEditable(false);
		publisher.setBounds(100,255,150,25);
		panel5.add(publisher);
		
		JLabel lavailable =new JLabel("Available:");
		lavailable.setBounds(20,300,100,30);
		panel5.add(lavailable);
		
		
		JTextField available =new JTextField(book[6]);
		available.setBounds(100,305,150,25);
		available.setEditable(false);
		panel5.add(available);
		
		
		JLabel lreserve =new JLabel("reserve");
		lreserve.setBounds(20,350,150,25);
		panel5.add(lreserve);
		
		JTextField reserve =new JTextField("0");
		reserve.setEditable(false);
		reserve.setEditable(false);
		reserve.setBounds(100,355,150,25);
		panel5.add(reserve);
		
		////System.out.println(book[5]);
		UserController us =new UserController();
		int  rm =(int)Math.random()*1000;
		String path =us.resizeEmage(book[5], 250, 250, "imae"+rm);
		ImageIcon bookimage1 =new  ImageIcon(path);
		JLabel bookimage =new JLabel(bookimage1);
		bookimage.setBounds(250, 25, 250, 250);
		panel5.add(bookimage);
		
		bookController bk =new bookController();
		String name =bk.CheckBook(title,username);
		JLabel req =new JLabel(name);
		req.setBounds(260,300,200,25);
		req.setBorder(BorderFactory.createRaisedBevelBorder());
		req.setBackground(Color.cyan);
		req.setOpaque(true);
		req.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(req.getText().equals("RESERVE")) {
				bk.borre(title, "unchecked","not borro", username,"assign");
				}else if(req.getText().equals("BORROW")) {
					bk.borre(title, "unchecked",username,"not reserv","assign");
				}
				getBookdetails(title);
			}
		});
		panel5.add(req);	
	}
	public void lcmyinformation(String info) {
		panel5.removeAll();
		panel5.repaint();
		scroll1.setVisible(false);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		
		UserController us =new UserController();
		lc =new LectureControll();
		String mydetails[] = lc.getMyinformation(info);
	
		////System.out.println(mydetails[8]);
		String MyimageLocation = us.resizeEmage(mydetails[8], 150, 150, mydetails[2]);
		ImageIcon myImage =new ImageIcon( MyimageLocation);
		JLabel myin =new JLabel(myImage);
		myin.setBounds(20,20,150,150);
		panel5.add(myin);
		
		JLabel first1 = new JLabel("First name :");
		first1.setBounds(20,200,150,30);
		panel5.add(first1);
		
		JLabel first2 = new JLabel(mydetails[0]);
		first2.setBounds(100,200,150,30);
		panel5.add(first2);
		
		JLabel sec1 = new JLabel("second  name :");
		sec1.setBounds(20,250,150,30);
		panel5.add(sec1);
		
		JLabel sec2 = new JLabel(mydetails[1]);
		sec2.setBounds(120,250,150,30);
		panel5.add(sec2);
		
		JLabel third1 = new JLabel("Last name :");
		third1.setBounds(20,300,150,30);
		panel5.add(third1);
		
		JLabel third2 = new JLabel(mydetails[2]);
		third2.setBounds(120,300,150,30);
		panel5.add(third2);
		
		JLabel date1 = new JLabel("Date of birth:");
		date1.setBounds(20,350,150,30);
		panel5.add(date1);
		
		JLabel date2 = new JLabel(mydetails[3]);
		date2.setBounds(120,350,150,30);
		panel5.add(date2);
		
		JLabel type = new JLabel("LECTURER");
		type.setBounds(250,50,300,50);
		type.setForeground(Color.red);
		type.setFont(new Font("arial",Font.BOLD+Font.ITALIC,25));
		panel5.add(type);
		
		
		JLabel id1 = new JLabel("ID :");
		id1.setBounds(250,100,150,30);
		panel5.add(id1);
		
		JLabel id2 = new JLabel(mydetails[7]);
		id2.setBounds(300,100,150,30);
		panel5.add(id2);
		
		JLabel gender1 = new JLabel("gender :");
		gender1.setBounds(250,150,150,30);
		panel5.add(gender1);
		
		JLabel gender2 = new JLabel(mydetails[4]);
		gender2.setBounds(350,150,150,30);
		panel5.add(gender2);
		
		JLabel work1 = new JLabel("Lec number :");
		work1.setBounds(250,250,150,30);
		panel5.add(work1);
		
		JLabel work2 = new JLabel(mydetails[5]);
		work2.setBounds(350,250,150,30);
		panel5.add(work2);
		
		JLabel email1 = new JLabel("email:");
		email1.setBounds(250,200,150,30);
		panel5.add(email1);
		
		JLabel email2 = new JLabel(mydetails[6]);
		email2.setBounds(300,200,150,30);
		panel5.add(email2);
	}
}


