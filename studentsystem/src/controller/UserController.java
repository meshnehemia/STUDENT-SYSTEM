package controller;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.AdminModel;
import model.Lecturer;
import model.Librarian;
import model.StudentModel;
import view.AdminView;
import view.LectureView;
import view.LibrarianView;
import view.StudentView;

public class UserController {
	public UserController(){
		
	}
	public String resizeEmage(String location,int width, int height,String name) {
		
		try {
	        BufferedImage image = ImageIO.read(new File(location));     
	        BufferedImage resizedImage = new BufferedImage(width, height, image.getType());
	        Graphics2D g = resizedImage.createGraphics();
	        g.drawImage(image, 0, 0,width, height, null);
	        g.dispose();
	        File output = new File(name+".png");
	        ImageIO.write(resizedImage, "png", output);
	        return output.getAbsolutePath();
	        
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		
		return null;
		
	}
	public String loginAsStudent(String reg_number,String password) {
		reg_number =reg_number.toLowerCase();
		StudentModel md =new StudentModel();
		String UserNames[] =md.getUserName();
		for(String i : UserNames) {
			//System.out.println(i);
			if(i.equals(reg_number)) {
			if(md.getPassword(reg_number).equals(password)) {
				//System.out.print("login sucessfully");
				return "sucessfull";
			}else {
				return "password";
				}
			}
		}
		return "username";
		
	}
	public String ChangePasswordForStudents(String username, String userId, String password) {
		StudentModel md =new StudentModel();
		username = username.toLowerCase();
		String details[][] =md.get_student_details();
		
		for(String detail[]:details) {
				if(detail[5].equals(username)) {
					if(detail[7].equals(userId)) {
						md.forgot_password(detail[5], password);
						return "successful";
					}else {
						return "id";
					}	
				}
			
			}
			return "username";
		}
	
	public String loginAslecture(String lec_number,String password) {
		lec_number =lec_number.toLowerCase();
		Lecturer md =new Lecturer();
		String UserNames[] =md.getUserName();
		for(String i : UserNames) {
			//System.out.println(i);
			if(i.equals(lec_number)) {
			if(md.getPassword(lec_number).equals(password)) {
				//System.out.print("login sucessfully");
				return "sucessfull";
			}else {
				return "password";
				}
			}
		}
		return "username";
		
	}
	public String ChangePasswordForlecture(String username, String userId, String password) {
		Lecturer md =new Lecturer();
		username = username.toLowerCase();
		String details[][] =md.get_Lecturer_details();
		for(String detail[]:details) {
			//System.out.println(detail[5]);
				if(detail[5].equals(username)) {
					
					if(detail[7].equals(userId)) {
						md.forgot_password(detail[5], password);
						return "successful";
					}else {
						return "id";
					}	
				}
			
			}
			return "username";
		}
	public String loginAsAdmin(String name,String password) {
		name =name.toLowerCase();
		AdminModel md =new AdminModel();
		String UserNames[] =md.getUserName();
		for(String i : UserNames) {
			if(i.equals(name)) {
			if(md.getPassword(name).equals(password)) {
				return "sucessfull";
			}else {
				return "password";
				}
			}
		}
		return "username";
		
	}
	
	public String loginAsLibrarian(String name,String password) {
		name =name.toLowerCase();
		Librarian md =new Librarian();
		String UserNames[] =md.getUserName();
		for(String i : UserNames) {
			if(i.equals(name)) {
			if(md.getPassword(name).equals(password)) {
				return "sucessfull";
			}else {
				return "password";
				}
			}
		}
		return "username";
		
	}
	
	
	
	
	public String ChangePasswordForAdmin(String username, String userId, String password) {
		AdminModel md =new AdminModel();
		username = username.toLowerCase();
		String detail[] =md.getDetails(username);
		if(detail[5]==null) {
			return "username";
		}
		else {
			//System.out.println(detail[5]);
			if(detail[5].equals(username)) {
				if(detail[9].equals(userId)) {
					md.setPassword(username, password);
					return "successful";
				}else {
					return "id";
				}
			}
		
		}
		return username;
	}
	public void transferToStudent(String reg_number) {
		reg_number=reg_number.toLowerCase();
		new StudentView(reg_number);
	}
	public void transferToLecturer(String lec_number) {
		lec_number=lec_number.toLowerCase();
		new LectureView(lec_number);
	}
	public void transferToAdmin(String workNumber) {
		workNumber=workNumber.toLowerCase();
		new AdminView(workNumber);
		
	}
	public void transferToLibrary(String workNumber) {
		workNumber=workNumber.toLowerCase();
		new LibrarianView(workNumber);
		
	}
	public String ChangePasswordForLibrarian(String username, String userId, String password) {
		Librarian md =new Librarian();
		username = username.toLowerCase();
		String details[][] =md.get_librarian_details();
		
		for(String detail[]:details) {
				if(detail[5].equals(username)) {
					if(detail[7].equals(userId)) {
						md.forgot_password(detail[5], password);
						return "successful";
					}else {
						return "id";
					}	
				}
			
			}
			return "username";
		}
	
	
}
