package con.lms.dto;

import java.io.Serializable;//markable interface

public class Book implements Serializable{


	private int bookId;
	private String bookName;
	private String bookAuthor;
	private String bookCategory;
	private Member bookIssuedTo;
	private Staff bookIssuedBy;
	private Staff bookReceivedBy;






	public Book(){

	}

	public Book(int bookId,String bookName,String bookAuthor,String bookCategory){
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookCategory = bookCategory;
		

	}

	public int getBookId(){
		return bookId;
	}

	public String getBookName(){
		return bookName;
	}
	public String getBookAuthor(){
		return bookAuthor;
	}
	public String getBookCategory(){
		return bookCategory;
	}
	public Member getBookIssuedTo(){
		return bookIssuedTo;
	}
	public void setBookIssuedTo(Member bookIssuedTo ){
		this.bookIssuedTo = bookIssuedTo;	
	}
 
	public Staff getBookIssuedBy(){
		return bookIssuedBy;
	}
	public void setBookIssuedBy(Staff bookIssuedBy){
		this.bookIssuedBy = bookIssuedBy;	
	}
	public Staff getBookReceivedBy (){
		return bookReceivedBy;
	}
	public void setBookReceivedBy(Staff bookReceivedBy){
		this.bookReceivedBy = bookReceivedBy;	
	}




	public String toString(){
		String output = null;

		String issuedTo = (getBookIssuedTo() != null ) ? (getBookIssuedTo()).getPersonName() : "Not Issued";
		String issuedBy = (getBookIssuedBy() != null ) ? (getBookIssuedBy()).getPersonName() : "Not Issued";
		String receivedBy = (getBookReceivedBy() != null ) ? (getBookReceivedBy()).getPersonName() : "Not Received";



		output =   "\n Book Author " + bookAuthor ;
		output +=  "\n Book Name :- " + bookName ;
		output +=  "\n Book Id :- " + bookId ;
		output +=  "\n Book bookCategory :- " + bookCategory ;
		output +=  "\n Book issued To : " + issuedTo;
		output +=  "\n Book issued by : " + issuedBy;
		output +=  "\n Book Received by : " + receivedBy;
		  
		return output;
	}
	
}