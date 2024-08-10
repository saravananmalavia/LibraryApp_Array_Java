package con.lms.dto;// data transaction object- package name 

import java.io.Serializable;//markable interface

public class Member extends Person  implements Serializable{
	
	private int maxNoOfBooks;
	private int noOfBooksBorrowed;



	public Member(int memberId,String memberName,String memberEmail ,String memberMobile,int maxNoOfBooks){
		super(memberId,memberName,memberEmail,memberMobile);// super must be very first statement and
		// super's order-invoke base class constructor
		this.maxNoOfBooks = maxNoOfBooks;
		//nooFBooks initialized to zero by default
		//this.personId = memberId
		
	}


	
	public int getMaxNoOfBooks(){
		return maxNoOfBooks;
	}
	public int getNoOfBooksBorrowed(){
		return noOfBooksBorrowed;
	}



	public void setMaxNooFBooks(int maxNoOfBooks){
		 this.maxNoOfBooks =maxNoOfBooks;
	}
	public void setNoOfBooksBorrowed(int noOfBooksBorrowed){
		this.noOfBooksBorrowed = noOfBooksBorrowed;
	}

	public String toString(){
		String outPut = null;
		outPut = "\n Member Id " + getPersonId()  + "\n Member Name :- " + getPersonName() + "\n Member email :- " + getPersonEmail() + "\n Member mobile :- " + getPersonMobile() + "\n Member maxNoOfBooks : " + getMaxNoOfBooks();
		return outPut;
	}



	

}