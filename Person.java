package con.lms.dto;

import java.io.Serializable;//markable interface


public class Person implements Serializable{
	
	private int personId;
	private String personName;
	private String  personMobile;
	private String personEmail;

	public Person(int personId,String personName,String personEmail,String  personMobile){
		this.personId =personId;
		this.personName = personName;
		this.personEmail = personEmail;
		this.personMobile = personMobile;
		
	}

	public int getPersonId(){
		return personId;
	}
	public String getPersonName(){
		return personName;
	}
	public String getPersonMobile(){
		return  personMobile;
	}
	public String getPersonEmail(){
		return personEmail;
	}

}