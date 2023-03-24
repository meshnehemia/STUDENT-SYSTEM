package controller;

import model.Books;
import model.Course;
import model.Programmes;
import model.Score;
import model.StudentModel;

public class StudentController {
	public StudentController() {
		
	}
	
	public String[][] studentDetails() {
		StudentModel md =new StudentModel();
		return md.get_student_details();
	}
	public String [] mydetails(String name) {
		String [][] studentDetails =studentDetails();
		for(String eachStudent[]:studentDetails) {
			if(eachStudent[5].equals(name)) {
				String me[]=eachStudent;
				return me;
				
			}
		}
		return null;
	}
	public String[] addstudent(String newstd[]) {
		StudentModel md =new StudentModel();
		ProgrammController alld = new ProgrammController();
		String progd[][]=alld.getProgramsDetail();
		String code="";
		String name="";
		for(String sort[] :progd) {
			if(sort[0].equals(newstd[7])) {
				name=sort[0];
				code =sort[1];
			}
		}
		
		int j = md.getNumberOfstudents() +1;
		String enter[] = new String [12];
		int i=0;
		String ret[]= new String[2];
		Programmes pr =new Programmes();
		pr.addStudent(name);
		Course cs =new Course();
		String prcourses [] = pr.getCourses(name);
		for(String courses : prcourses) {
			if(courses.equals(prcourses[0])||courses.equals(prcourses[6])) {
				continue;
			}else {
				cs.addStudents(courses);
			}
		}
		String copy[]=newstd;
		String reg_number ="";
		for(String k : copy) {
			if(i==5) {
				if(i==5) {
					code=code.toLowerCase();
					enter[i]=newstd[6];
					ret[1]=newstd[6];
					i++;
					reg_number=code+"/"+j+"/21";
					enter[i]=code+"/"+j+"/21";
					ret[0]=code+"/"+j+"/21";
					i++;
					enter[i]=k;
					i++;
					
				}
			}else if(i>=9) {
				enter[i]=k;
				i++;
			}
			else {
				k =k.toLowerCase();
				enter[i]=k;
				i++;
			}
			
		}
		enter[i]=""+j;
		
		Score sc =new Score();
		Programmes programe =new Programmes();
		String programdetails []=programe.getCourses(name);
		String scoredetails[]= {reg_number,programdetails[1],programdetails [2],programdetails [3],programdetails [4],programdetails [5]};
		
		sc.addStudent(scoredetails);
		md.addStudent(enter);
		return ret ;
		
	}
	public void removeStudent(String string) {
		string = string.toLowerCase();
		Course cs =new Course();
		Programmes pr =new Programmes();
		StudentModel st =new StudentModel();
		String student [][]=st.get_student_details();
		for(String pro []:student) {
			if(pro[5].equals(string)) {
				String prcourses [] = pr.getCourses(pro[8]);
				for(String courses : prcourses) {
					if(courses.equals(prcourses[0])||courses.equals(prcourses[6])) {
						//System.out.println(courses);
					}else {
						cs.removeStudents(courses);
					}
				}
			}
		}
		
		StudentModel md= new StudentModel();
		String alldetail[][]=md.get_student_details();
		for(String student1[]:alldetail) {
			if(student1[5].equals(string)) {
				pr.removestudents(student1[8]);
			}
		}
		md.rmstudent(string);
		Score sc =new Score();
		sc.removeStudent(string);
	}
	public String []getResult(String reg_number){
  		Score sc =new Score();
  		return sc.studentScore(reg_number);
  	}
	public String getCoursecode(String course_name) {
		Course cu =new Course();
		return  cu.getcoursecode(course_name);
	}
	public String[] Search(String value) {
		int j=0;
		Books books =new Books();
		int lenght =books.searchBook(value).length;
		String response [] =new String[lenght];
		for(String i: books.searchBook(value))
		{
			if(i!=null) {
			response[j]=i;
			j++;
			}
		}
		return response;
	}
}
