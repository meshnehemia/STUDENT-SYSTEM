package view;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.table.DefaultTableModel;

import controller.AdminController;
import controller.LectureControll;
import controller.StudentController;
import controller.UserController;
import controller.bookController;
import controller.courseController;
import controller.librarianController;

public class LectureView {
	private LectureControll lc;
	private String lec_number="";
	private String first_name ="";
	private String email ="";
	//private String second_name="";
	private String last_name="";
	//private String myImage="";
	JPanel holder =new JPanel();
	private JPanel panel1 =new JPanel();
	private JPanel panel4 =new JPanel();
	private JPanel panel5 =new JPanel();
	private JPanel panel3=new JPanel();
	private JPanel panel2 =new JPanel();
	private JFrame frame = new JFrame();
	
	public LectureView(String lecnumber) {
		//UserController us =new UserController();
		lc =new LectureControll();
		String mydetails[] = lc.getMyinformation(lecnumber);
		lec_number = lecnumber;
		first_name=mydetails[0];
		//second_name=mydetails[1];
		last_name=mydetails[2];
		email =mydetails[6];
		
		frame.setBounds(100,50,1000,600);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("welcome Approad"+lecnumber);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel1 =new JPanel();
		panel1.setBounds(10,10,400,540);
		panel1.setBackground(Color.lightGray);
		SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.white, Color.white);
		panel1.setBorder(border);
		panel1.setLayout(null);
		
		panel2.setBounds(68,150,250,350);
		panel2.setBackground(Color.gray);
		panel2.setBorder(border);
		panel2.setLayout(new FlowLayout());

		panel3.setBounds(430,10,550,540);
		panel3.setBackground(Color.blue);
		border = new SoftBevelBorder(SoftBevelBorder.LOWERED, Color.white, Color.white);
		panel3.setBorder(border);
		panel3.setLayout(null);
		
		JLabel myInformation =new JLabel("           MY INFORMATION");
		myInformation.setBounds(25,20,200,40);
		myInformation.setForeground(Color.BLUE);
		myInformation.setBackground(Color.cyan);
		myInformation.setOpaque(true);
		myInformation.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		myInformation.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		myInformation.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				 myinformation(lec_number);
			}
			
			
		});
		
		JLabel entermarks =new JLabel("             ENTER MARKS ");
		entermarks.setBounds(25,85,200,40);
		entermarks.setForeground(Color.BLUE);
		entermarks.setBackground(Color.cyan);
		entermarks.setOpaque(true);
		entermarks.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		entermarks.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		entermarks.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				entermarks();
			}
			
			
		});
		entermarks.setLayout(new FlowLayout());
		
		JLabel report =new JLabel("                 REPORT ");
		report.setBounds(25,150,200,40);
		report.setForeground(Color.BLUE);
		report.setBackground(Color.cyan);
		report.setOpaque(true);
		report.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		report.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		report.setLayout(new FlowLayout());
		report.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				 myReport();
			}
			
			
		});
		
		
		
		
		JLabel library =new JLabel("                 LIBRARY ");
		library.setBounds(25,215,200,40);
		library.setForeground(Color.BLUE);
		library.setBackground(Color.cyan);
		library.setOpaque(true);
		library.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		library.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		library.setLayout(new FlowLayout());
		library.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				availableBooks();
			}
			
			
		});
		
		
		JLabel search =new JLabel("                 SEARCH ");
		search.setBounds(25,280,200,40);
		search.setForeground(Color.BLUE);
		search.setBackground(Color.cyan);
		search.setOpaque(true);
		search.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		search.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		search.setLayout(new FlowLayout());
		search.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				search();
			}
			
			
		});
		
		
		//JPanel panel4 =new JPanel();
		panel4.setBounds(0,0,550,50);
		panel4.setBackground(Color.blue);
		
		
		JLabel title =new JLabel("WELCOME");
		title.setBounds(25,280,200,40);
		title.setBackground(Color.blue);
		title.setOpaque(true);
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,30));
		
		lc =new LectureControll();
		String record[] = lc.loginDetails(lecnumber);
		AdminController ac =new AdminController();
		String location =ac.Imageresize(record[8], 80, 80,first_name);
		ImageIcon image =new ImageIcon(location);
		JLabel label =new JLabel(image);
		label.setBounds(20,20,80,80);
		frame.setIconImage(image.getImage());
		
		JLabel label1 =new JLabel(record[1]+"    "+record[2]);
		label1.setBounds(130,20,500,50);
		label1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
		
		JLabel label2 =new JLabel("Lecturer ");
		label2.setBounds(130,60,500,50);
		label2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,30));
		
		panel5.setBounds(20,70,510,440);
		panel5.setLayout(null);
		panel5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		UserController uc =new UserController();
		location =uc.resizeEmage("photos\\study.jpeg", 510, 440, first_name);
		ImageIcon image2 =new ImageIcon(location);
		JLabel Limage =new JLabel(image2);
		Limage.setBounds(0,0,510,440);
		
		panel5.add(Limage);
		
		panel4.add(title);
		panel3.add(panel4);
		panel2.setLayout(null);
		panel2.add(report);
		panel2.add(library);
		panel2.add(search);
		panel2.add(entermarks);
		panel2.add(myInformation);
		panel1.add(label2);
		panel1.add(panel2);
		panel1.add(label1);
		panel1.add(label);
		panel3.add(panel5);
		frame.add(panel3);
		frame.setVisible(true);
		frame.add(panel1);
	}
	public void entermarks() {
		panel5.removeAll();
		panel5.repaint();
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		JLabel label =new JLabel("enter marks field click the course name to continue");
		label.setBounds(20,10,500,30);
		label.setFont(new Font("Arial", Font.BOLD+Font.ITALIC,20));
		label.setForeground(Color.blue);
		
		
		JLabel course1 =new JLabel("course 1");
		course1.setBounds(20,60,150,20);
		course1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,17));
		
		JLabel course2 =new JLabel("course 2");
		course2.setBounds(190,60,150,20);
		course2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,17));
		
		
		JLabel course3 =new JLabel("course 3");
		course3.setBounds(350,60,150,20);
		course3.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,17));
		
		lc =new LectureControll();
		String courses1[] =lc.checkCourseDetails(lec_number);
		
		JLabel label10 =new JLabel("code :"+lc.getCoursecode(courses1[1]));
		label10.setBounds(20,150,200,20);
		panel5.add(label10);
		
		
		JLabel label11 =new JLabel("code : "+lc.getCoursecode(courses1[2]));
		label11.setBounds(180,150,200,20);
		panel5.add(label11);
		
		
		JLabel label12 =new JLabel("code : "+lc.getCoursecode(courses1[3]));
		label12.setBounds(350,150,200,20);
		panel5.add(label12);
		
		
		UserController us =new UserController();
		String logolocation = us.resizeEmage("photos\\studylogo.jpeg", 500, 250, "studentlogo");
		ImageIcon reportLogo =new ImageIcon(logolocation);
		JLabel label13 =new JLabel(reportLogo);
		label13.setBounds(20,180,500,250);
		panel5.add(label13);
		
		
		
		JLabel title1 =new JLabel("name:");
		title1.setBounds(20,100,150,20);
		
		JLabel c1 =new JLabel(courses1[1]);
		c1.setBounds(60,100,100,20);
		c1.setBackground(Color.cyan);
		c1.setOpaque(true);
		c1.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				updateMarks(courses1[1]);
				
				
			}
			
		});
		
		JLabel title2 =new JLabel("name:");
		title2.setBounds(190,100,150,20);
	
		JLabel c2 =new JLabel(courses1[2]);
		c2.setBounds(230,100,100,20);
		c2.setBackground(Color.cyan);
		c2.setOpaque(true);
		c2.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				updateMarks(courses1[2]);
				
				
			}
			
		});
		
		JLabel title3 =new JLabel("name:");
		title3.setBounds(350,100,150,20);
		
		JLabel c3 =new JLabel(courses1[3]);
		c3.setBounds(390,100,100,20);
		c3.setBackground(Color.cyan);
		c3.setOpaque(true);
		c3.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				updateMarks(courses1[3]);
				
				
			}
			
		});
		
		
		
		
		panel5.add(c1);
		panel5.add(c2);
		panel5.add(c3);
		panel5.add(title1);
		panel5.add(title2);
		panel5.add(title3);
		panel5.add(course1);
		panel5.add(course2);
		panel5.add(course3);
		panel5.add(label);
		panel5.repaint();
	}
	int students=0;
	public void updateMarks(String coursename) {
		panel5.removeAll();
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		students=0;
		JLabel label =new JLabel("you are entering the marks for "+coursename);
		label.setBounds(20,10,500,30);
		label.setFont(new Font("Arial", Font.BOLD+Font.ITALIC,20));
		label.setForeground(Color.blue);
		
		DefaultTableModel model =new DefaultTableModel();
		model.addColumn("name");
		model.addColumn("admission");
		model.addColumn("course");
		model.addColumn("cat");
		model.addColumn("exam");
		lc =new LectureControll();
		String list[][] =lc.getStudent_courses(coursename);
		for(int w=0; w<list.length;w++) {
			if(list[w][0]!=null) {
				model.addRow(list[w]);
				students++;
			}
		}
		JTable table =new JTable(model);
		JScrollPane pane =new JScrollPane(table);
		pane.setBounds(20,50,480,350);
		
		JButton button =new JButton("UPDATE MARKS");
		button.setBounds(340,405,150,30);
		button.setFocusable(false);
		button.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		button.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,+14));
		button.setForeground(Color.ORANGE);
		button.setBackground(Color.DARK_GRAY);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(int z =0; z<students;z++) {
					lc.setCatScore((String)table.getValueAt(z, 1), coursename,(String)table.getValueAt(z, 3));
					lc.setExamScore((String)table.getValueAt(z, 1), coursename,(String) table.getValueAt(z, 4));
					updateMarks(coursename);
					
				}
				
			}
			
		});
		
		
		
		
		panel5.add(button);
		panel5.add(pane);
		panel5.add(label);
		panel5.repaint();
	}
	public void myinformation(String info) {
		panel5.removeAll();
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		panel5.repaint();
		
		UserController us =new UserController();
		lc =new LectureControll();
		String mydetails[] = lc.getMyinformation(info);
	
		//System.out.println(mydetails[8]);
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
	public void  myReport() {
		panel5.removeAll();
		panel5.repaint();
		
		
		JLabel TITLE =new JLabel("LECTURES REPORT");
		TITLE.setBounds(100,20,500,30);
		TITLE.setForeground(Color.BLUE);
		TITLE.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,30));
		panel5.add(TITLE);
		
		UserController us =new UserController();
		String logolocation = us.resizeEmage("C:\\Users\\meshack nehemia\\Desktop\\student system\\studentsystem\\photos\\reportlogo.jpeg", 150, 150, "reportlogo");
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
		
		
		
		JLabel label =new JLabel("Name  : "+first_name+" "+last_name);
		label.setBounds(20,200,250,20);
		label.setForeground(Color.red);
		label.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		panel5.add(label);
		
		
		JLabel label1 =new JLabel("Lec number  : "+lec_number);
		label1.setBounds(300,200,300,20);
		label1.setForeground(Color.red);
		label1.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		
		JLabel label4 =new JLabel("ASSIGNED COURSES");
		label4.setBounds(20,250,200,20);
		label4.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		panel5.add(label4);
		
		JLabel label14 =new JLabel("LEC EMAIL: "+email);
		label14.setBounds(180,250,200,20);
		label14.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		panel5.add(label14);
		
		
		JLabel label3 =new JLabel("course1");
		label3.setBounds(20,300,200,20);
		label3.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		
		JLabel label5 =new JLabel("course2");
		label5.setBounds(180,300,200,20);
		label5.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		
		
		JLabel label6 =new JLabel("course3");
		label6.setBounds(350,300,200,20);
		label6.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		
		
		lc =new LectureControll();
		String courses[] =lc.checkCourseDetails(lec_number);
		
		JLabel label7 =new JLabel("title :"+courses[1]);
		label7.setBounds(20,350,200,20);
		
		
		JLabel label8 =new JLabel("title :"+courses[2]);
		label8.setBounds(180,350,200,20);
		
		
		
		JLabel label9 =new JLabel("title : "+courses[3]);
		label9.setBounds(350,350,200,20);
		
		JLabel label10 =new JLabel("code :"+lc.getCoursecode(courses[1]));
		label10.setBounds(20,380,200,20);
		
		
		JLabel label11 =new JLabel("code : "+lc.getCoursecode(courses[2]));
		label11.setBounds(180,380,200,20);
		
		
		
		JLabel label12 =new JLabel("code : "+lc.getCoursecode(courses[3]));
		label12.setBounds(350,380,200,20);
		
		courseController cs =new courseController();
		
		
		JLabel label19 =new JLabel("stds :"+cs.getstudentsNumber(courses[1]));
		label19.setBounds(20,410,200,20);
		
		
		JLabel label20 =new JLabel("stds : "+cs.getstudentsNumber(courses[2]));
		label20.setBounds(180,410,200,20);
		
		
		
		JLabel label21 =new JLabel("stds  : "+cs.getstudentsNumber(courses[3]));
		label21.setBounds(350,410,200,20);
		
		
		
		panel5.add(label21);
		panel5.add(label20);
		panel5.add(label19);
		
		panel5.add(label10);
		panel5.add(label11);
		panel5.add(label12);
		panel5.add(label7);
		panel5.add(label8);
		panel5.add(label9);
		panel5.add(label6);
		panel5.add(label5);
		panel5.add(label1);
		panel5.add(label3);
	}
	public void availableBooks() {
		panel5.removeAll();
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		panel5.repaint();
		panel3.remove(frame);
		JLabel label1 =new JLabel("List of the books available");
		label1.setBounds(20,20,500,30);
		label1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		label1.setForeground(Color.BLUE);
		panel5.add(label1);
		
		
		JPanel panel =new JPanel();
		
		panel.setBackground(Color.pink);
		panel.setLayout(new GridLayout(0,3,1,1));
		JScrollPane pane =new JScrollPane(panel);
		UserController us =new UserController();
		
		bookController book =new bookController();
		String list[][]=book.getbooksList();
		for(String mylist[]: list) {
			
			String locile = us.resizeEmage(mylist[5], 40, 40, mylist[0]);
			ImageIcon icon =new ImageIcon(locile);
			JLabel label2 =new JLabel(icon);
			panel.add(label2);
			
			JLabel label3 =new JLabel(mylist[0]);
			label3.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					getBookdetails(label3.getText());
				}
			});
			panel.add(label3);
			JLabel label4 =new JLabel(mylist[1]);
			panel.add(label4);
		}
		
		
		panel.setBounds(20, 50, 450,450);
		pane.setBounds(20, 50, 470,350);
		panel5.add(pane);
	}
	librarianController lib =new librarianController();
	public void getBookdetails(String title) {
		panel5.removeAll();
		panel5.repaint();
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		String book[]=lib.getbookdetails(title);
		//System.out.println(title);
		
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
		
		//System.out.println(book[5]);
		UserController us =new UserController();
		int  rm =(int)Math.random()*1000;
		String path =us.resizeEmage(book[5], 250, 250, "imae"+rm);
		ImageIcon bookimage1 =new  ImageIcon(path);
		JLabel bookimage =new JLabel(bookimage1);
		bookimage.setBounds(250, 25, 250, 250);
		panel5.add(bookimage);
		
		bookController bk =new bookController();
		String name =bk.CheckBook(title,lec_number);
		JLabel req =new JLabel(name);
		req.setBounds(260,300,200,25);
		req.setBorder(BorderFactory.createRaisedBevelBorder());
		req.setBackground(Color.cyan);
		req.setOpaque(true);
		req.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(req.getText().equals("RESERVE")) {
				bk.borre(title, "unchecked","not borro", lec_number,"assign");
				}else if(req.getText().equals("BORROW")) {
					bk.borre(title, "unchecked",lec_number,"not reserv","assign");
				}
				getBookdetails(title);
			}
		});
		panel5.add(req);
		
		
	}
	JPanel pane1 =new JPanel();
	JScrollPane  scroll1 =new JScrollPane(pane1);
	AdminController dm =new AdminController();
	
	
	
	public void search() {
		panel5.setLocation(20, 200);
        panel5.setSize(500,300);
        holder.setBackground(null);
        holder.setBounds(20,20,500,200);
        panel3.add(holder);
		
		JLabel label =new JLabel("Enter Word To search");
		label.setBounds(20,30,150,30);
		holder.add(label);
		
		JTextField srch =new JTextField();
		srch.setBounds(160,30,230,30);
		holder.add(srch);
		srch.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
				
			    pane1.setBackground(Color.LIGHT_GRAY);
			    pane1.setLayout(new GridLayout(0, 1));
			    pane1.removeAll();
			    scroll1.setVisible(true);
			    int x = 20;
			    String[] response = lc.Search(srch.getText());
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
			        pane1.revalidate();
				    pane1.repaint();
			        panel5.setVisible(true);
			        panel5.repaint();
			        scroll1.repaint();
			        pane1.add(newButton);
			        scroll1.setBounds(160, 50, 230, x);
			        holder.add(scroll1);
			    	}
			    }
				
			}
			
			
			
			
			
		});
		
		
		JButton button =new JButton("Search");
		button.setBounds(410,30,100,30);
		button.setFocusable(false);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				String availableIn =lc.SearchReturn(srch.getText());
				if(availableIn.equals("book")) {
					getBookdetails(srch.getText());
					srch.setText("");
				}else if(availableIn.equals("student")){
					stdmyinformation(srch.getText());
					srch.setText("");
				}else if(availableIn.equals("course")){
					coursedetails(srch.getText());
					srch.setText("");
				}
				
				
			}
			
		});
		holder.add(button);
		
		panel3.repaint();
		   
		}
	public void coursedetails(String course) {
		panel5.removeAll();
		panel5.repaint();
		panel3.remove(holder);
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
	
	public void stdmyinformation(String number) {
		panel5.removeAll();
		panel5.repaint();
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		UserController us =new UserController();
		StudentController st =new StudentController();
		String mydetails[] = st.mydetails(number);
	
		//System.out.println(mydetails[8]);
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
		
	
	
}



