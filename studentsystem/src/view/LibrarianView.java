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
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.AdminController;
import controller.StudentController;
import controller.UserController;
import controller.bookController;
import controller.librarianController;

public class LibrarianView{
	private JFrame frame= new JFrame();
	private JPanel panel1;
	private JPanel panel2 =new JPanel();
	private JPanel panel3 =new JPanel();
	private JPanel panel5 =new JPanel();
	private String first_name="";
	private String second_name ="";
	private JPanel holder =new JPanel();
	private String last_name ="";
	private String image ="";
	private String id;
	private String email="";
	private String gender ="";
	private String date_of_birth="";
	private String lib_number ="";
	
	librarianController lib =new librarianController();
	public LibrarianView(String libnumber) {
		String myinfo []=lib.getmyInformation(libnumber);
		lib_number =libnumber;
		first_name =myinfo[0];
		second_name =myinfo[1];
		last_name =myinfo[2];
		image =myinfo[8];	
		email =myinfo[6];
		date_of_birth =myinfo[3];
		gender =myinfo[4];
		id =myinfo[7];
		
		
		
		
		
		
		frame.setBounds(100,50,1000,600);
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setTitle("welcome Approad");
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
				 myinformation();
			}
			
			
		});
		
		JLabel entermarks =new JLabel("     RESERVED/BORROWED ");
		entermarks.setBounds(25,85,200,40);
		entermarks.setForeground(Color.BLUE);
		entermarks.setBackground(Color.cyan);
		entermarks.setOpaque(true);
		entermarks.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		entermarks.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		entermarks.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				returnbook();
			}
			
			
		});
		entermarks.setLayout(new FlowLayout());
		
		JLabel report =new JLabel("     BOOKS AVAILABLE ");
		report.setBounds(25,150,200,40);
		report.setForeground(Color.BLUE);
		report.setBackground(Color.cyan);
		report.setOpaque(true);
		report.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		report.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		report.setLayout(new FlowLayout());
		report.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				availableBooks();
			}
			
			
		});
		
		
		
		
		JLabel library =new JLabel("            ADDBOOK ");
		library.setBounds(25,215,200,40);
		library.setForeground(Color.BLUE);
		library.setBackground(Color.cyan);
		library.setOpaque(true);
		library.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,14));
		library.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		library.setLayout(new FlowLayout());
		library.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				addbooktoLibrary();
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
		
		
		JLabel title =new JLabel("WELCOME");
		title.setBounds(25,280,200,40);
		title.setBackground(Color.blue);
		title.setOpaque(true);
		title.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,30));
		
		AdminController ac =new AdminController();
		String location =ac.Imageresize(image, 80, 80,first_name);
		ImageIcon image =new ImageIcon(location);
		JLabel label =new JLabel(image);
		label.setBounds(20,20,80,80);
		frame.setIconImage(image.getImage());
		panel1.add(label);
		
		JLabel label1 =new JLabel(first_name+"    "+last_name);
		label1.setBounds(130,20,500,50);
		label1.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,25));
		panel1.add(label1);
		
		JLabel label2 =new JLabel("LIBRARIAN ");
		label2.setBounds(130,60,500,50);
		label2.setFont(new Font("Arial",Font.BOLD+Font.ITALIC,30));
		
		panel5.setBounds(20,70,510,440);
		panel5.setLayout(null);
		panel5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		UserController uc =new UserController();
		location =uc.resizeEmage("photos\\library.jpeg", 510, 440, first_name);
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
		panel3.add(panel5);
		frame.add(panel3);
		frame.setVisible(true);
		frame.add(panel1);
	}
	public void myinformation() {
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		panel5.removeAll();
		panel5.repaint();
		UserController us =new UserController();
		String MyimageLocation = us.resizeEmage(image, 150, 150, second_name+last_name);
		ImageIcon myImage =new ImageIcon( MyimageLocation);
		JLabel myin =new JLabel(myImage);
		myin.setBounds(20,20,150,150);
		panel5.add(myin);
		
		JLabel first1 = new JLabel("First name :");
		first1.setBounds(20,200,150,30);
		panel5.add(first1);
		
		JLabel first2 = new JLabel(first_name);
		first2.setBounds(100,200,150,30);
		panel5.add(first2);
		
		JLabel sec1 = new JLabel("second  name :");
		sec1.setBounds(20,250,150,30);
		panel5.add(sec1);
		
		JLabel sec2 = new JLabel(second_name);
		sec2.setBounds(120,250,150,30);
		panel5.add(sec2);
		
		JLabel third1 = new JLabel("Last name :");
		third1.setBounds(20,300,150,30);
		panel5.add(third1);
		
		JLabel third2 = new JLabel(last_name);
		third2.setBounds(120,300,150,30);
		panel5.add(third2);
		
		JLabel date1 = new JLabel("Date of birth:");
		date1.setBounds(20,350,150,30);
		panel5.add(date1);
		
		JLabel date2 = new JLabel(date_of_birth);
		date2.setBounds(120,350,150,30);
		panel5.add(date2);
		
		JLabel type = new JLabel("LIBRARIAN");
		type.setBounds(250,50,300,50);
		type.setForeground(Color.red);
		type.setFont(new Font("arial",Font.BOLD+Font.ITALIC,25));
		panel5.add(type);
		
		
		JLabel id1 = new JLabel("ID :");
		id1.setBounds(250,100,150,30);
		panel5.add(id1);
		
		JLabel id2 = new JLabel(id);
		id2.setBounds(300,100,150,30);
		panel5.add(id2);
		
		JLabel gender1 = new JLabel("gender :");
		gender1.setBounds(250,150,150,30);
		panel5.add(gender1);
		
		JLabel gender2 = new JLabel(gender);
		gender2.setBounds(300,150,150,30);
		panel5.add(gender2);
		
		JLabel work1 = new JLabel("lib number :");
		work1.setBounds(250,250,150,30);
		panel5.add(work1);
		
		JLabel work2 = new JLabel(lib_number);
		work2.setBounds(350,250,150,30);
		panel5.add(work2);
		
		JLabel email1 = new JLabel("email:");
		email1.setBounds(250,200,150,30);
		panel5.add(email1);
		
		JLabel email2 = new JLabel(email);
		email2.setBounds(300,200,150,30);
		panel5.add(email2);
	}
	public void availableBooks() {
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
	JScrollPane scroll1 =new JScrollPane();
	bookController bk = new bookController();
	String mypiclocation="";
	String pvname="";
	public void addbooktoLibrary() {
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
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
			
			UserController us =new UserController();
			mypiclocation ="";
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
						
						File myprofile =mybook.getSelectedFile();
						mypiclocation =myprofile.getAbsolutePath().replace("\\", "/");
						int  rm =(int)Math.random()*1000;
						String path =us.resizeEmage(myprofile.getAbsolutePath().replace("\\", "/"), 80, 100, "image"+rm);
						ImageIcon bookimage1 =new  ImageIcon(path);
						JLabel bookimage =new JLabel(bookimage1);
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
						//System.out.println(rm);
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
	
	public void getBookdetails(String title) {
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		panel5.removeAll();
		panel5.repaint();
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
		
	}
	public void returnbook() {
		panel3.remove(holder);
		panel5.setBounds(20,70,510,440);
		panel3.repaint();
		panel5.removeAll();
		panel5.repaint();
		JPanel panel1 =new JPanel();
		panel1.setBounds(0,0,520,70);
		
		JLabel label2 =new JLabel("Image");
		label2.setVisible(true);

		JLabel label3 =new JLabel("books pedding and borrowed");
		label3.setBounds(30,20,250,30);
		panel1.add(label3);
		
		JPanel panel2 =new JPanel();
		
		bookController book =new bookController();
		String returnbook [][]= book.librariancheck();
		for(String lists[]:returnbook) {
			UserController uc =new UserController();
			String location =uc.resizeEmage(lists[0], 40, 40, lists[1]);
			ImageIcon image2 =new ImageIcon(location);
			JLabel Limage =new JLabel(image2);
			panel2.add(Limage);
			
			JLabel title =new JLabel(lists[1]);
			panel2.add(title);
			JLabel title1 =new JLabel(lists[2]);
			panel2.add(title1);
			JLabel title2 =new JLabel(lists[4]);
			panel2.add(title2);
			JLabel title3 =new JLabel(lists[3]);
			panel2.add(title3);
			JLabel title4 =new JLabel(lists[5]);
			panel2.add(title4);
			JLabel title5 =new JLabel("Return");
			panel2.add(title5);
		}
		
		
		
		panel2.setLayout(new GridLayout(0,7,2,2));
		
		JScrollPane pane =new JScrollPane(panel2);
		panel2.setBackground(Color.green);
		
		panel2.setBounds(20,50,480,300);
		pane.setBounds(20,50,480,300);
	
		JLabel available =new JLabel("enter st/lc number");
		available.setBounds(20,360,150,25);
		panel5.add(available);
		
		
		JTextField available1 =new JTextField();
		available1.setBounds(130,360,150,25);
		panel5.add(available1);
		
		
		
		JLabel available2 =new JLabel("number");
		available2.setBounds(300,360,150,25);
		panel5.add(available2);
		
		
		JTextField available3 =new JTextField();
		available3.setBounds(350,360,150,25);
		panel5.add(available3);
		
		
		JButton available4 =new JButton("submit");
		available4.setBounds(300,400,150,25);
		available4.setFocusable(false);
		panel5.add(available4);
		available4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(available1.getText().isEmpty()||available3.getText().isEmpty()) {
					available4.setText("fill all spaces");
				}else {
				book.confirm(available1.getText().toLowerCase(),available3.getText().toLowerCase());
				returnbook();
				}
			}
			
		});
		
		JButton available5 =new JButton("return");
		available5.setBounds(100,400,150,25);
		available5.setFocusable(false);
		available5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				book.returnbook( available1.getText().toLowerCase());
				returnbook();
			}
			
		});
		panel5.add(available5);
		
		
		
		panel5.add(pane);
		panel5.add(panel1);
		panel5.repaint();
	}
	JPanel pane1 =new JPanel();
	JScrollPane  scroll11 =new JScrollPane(pane1);
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
			    scroll11.setVisible(true);
			    int x = 20;
			    String[] response = lib.Search(srch.getText());
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
			        scroll11.repaint();
			        pane1.add(newButton);
			        scroll11.setBounds(160,55, 230, x);
			        holder.add(scroll11);
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
				
				String availableIn =lib.SearchReturn(srch.getText());
				if(availableIn.equals("book")) {
					getBookdetails(srch.getText());
					srch.setText("");
				}else if(availableIn.equals("student")){
					stdmyinformation(srch.getText());
					srch.setText("");
				}
				
				
			}
			
		});
		holder.add(button);
		
		panel3.repaint();
		   
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
