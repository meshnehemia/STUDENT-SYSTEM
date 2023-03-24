package controller;

import model.Course;

public class courseController {

	public courseController() {
		
	}
	public String [][] getdetails() {
		Course cs =new Course();
		String details[][] =cs.getCourses();
		return details;
		
	}
	
	public void removecourse(String text) {
		ProgrammController dm =new ProgrammController();
		Course cs = new Course();
		cs.removecourse(text);
		for(String pro []:dm.getProgramsDetail()) {
			dm.changeCourse(pro[0], text, null);
		}
		
	}
	public void addCourse(String title, String code) {
		Course cs = new Course();
		cs.addcourse(new String []{title,code,"0","0"});
	}
	public String[][] getCourse() {
		Course cs = new Course();
		return cs.getCourses();
		
	}
	public String getstudentsNumber(String name) {
		Course cs =new Course();
		String detai []= cs.getcourseDetails(name);
		return detai[2];
	}
}
