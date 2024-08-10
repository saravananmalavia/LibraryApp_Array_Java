package con.lms.app;

import  con.lms.dto.Book;
import  con.lms.dto.Member;
import  con.lms.dto.Staff;

import con.lms.util.Helper;


public class LibraryAppliation{

	 static Book book[] = {
		new Book(101,"java","James ","Programming","bookIssuedTo","bookIssuedBy","bookReceivedBy")
		new Book(102,"html","Tim","Programming","available"," not issued by anyone","not issued till now"),
		new Book(103,"css","Hakon","Programming","available"," not issued by anyone","not issued till now"),
		new Book(104,"javascript","Brendan","Programming","available"," not issued by anyone","not issued till now"),
		new Book(104,"Spring","Rod","Programming","available"," not issued by anyone","not issued till now"),
		new Book(105,"react","Jordan","Programming","available"," not issued by anyone","not issued till now"),
		new Book(106,"A Brief History of Time","Stephen ","STEM","available","not issued by anyone","not issued till now"),
		new Book(107,"Sapiens","Yuval ","STEM","available","not issued by anyone ","not issued till now"),
		new Book(108,"Why We Sleep","Matthew ","STEM","available","not issued by anyone","not issued till now"),
		new Book(109,"Thinking, Fast and Slow","Kahneman","STEM","available","not issued by anyone","not issued till now"),
		new Book(110,"The Sixth Extinction","Elizabeth ","STEM","available"," not issued by anyone","not issued till now"),
		new Book(111,"Surely You're Joking, Mr. Feynman!","Feynman","STEM","available"," not issued by anyone","not issued till now")


	};

	/*static  Staff staffs[] ={ 
		new Staff (1,"Raj",210011,"raj@library.org"),
		new Staff (2,"Kumar",210012,"kumar@library.org"),
		new Staff (3,"bob",210013,"bob@library.org"),
		new Staff (4,"Tom",210014,"tom@library.org"),
		new Staff (5,"Hal",210015,"hal@library.org")

	};*/

	/*static Member members [] = {
		new Member (1001,"Hans","hans@hans.org",110011),
		new Member (1002,"Feynman","feynman@feynman.org",110012),
		new Member (1003,"Teller","teller@teller.org" ,110013),
		new Member (1004,"Ernest","Ernest@Ernest.org" ,110014),
		new Member (1005,"john","john@john.org" ,110015),
		new Member (1006,"niels","niels@niels.org",110016),
		new Member (1007,"Szilard","Szilard@Szilard.org" ,110017),
		new Member (1008,"Oppie","oppie@oppie.org" ,110018),
		new Member (1009,"Otto","otto@otto.org" ,110019)	,

	};*/

	public static void main(String args[]){

		Scanner sc = new Scanner(System.in);

		String inputAuthorName,inputBookName,inputBookCategory,memberSearchName,staffSearchQueryString,borrowerBookquery;
		int staffSearchQueryId;

		while(true){

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("1.  Display All Book details");
				System.out.println("2.  Search Book by Author");
				System.out.println("3.  Search Book by Book Name");
				System.out.println("4.  Search Book by Category");
				System.out.println("5.  List Book by Borrower");
				System.out.println("6.  List Book issued by Staff id");
				System.out.println("7.  List all Members");
				System.out.println("8.  List all Staff");
				System.out.println("9.  Search member by name/email/mobile");
				System.out.println("10. Search Staff by name / email / mobile");
				System.out.println("11. Prepare Staff payslip");
				System.out.println("12. issue book");
				System.out.println("13. return book");
				System.out.println("14. exit Menu");
				//System.out.println("");
				System.out.println("Choose from option 1 to 14");

				int option = Helper.getIBetween(1,14);

				

				switch (option) {


					case 1 :
						System.out.println("Option choosen to display all book details: - ");
						displayAllBookDetails();

					//	System.out.println("");

						break;
					
					case 2 :

						System.out.println("Enter the Author name to search:- ");
						 inputAuthorName = Helper.getS();
						
						Book searchedAuthor = getBookDetails(inputAuthorName);
					

						if(searchedAuthor == null){
							System.out.println("Sorry The Author " + inputAuthorName + " is not available in the library");

						}else{
							System.out.println(searchedAuthor);
						}


						break;
					
					case 3 :

						System.out.println("Enter the Book name you would like  to search:- ");
						 inputBookName = Helper.getS();
						
						Book searchedBookName = getSearchedBookName(inputBookName);
					

						if(searchedBookName == null){
							System.out.println("Sorry The Book " + inputBookName + " is not available in the library");

						}else{
							System.out.println(searchedBookName);
						}
						break;
					
					case 4 :

						 System.out.println("Enter the Book Category name to search:- ");
						 inputBookCategory = Helper.getS();
						
						Book [] searchedCategory = getBookCategory(inputBookCategory);
					

						if(searchedCategory == null){
							System.out.println("Sorry The Book " + inputBookCategory + " is not available in the library");

						}else{
							for(Book x:searchedCategory){
								System.out.println(x);
								/*
								System.out.println("Book Name " + x.getBookName());
								System.out.println("Book id " + x.getBookId());
								System.out.println("Book Author Name  " + x.getBookAuthor());
								System.out.println("Book Status " + x.getBookStatus());
								*/
							}
						}
						
						break;
					
					case 5 :
						break;
					
					case 6 :
						break;
					
					case 7 :
						System.out.println("List of All current Members");
						System.out.println("\n");
						displayAllMember();

						break;
					
					case 8 :
						System.out.println("List of All current staff");
						System.out.println("\n");
						displayAllStaff();
						break;
					
					case 9 :
								System.out.println("Enter the Member name/email/id/mobile");
								System.out.println("Enter the option 1 to enter member id ");
								System.out.println("Enter the option 2 to enter name/email");
								System.out.println("Enter the option 3 to enter mobile number");
								int service = Helper.getIBetween(1,3);
								switch (service){

								case 1 :
										System.out.println("Enter the Member id ");
										int  memberSearchQueryId = Helper.getI();
										Book searcheMemberData = getMemeberData(memberSearchQueryId);

										if(searcheMemberData == null){
										System.out.println("Sorry The Member " + memberSearchQueryId + " is not registered in the library");

										}else{
											System.out.println(searcheMemberData.getMemberName());
										}
										break;


								case 2 :
										System.out.println("Enter the name or email");
										String memberSearchQueryString = Helper.getS();
										searcheMemberData = getMemeberData(memberSearchQueryString);


										if(searcheMemberData == null){
										System.out.println("Sorry The Member " + memberSearchQueryString + " is not registered in the library");

										}else{
											System.out.println(searcheMemberData.getMemberName());
										}
										break;

										

								case 3 :
										System.out.println("Enter the  mobile number");
										//Scanner sc = new Scanner(System.in);
										int  memberSearchQueryMobile = Helper.getI();
										searcheMemberData = getMemeberMobile(memberSearchQueryMobile);

										if(searcheMemberData == null){
										System.out.println("Sorry The Member " + memberSearchQueryMobile + " is not registered in the library");

										}else{
											System.out.println(searcheMemberData.getMemberName());
										}
										break;
								
								

								default :
									break;
								}

						break;
							
					case 10 :
								System.out.println("Enter the Member name/email/id/mobile");
								System.out.println("Enter the option 1 to enter member id/mobile ");
								System.out.println("Enter the option 2 to enter name/email");
								
								int service1 = Helper.getIBetween(1,2);
								switch (service1){

										case 1 :
												System.out.println("Enter the Staff id / mobile number ");
												staffSearchQueryId = Helper.getI();
												Book searchedStaffData = getStaffData(staffSearchQueryId);

												if(searchedStaffData == null){
												System.out.println("Sorry The Member " + staffSearchQueryId + " is not working in the library");

												}else{
													System.out.println(searchedStaffData.getStaffName() + "is a Staff of the library");
												}
												break;

												
										case 2 :
												System.out.println("Enter the name or emailid of Staff");
												staffSearchQueryString = Helper.getS();
												searchedStaffData = getStaffData(staffSearchQueryString);


												if(searchedStaffData == null){
												System.out.println("Sorry The Staff " + staffSearchQueryString + " is not working in the library");

												}else{
													System.out.println(searchedStaffData.getStaffName() + " is a Staff of the library");
												}
												break;
										default :
											break;
								}
										
						break;
					
					case 11 :
						break;
					
					case 12 :
						System.out.println("Enter the name of the book you would like to borrow");
						//

						//Book availableBook =
					//	issueBook();

					//	System.out.println("Enter the Member id ");
										issueBookquery = Helper.getS();
										Book searchedBookData = getbookData(issueBookquery);

										if(searchedBookData == null){
										System.out.println("Sorry The Book " + issueBookquery + " is not available in the library");

										}else{
											System.out.println("Enter the Borrower Name : ");
											String issuedName = Helper.getS();
											//check if member

											System.out.println("Enter the Staff Name : ");
											String issuedName = Helper.getS();
											//check if staff

											searchedBookData.setBookIssuedTo(issuedName);
											searchedBookData.setBookStatus("Not available");

										}
										break; 

						break;

					case 13 :
						break;
					
					case 14 :

						System.exit(0);
						break;

				}
	
		}


	}

	public static void displayAllBookDetails(){
		
		for(int i=0;i< book.length;i++){

		System.out.println("Book id :" + book[i].getBookId() );
		System.out.println("Book Name : " + book[i].getBookName());
		System.out.println("Book Author : " + book[i].getBookAuthor() +  "  Book Category: " + book[i].getBookCategory());		
		System.out.println("Book issued Status : " + book[i].getBookStatus()); 
		System.out.println("Book issuing  staff : " +  book[i].getBookIssuedByStaff());
		System.out.println("Book returned status : " + book[i].getBookReturnedBy());
		System.out.println("\n*************************");
		}

	}

	public static void displayAllMember(){

		try{
				for(int i=0;i< book.length;i++){
				System.out.println("Member id :" + member[i].getMemberId() );
				System.out.println("Member Name : " + member[i].getMemberName());
				System.out.println("Member email : " + member[i].getMemberEmail());		
				System.out.println("Member Mobile : " + member[i].getMemberMobile()); 
				System.out.println("\n*************************");
				}
		}
		catch(Exception e){
		System.out.println(e);

		}

	}

	public static void displayAllStaff(){


		try{
				for(int i=0;i< book.length;i++){

				System.out.println("Staff id :" + staff[i].getStaffId() );
				System.out.println("Staff Name : " + staff[i].getStaffName());
				System.out.println("Staff email : " + staff[i].getStaffEmail());		
				System.out.println("Staff Mobile : " + staff[i].getStaffMobile()); 
				System.out.println("\n*************************");
				}
		}
		catch(Exception e){
			System.out.println(e);
		}

	}

	/*public static String searchByAuthor(String inputAuthorName){
		book authorData = null;


		try{
				for (int i=0;i < book.length;i++){

					if(inputAuthorName.equalsIgnoreCase(book[i].getBookAuthor())){
						//String s2 = book[i].getBookAuthor() + " ";
						//String s1 = " Author found  : -";
						 //authorName = s1.concat(s2);

						authorData = book[i].getBookAuthor();

						break;
					}
					else{
						 authorData ="Author not found";
					}
				}
		}
		catch(Exception e){
			System.out.println(e);
		}

		return authorName;
	}*/



	public static Book getBookDetails(String inputAuthorName){
		
		Book availableAuthor = null;

		for(Book books : book){
			if((books.getBookAuthor()).equalsIgnoreCase(inputAuthorName)){
				availableAuthor = books;
				break;
			}
		}

		return availableAuthor;
	}

	public static Book getSearchedBookName(String inputBookName){
		
		Book availableBookName = null;

		for(Book books : book){
			if((books.getBookName()).equalsIgnoreCase(inputBookName)){
				availableBookName = books;
				break;
			}
		}

		return availableBookName;
	}

	public static Book[] getBookCategory(String inputBookCategory){
		
		
		int count =0;
		for(Book x : book){
			if((x.getBookCategory()).equalsIgnoreCase(inputBookCategory)){
				
				count ++;
				//availableBookCategory [] = books;

				//break;
			}
		}

		Book availableBookCategory []  = new Book [count];
		int index =0;
		for(Book x : book){
			if((x.getBookCategory()).equalsIgnoreCase(inputBookCategory)){
				
				
				availableBookCategory [index] = x;
				index++;
			}
		}

		return availableBookCategory ;
	}



	public static Book getMemeberData(String memberDetails){
		
		Book availablememberdetails1 = null;

		for(Book x : member){
			if((x.getMemberName()).equalsIgnoreCase(memberDetails) || (x.getMemberEmail()).equalsIgnoreCase(memberDetails)){
				availablememberdetails1 = x;
				break;
			}
		}

		return availablememberdetails1;
	}

	public static Book getMemeberData(int memberDetails){
		
		Book availablememberdetails = null;

		for(Book x : member){
			if((x.getMemberId()) == (memberDetails)) {
				availablememberdetails = x;
				break;
			}
		}

		return availablememberdetails;
	}

	public static Book getMemeberMobile(int memberDetails){
		
		Book availablememberdetails = null;

		for(Book x : member){
			if( (x.getMemberMobile()) == (memberDetails)){
				availablememberdetails = x;
				break;
			}
		}

		return availablememberdetails;
	}

	public static Book getStaffData(int staffDetails){
		
		Book availableStaffdetails = null;

		for(Book x : staff){
			if((x.getStaffId()) == (staffDetails) || (x.getStaffMobile()) == (staffDetails)){
				availableStaffdetails = x;
				break;
			}
		}

		return availableStaffdetails;
	}

	public static Book getStaffData(String staffDetails){
		
		Book availableStaffdetails = null;

		for(Book x : staff){
			if((x.getStaffName()).equalsIgnoreCase(staffDetails) || (x.getStaffEmail()).equalsIgnoreCase(staffDetails)){
				availableStaffdetails = x;
				break;
			}
		}

		return availableStaffdetails;
	}

	public static Book getbookData(String issueBookquery ){

			Book availableBookdetails = null;

		for(Book x : book){
			if((x.getBookName()).equalsIgnoreCase(issueBookquery) || (x.getBookStatus()).equalsIgnoreCase("available")){
				availableBookdetails = x;
				break;
			}
		}

		return availableBookdetails;
	}

	/*public static Member getMemeberData(String issuedTo){
	//	Memeber 
	}*/
	


	
}