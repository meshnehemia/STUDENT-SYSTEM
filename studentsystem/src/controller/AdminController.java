package controller;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import model.AdminModel;
import model.Books;
import model.Course;
import model.Lecturer;
import model.Score;
import model.StudentModel;

public class AdminController {
	public AdminController(){
		
	}
	public String Imageresize(String location, int width ,int height,String name) {
		
		
			try {
			        // Load the original image
			    	BufferedImage originalImage = ImageIO.read(new File(location));
			        // Create a new image with the specified size
			        BufferedImage resizedImage = new BufferedImage(width, height, originalImage.getType());
			
			        // Resize the original image to the new size
			        Graphics2D g = resizedImage.createGraphics();
			      //  g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
			        g.drawImage(originalImage, 0, 0, width, height, null);
			        g.dispose();
			
			        // Draw the resized image in a circle
			        BufferedImage circleImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
			        g = circleImage.createGraphics();
			       // g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			        g.setClip(new Ellipse2D.Float(0, 0, width, height));
			        g.drawImage(resizedImage, 0, 0, null);
			        g.dispose();
			
			        // Save the circle image to
					ImageIO.write(circleImage, "png", new File(name+".png"));
			}catch(Exception e) {
				e.printStackTrace();
			}
        
        return name+".png";
		
		
	}
	public String [] getinfor(String username) {
		AdminModel md =new AdminModel();
		username = username.toLowerCase();
		String detail[] =md.getDetails(username);
		String give[] =new String[3];
		give[0]= detail[0];
		give[1]= detail[2];
		give[2]= detail[10];
		
		return give;
		
		
	}
	
	public String SearchReturn(String value) {
 		Books books =new Books();
 		Lecturer lec =new Lecturer();
		StudentModel std =new StudentModel();
		Course course =new Course();
		for(String i: books.searchBook(value))
		{
			if(i!=null)
			if(i.equals(value)) {
				return "book";
			}
		}
		for(String i: std.search_student(value))
		{
			if(i!=null)
			if(i.equals(value)) {
				return "student";
			}
		}
		for(String i:  course.searchCourse(value))
		{
			if(i!=null)
			if(i.equals(value)) {
				return "course";
			}
		}
		for(String i:lec.search_lecturer(value))
		{
			if(i!=null)
				if(i.equals(value)) {
					return "lecturer";
				}
		}
		return null;
 	}
	public String[] Search(String value) {
		int j=0;
		Books books =new Books();
		Course course = new Course();
		Lecturer lec =new Lecturer();
		StudentModel std =new StudentModel();
	
		int lenght =books.searchBook(value).length +
				course.searchCourse(value).length +
				lec.search_lecturer(value).length+std.search_student(value).length;
		String response [] =new String[lenght];
		for(String i: books.searchBook(value))
		{
			if(i!=null) {
			response[j]=i;
			j++;
			}
		}
		for(String i: course.searchCourse(value))
		{
			if(i!=null) {
			response[j]=i;
			j++;
			}
		}
		for(String i:lec.search_lecturer(value))
		{
			if(i!=null) {
			response[j]=i;
			j++;
			}
		}
		for(String i:std.search_student(value))
		{
			if(i!=null) {
			response[j]=i;
			j++;
			}
		}
		return response;
		
	}
	public String[] getMyinformation(String username) {
		AdminModel md =new AdminModel();
		username = username.toLowerCase();
		String detail[] =md.getDetails(username);
		
		return detail;
		
	}
	public String[] addAdmin(String newadmin[]) {
		AdminModel md =new AdminModel();
		int j = md.getNumberOfAdmin() +1;
		String enter[] = new String [13];
		int i=0;
		String ret[]= new String[2];
		String copy[]=newadmin;
		for(String k : copy) {
			if(i==5) {
				if(i==5) {
					enter[i]="admin/"+j+"/21";
					ret[0]="admin/"+j+"/21";
					i++;
					enter[i]=newadmin[7];
					ret[1]=newadmin[7];
					i++;
					enter[i]="admin/"+j+"/21";
					i++;
					enter[i]=k;
					i++;
				}
			}else {
				k =k.toLowerCase();
				enter[i]=k;
				i++;
			}
			
		}
		enter[i]=""+j;
		md.addAdmin(enter);
		return ret ;
		
	}
	public String [][] adminList() {
		AdminModel md =new AdminModel();
		return   md.checkAdminList();
		
	}
	public void removeAdmin(String work) {
		AdminModel md =new AdminModel();
		work =work.toLowerCase();
		md.removeAdmin(work);
	}
	public void validateScores() {
		Score sc = new Score();
		String studentScores[][][]=sc.getScore();
		float average=0;
		for(String eachStudent[][]:studentScores) {
			average=0;
			String student_name=eachStudent[0][0];
			for(int j =1;j<6;j++) {
				String course= eachStudent[j][0];
				int cat=Integer.parseInt(eachStudent[j][1]);
				int exam =Integer.parseInt(eachStudent[j][2]);
				int avScore =Integer.parseInt(eachStudent[j][3]);
				avScore =cat+exam;
				average +=avScore;
				if(j==5) {
					char grade;
					int avgt = Math.round(average/5);
					sc.setGeneralAvaragescores(student_name, avgt);
					if(avgt>=70&&avgt<101)
					{
						grade='A';
					}
					else if(avgt>=60&&avgt<70)
					{
						grade='B';
					}
					else if(avgt>=50&&avgt<60)
					{
						grade='C';
					}
					
					else if(avgt>=40&&avgt<50)
					{
						grade='D';	
					}
					
					else if(avgt<40&&avgt>0)
						
					{
						grade='F';		
					}
					else
					{
						grade='*';
					}
					sc.setGeneralAvarage(student_name, grade);
				}
				char avgrade;
				
				if(exam==0&&cat==0) {
					avScore=0;
					avgrade='*';
				}
				else {
					if(avScore>=70&&avScore<101)
					{
						avgrade='A';
					}
					else if(avScore>=60&&avScore<70)
					{
						avgrade='B';
					}
					else if(avScore>=50&&avScore<60)
					{
						avgrade='C';
					}
					
					else if(avScore>=40&&avScore<50)
					{
						avgrade='D';	
					}
					
					else if(avScore<40)
					{
						avgrade='F';		
					}
					else
					{
						avgrade='*';
					}
				}
				sc.setAvaragePerUnity(student_name, course, avScore);
				sc.setUnityGrade(student_name, course, avgrade);
			}
		}	
	}
}
