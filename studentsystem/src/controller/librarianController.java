package controller;

import model.Books;
import model.Librarian;
import model.StudentModel;

public class librarianController {
     	public librarianController() {
     		
     	}
     	public String[] addLibrarian(String []addLibrarian) {
     		Librarian lib = new Librarian();
     		int number  = lib.numberofLibrarian()+1;
     		String Libadd = "lib/"+number+"/21";
     		String response[] =new String[2];
     		String[] arrange = new String[11];
     		int i =0;
     		for(String order : addLibrarian) {
     			if(i==5) {
     				arrange[i]=addLibrarian[6];
     				response[0]=arrange[i];
     				i++;
     				arrange[i]=Libadd;
     				response[1]=arrange[i];
     				i++;
     				arrange[i]=order;
     				i++;
     				
     				
     			}else {
     				arrange[i]=order;
     				i++;
     			}
     		}
     		arrange[10]=number+"";
     		lib.addlibrarian(arrange);
     		return response;
     		
     	}
     	public void removelibrarian(String lib_number) {
     		lib_number =lib_number.toLowerCase();
     		Librarian lib =new Librarian();
     		lib.rmlibrarian(lib_number);
     	}
     	public String[][] listOfLibrarian() {
     		Librarian lib =new Librarian();
     		String list [][] =lib.get_librarian_details();
     		return list;
     	}
     	public String [] getmyInformation(String info) {
     		String mylist[][]=listOfLibrarian();
     		for(String list[]: mylist) {
     			if(list[5].equals(info)) {
     				return list;
     			}
     		}
     		return null;
     	}
     	
     	
     	public String[] getbookdetails(String details) {
     		Books bk =new Books();
     		String ret [] =new String[8];
     		String book[][] = bk.getBooks();
     		for(String mybook[]: book) {
     			if(mybook[0].equals(details)) {
     				for(int i =0;i<8;i++) {
     				ret[i]=mybook[i];}
     			}
     		}
     		
     		return ret;
     	}
     	public String[] Search(String value) {
    		int j=0;
    		Books books =new Books();
    		StudentModel std =new StudentModel();
    		int lenght =books.searchBook(value).length + std.search_student(value).length;
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
			return response;
     	}
     	public String SearchReturn(String value) {
     		Books books =new Books();
    		StudentModel std =new StudentModel();
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
			return null;
     		
     	}
	
}
