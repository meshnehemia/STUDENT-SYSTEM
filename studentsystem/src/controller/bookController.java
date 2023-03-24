package controller;

import model.Books;
import model.BorrowBook;

public class bookController {

	public bookController() {
		
	}
	public String[][] getbooksList(){
		Books bk =new Books();
		String list [][] =bk.getBooks();
		return list;
	}
	public void updateBook(String pvname, String update[]) {
		Books bk =new Books();
		bk.setTitle(pvname.toLowerCase(),update[0].toLowerCase() );
		bk.setversion(update[1].toLowerCase(),pvname.toLowerCase());
		bk.setEdition(update[2].toLowerCase(),pvname.toLowerCase());
		bk.setISNN(update[3].toLowerCase(),pvname.toLowerCase());
		bk.setNumberOfBooks(0, pvname);
		bk.setImage(update[5], pvname);
		bk.setPublisher(update[6].toLowerCase(), pvname.toLowerCase());
		
	}
	public void addbook(String mybook []) {
		Books bk =new Books();
		bk.addbook(mybook);
		
	}
	public void removebook(String title) {
		Books bk =new Books();
		bk.removebook(title);
	}
	
	public String CheckBook(String title,String name) {
		Books book =new Books();
		BorrowBook borrowed =new BorrowBook();
		String list [][]=borrowed.get_book_details();
		for(String check[]:list) {
			if(check[2].equals(name)) {
				if(check[1].equals("unchecked")) {
					return "pending";
				}
				return "you have borrowed the book";
			}else if(check[3].equals(name)) {
				return "book reserved";
			}
		}
		String getbooks [][]=book.getBooks();
		for(String mybook[]: getbooks) {
			if(mybook[0].equals(title)) {
				if(Integer.parseInt(mybook[6])>0){
					return "BORROW";
				}else {
					return 	"RESERVE";
				}
			}
		}
			
		return null;
			
			
		}	
		public void borre(String reg ,String status ,String borrow ,String reserve ,String booknumber) {
			Books bk =new Books();
			bk.borrowBook(reg);
		BorrowBook borrowed =new BorrowBook();
		borrowed.addbook(new String[] {reg,status,borrow,reserve,booknumber});
	}
	public String [][]librariancheck() {
		Books book =new Books();
		BorrowBook borrowed =new BorrowBook();
		String list [][]=borrowed.get_book_details();
		String Blist[][] =book.getBooks();
		String mylist[][]=new String[list.length][6];
		int i=0;
		for(String borrowed1[]: list) {
			for(String booklist[]:Blist) {
				if(borrowed1[0].equals(booklist[0])) {
					mylist[i][0]=booklist[5];
					mylist[i][1]=booklist[0];
					mylist[i][2]=borrowed1[1];
					mylist[i][3]=borrowed1[2];
					mylist[i][4]=borrowed1[3];
					mylist[i][5]=borrowed1[4];
					
				}
			}
			i++;
		}
		return mylist;	
	}
	public void returnbook(String name) {
		Books book =new Books();
		
		BorrowBook borrowed =new BorrowBook();
		String boo[][] =borrowed.get_book_details();
		for(String bk[]:boo) {
			if(bk[2].equals(name)||bk[3].equals(name)) {
				String names =bk[0];
				book.returnBook(names);
				borrowed.returnbook(name);
			}
			
		}
		
		
	}
	public void confirm(String name ,String booknumber) {
		BorrowBook borrowed =new BorrowBook();
		borrowed.confirm(name);
		borrowed.confirmbooknumber(booknumber,name);
	}
	
	
}
