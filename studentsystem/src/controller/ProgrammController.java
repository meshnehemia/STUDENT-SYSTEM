package controller;

import model.Programmes;

public class ProgrammController {
	public ProgrammController() {
		
	}
	public String[][] getProgramsDetail(){
		Programmes pg =new Programmes();
		return pg.getPrograms();
	}
	public void addtodata(String[] add) {


		Programmes pr =new Programmes();
		pr.addPrograms(add);
		
	}
	public void rmoveprogram(String text) {
		Programmes pr =new Programmes();
		pr.removeProgram(text);
		
	}
	public void changeCourse(String programName,String previousCourse ,String newCourse) {
		Programmes pr =new Programmes();
		pr.changeCourse(programName, previousCourse, newCourse);
	}
	public void updateProgram(String name[]) {
		Programmes dm =new Programmes();
		String details[][]= getProgramsDetail();
		for(String detai[] : details) {
			if(detai[1].equals(name[6])) {
				String code =detai[1];
				String students=detai[7];
				dm.removeProgram(detai[0]);
				String update[] =new String[8];
				update[0]=name[0];
				update[1]=name[1];
				update[2]=name[2];
				update[3]=name[3];
				update[4]=name[4];
				update[5]=name[5];
				update[6]=code;
				update[7]=students;
				dm.addPrograms(update);
			}
		}
	}
}
