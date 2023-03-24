package controller;

import model.Books;
import model.Course;
import model.LecPrograms;
import model.Lecturer;
import model.Programmes;
import model.Score;
import model.StudentModel;

public class LectureControll {
	private Lecturer lc=new Lecturer();
	public LectureControll() {
	}
	
	public String[][] lectureDetails() {
		return lc.get_Lecturer_details();
	}
	public String[] addLecture(String[] ddata) {
		Lecturer lc =new Lecturer();
		int j = lc.getNumberOflectures() +1;
		String enter[] = new String [11];
		int i=0;
		String ret[]= new String[2];
		String copy[]=ddata;
		for(String k : copy) {
			if(i==5) {
				if(i==5) {
					enter[i]=ddata[6];
					ret[1]=ddata[6];
					i++;
					enter[i]="lec/"+j+"/21";
					ret[0]="lec/"+j+"/21";
					i++;
					enter[i]=k;
					i++;
					
				}
			}else if(i>=7) {
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
		lc.addLecturer(enter);
		LecPrograms lp =new LecPrograms();
		lp.assignLectures(new String[] {enter[6],"null","null","null"});
		return ret ;
		
	}
	public void removelec(String Lec_number) {
		LecPrograms lp =new LecPrograms();
		Lec_number = Lec_number.toLowerCase();
		Lecturer lc =new Lecturer();
		lc.rmlecturer(Lec_number);	
		lp.removelecture(Lec_number);
	}
	public String[] loginDetails(String name) {
		String details[][] =lectureDetails();
		for(String name1[]:details) {
			if(name1[5].equals(name)) {
				return name1;
			}
		}
		
		
		return null;
		
	}
	public void assignLecture_Course(String lec_assign[]) {
		LecPrograms lp =new LecPrograms();
		String enter []=new String[4];
		enter[0]=lec_assign[0];
				enter[1]=lec_assign[1];
				enter[2]=lec_assign[2];
				enter[3]=lec_assign[3];
		
		lp.removelecture(lec_assign[0]);
		lp.assignLectures(enter);
	}
	public String [] []desplayLectureCourses() {
		LecPrograms lp =new LecPrograms();
		
		return lp.getLec_Courses();
		
	}

	public String[] checkCourseDetails(String lec_name) {
		LecPrograms lec =new LecPrograms();
		String Lec_course []=lec.getCourses(lec_name);
		//System.out.println(Lec_course[1] + " check");
		return Lec_course;
	}
	public String[][] getStudent_courses(String course) {
		 Programmes pro =new Programmes();
		 String Program[] =pro.getProgram(course);
		 String[][] getDetails = pro.getPrograms();
		 String save[][] =new String[50][5];
		 int x=0;
		 int y=0;
		 for(String[] programmess :getDetails) {
			 for(String programlist:Program) {
				 if(programmess[0].equals(programlist)) {
					 StudentModel St =new StudentModel();
					 String[][] geteachStudentDetails =St.getStudentsWithProgram(programmess[0]);
					 for(int w=0;w<geteachStudentDetails.length;w++) {
						
							 if(geteachStudentDetails[w][0]!=null) {
								 
								 save[x][y]=geteachStudentDetails[w][0];
								 y++;
								 save[x][y]=geteachStudentDetails[w][1];
								 y++;
								 Score sc =new Score();
								 String student_score[] =sc.studentScore(geteachStudentDetails[w][1]);
								 for(int j=0 ; j<student_score.length;j++) {
									 if(student_score[j]!=null) {
										 if(course.equals(student_score[j])) {
											 save[x][y]=student_score[j];
											 y++;
											 save[x][y]=student_score[j+1];
											 y++;
											 save[x][y]=student_score[j+2];
											 y++;
											// //System.out.println(geteachStudentDetails[w][0]);
											 break;
										 }
									 }
								 } 	
								 y=0;
								 x++;
							 }
					 }
				 }
				// for(String []name: save) {
				//	 //System.out.println(name[0]);
				// }
			 }
		 }
		 
		return save;
		
	}
	public void setCatScore(String name,String course,String Score) {
		Score sc =new Score();
		//System.out.println(name);
		//System.out.println(course);
		//System.out.println(Integer.parseInt(Score));
		sc.setCatScore(name, course,Integer.parseInt(Score));
	}
	public void setExamScore(String name,String course,String Score) {
		Score sc =new Score();
		sc.setExamScore(name, course,Integer.parseInt(Score));
	}

	public String[] getMyinformation(String lec_number) {
		Lecturer lc = new Lecturer();
		String lcs [][] =lc.get_Lecturer_details();
		for(String lecture[]:lcs ) {
			if(lecture[5].equals(lec_number)) {
					String update[]=lecture;
					return update;
				}	
		}
		return null;
	}
	public String getCoursecode(String title) {
		Course cs =new Course();
		String coursedetails[]=cs.getcourseDetails(title);
		return coursedetails[1];
	}
 	public String SearchReturn(String value) {
 		Books books =new Books();
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
		return null;
 		
 	}

	public String[] Search(String value) {
		int j=0;
		Books books =new Books();
		StudentModel std =new StudentModel();
		Course course =new Course();
		int lenght =books.searchBook(value).length + std.search_student(value).length+course.searchCourse(value).length;
		String response [] =new String[lenght];
		for(String i: books.searchBook(value))
		{
			if(i!=null) {
			response[j]=i;
			j++;
			}
		}
		for(String i: std.search_student(value))
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
		return response;
	}
}
