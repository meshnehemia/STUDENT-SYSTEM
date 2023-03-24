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
import controller.StudentController;
import controller.UserController;
import controller.bookController;
import controller.librarianController;

public class StudentView {
	private String reg_number="";
	private String first_name ="";
	private String email ="";
	private String last_name="";
	JPanel holder =new JPanel();
	private String myImage="";
	private JPanel panel5 =new JPanel();
	private JPanel panel3=new JPanel();
	private JPanel panel2 =new JPanel();
	private JFrame frame = new JFrame();
	private JPanel panel1 =new JPanel();
	StudentController st =new StudentController();
	public StudentView (String reg_num) {
		
		
		String mydetails[] = st.mydetails(reg_num);
		reg_number =reg_num;
		email =mydetails[6];
		first_name =mydetails[0];
		last_name =mydetails[2];
		myImage =mydetails[9];
		ImageIcon MyImage=new ImageIcon (myImage);
		
		frame.setBounds(100,50,1000,600);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("welcome Approad");
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setIconImage(MyImage.getImage());
		
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
		myInformation.setBounds(25,40,200,40);
		myInformation.setForeground(Color.BLUE);
		myInformation.setBackground(Color.cyan);
		myInformation.setOpaque(true);
		myInformation.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		myInformation.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		myInformation.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				 myinformation(reg_number);
			}
			
			
		});
		
//		JLabel entermarks =new JLabel("             waiting  ");
//		entermarks.setBounds(25,85,200,40);
//		entermarks.setForeground(Color.BLUE);
//		entermarks.setBackground(Color.cyan);
//		entermarks.setOpaque(true);
//		entermarks.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
//		entermarks.setBorder(BorderFactory.createLoweredSoftBevelBorder());
//		entermarks.addMouseListener(new MouseAdapter() {
//			
//			public void mouseClicked(MouseEvent e) {
//				//entermarks();
//			}
//			
//			
//		});
//		entermarks.setLayout(new FlowLayout());
		
		JLabel report =new JLabel("             RESULTSLIP ");
		report.setBounds(25,120,200,40);
		report.setForeground(Color.BLUE);
		report.setBackground(Color.cyan);
		report.setOpaque(true);
		report.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		report.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		report.setLayout(new FlowLayout());
		report.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				resultSlip();
			}
			
			
		});
		
		
		
		
		JLabel library =new JLabel("                 LIBRARY ");
		library.setBounds(25,200,200,40);
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
		
		
		JPanel panel4 =new JPanel();
		panel4.setBounds(0,0,550,50);
		panel4.setBackground(Color.blue);
		
		
		JLabel title =new JLabel("WELCOME STUDENT PORTAL");
		title.setBounds(25,280,200,40);
		title.setBackground(Color.blue);
		title.setOpaque(true);
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,30));
		
		UserController cm =new UserController();
		String locatio =cm.resizeEmage("photos\\chuka.jpeg", 520, 500,first_name);
		ImageIcon imag =new ImageIcon(locatio);
		JLabel labe =new JLabel(imag);
		labe.setBounds(0,0,520,500);
		panel5.add(labe);
		
		
		
		AdminController ac =new AdminController();
		String location =ac.Imageresize(myImage, 80, 80,first_name);
		ImageIcon image =new ImageIcon(location);
		JLabel label =new JLabel(image);
		label.setBounds(20,20,80,80);
		
		JLabel label1 =new JLabel(first_name+"    "+last_name);
		label1.setBounds(130,20,500,50);
		label1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
		
		
		JLabel label2 =new JLabel(" STUDENT  ");
		label2.setBounds(130,60,500,50);
		label2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,30));
		
		panel5.setBounds(20,70,510,440);
		panel5.setLayout(null);
		panel5.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		
		panel4.add(title);
		panel3.add(panel4);
		panel2.setLayout(null);
		panel2.add(report);
		panel2.add(library);
		panel2.add(search);
//		panel2.add(entermarks);
		panel2.add(myInformation);
		panel1.add(label2);
		panel1.add(label1);
		panel1.add(label);
		panel1.add(panel2);
		panel3.add(panel5);
		frame.add(panel3);
		frame.setVisible(true);
		frame.add(panel1);
	}
	public void myinformation(String number) {
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
	public void resultSlip() {
		panel5.removeAll();
		panel5.repaint();
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		
		JLabel TITLE =new JLabel("RESULT SLIP");
		TITLE.setBounds(100,20,500,30);
		TITLE.setForeground(Color.BLUE);
		TITLE.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,30));
		panel5.add(TITLE);
		
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
		
		
		
		JLabel label =new JLabel("Name  : "+first_name+" "+last_name);
		label.setBounds(20,200,250,20);
		label.setForeground(Color.red);
		label.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		panel5.add(label);
		
		
		JLabel label1 =new JLabel("reg number  : "+reg_number);
		label1.setBounds(300,200,300,20);
		label1.setForeground(Color.red);
		label1.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		panel5.add(label1);
		
		JLabel label4 =new JLabel("ASSESMENT AND RESULT");
		label4.setBounds(20,220,200,20);
		label4.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		panel5.add(label4);
		
		JLabel label14 =new JLabel("STD EMAIL: "+email);
		label14.setBounds(230,220,200,20);
		label14.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,14));
		panel5.add(label14);
		
		
		JPanel resultPanel =new JPanel ();
		DefaultTableModel model =new DefaultTableModel();
		model.addColumn("course");
		model.addColumn("code");
		model.addColumn("cat_Score");
		model.addColumn("examScore");
		model.addColumn("av_score");
		model.addColumn("grade");
		
		
		String result [] =st.getResult(reg_number);
		 model.addRow(new Object[] {result[2],st.getCoursecode(result[2]),result[3],result[4],result[5],result[6]});
		 model.addRow(new Object[] {result[7],st.getCoursecode(result[7]),result[8],result[9],result[10],result[11]});
		 model.addRow(new Object[] {result[12],st.getCoursecode(result[12]),result[13],result[14],result[15],result[16]});
		 model.addRow(new Object[] {result[17],st.getCoursecode(result[17]),result[18],result[19],result[20],result[21]});
		 model.addRow(new Object[] {result[22],st.getCoursecode(result[22]),result[23],result[24],result[25],result[26]});
		 model.addRow(new Object[] {"average","-","-","-",result[27],result[1]});
		
		
		
		JTable table =new JTable(model);
		resultPanel.add(table);
		JScrollPane pane =new JScrollPane(table);
		pane.setBounds(20,250,450,120);
		
		
		JLabel label5 =new JLabel("80-100 : A : EXCALLENT");
		label5.setBounds(20,380,200,20);
		label5.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,13));
		panel5.add(label5);
		
		JLabel label10 =new JLabel("70-80 : A : VERY GOOD");
		label10.setBounds(20,400,200,20);
		label10.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,13));
		panel5.add(label10);
		
		JLabel label6 =new JLabel("60-70 : B : GOOD");
		label6.setBounds(200,380,200,20);
		label6.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,13));
		panel5.add(label6);
		
		
		JLabel label7 =new JLabel("50-60 : C : AVERAGE");
		label7.setBounds(200,400,200,20);
		label7.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,13));
		panel5.add(label7);
		
		JLabel label8 =new JLabel("40-50 : D : PASS");
		label8.setBounds(380,380,200,20);
		label8.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,13));
		panel5.add(label8);
		
		JLabel label9 =new JLabel("0-40 : F : FAIL");
		label9.setBounds(380,400,200,20);
		label9.setFont(new Font("Arial",Font.ITALIC+Font.BOLD,13));
		panel5.add(label9);
		
		
		
		panel5.add(pane);
		panel5.repaint();
		
	}	public void availableBooks() {
		panel5.removeAll();
		panel5.repaint();
		
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
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
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		panel5.removeAll();
		panel5.repaint();
		String book[]=lib.getbookdetails(title);
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
		
//		JTextField reserve =new JTextField("0");
//		reserve.setEditable(false);
//		reserve.setEditable(false);
//		reserve.setBounds(100,355,150,25);
//		panel5.add(reserve);
		
		////System.out.println(book[5]);
		UserController us =new UserController();
		int  rm =(int)Math.random()*1000;
		String path =us.resizeEmage(book[5], 250, 250, "imae"+rm);
		ImageIcon bookimage1 =new  ImageIcon(path);
		JLabel bookimage =new JLabel(bookimage1);
		bookimage.setBounds(250, 25, 250, 250);
		panel5.add(bookimage);
		
		bookController bk =new bookController();
		String name =bk.CheckBook(title,reg_number);
		JLabel req =new JLabel(name);
		req.setBounds(260,300,200,25);
		req.setBorder(BorderFactory.createRaisedBevelBorder());
		req.setBackground(Color.cyan);
		req.setOpaque(true);
		req.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(req.getText().equals("RESERVE")) {
				bk.borre(title, "unchecked","not borrow", reg_number,"assign");
				}else if(req.getText().equals("BORROW")) {
					bk.borre(title, "unchecked",reg_number,"not reserve","assign");
				}
				getBookdetails(title);
			}
		});
		panel5.add(req);
	}
	JPanel pane1 =new JPanel();
	JScrollPane  scroll1 =new JScrollPane(pane1);
	//AdminController dm =new AdminController();
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
			    String[] response = st.Search(srch.getText());
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
			        scroll1.setBounds(160, 55, 230, x);
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
				getBookdetails(srch.getText());
				srch.setText("");
				
			}
			
		});
		holder.add(button);
		
		panel3.repaint();
		   
		}
		
	
	
}



