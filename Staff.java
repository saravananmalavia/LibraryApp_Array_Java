package con.lms.dto;

import java.io.Serializable;//markable interface

public class Staff extends Person implements Serializable{
	
	
	private int noOfIssued;
	private int noOfReceived;
	private int remuneration;


	public Staff(int staffId, String staffName, String staffEmail,String staffMobile ){
		super(staffId,staffName,staffEmail,staffMobile)	;


			

	}


	public int getNoOfIssued(){
		return noOfIssued;
	}
	public void setNoOfIssued(int noOfIssued ){
		this.noOfIssued =noOfIssued;
	}
	public int getNoOfReceived(){
		return noOfReceived;
	}
	public void setNoOfReceived(int noOfReceived){
		this.noOfReceived = noOfReceived;
	}
	public int  getRemuneration (){
		return  remuneration;
	}
	public void setRemuneration(){
		this.remuneration =remuneration;
	}

	public String toString(){
		String outPut = null;
		outPut = "\n Staff Id " + getPersonId()  + "\n Staff Name :- " + getPersonName() + "\n Staff email :- " + getPersonEmail() + "\n Staff mobile :- " + getPersonMobile();// + "Book issued by Staff :- " + (getBookIssuedBy()).getPersonName() ;
		return outPut;
	}
	


}