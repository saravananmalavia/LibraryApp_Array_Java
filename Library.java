package con.lms.app;


import java.util.ArrayList;
import java.util.Hashtable;
import con.lms.dto.Book;
import con.lms.util.Helper;
import con.lms.dto.Member;
import con.lms.dto.Staff;
import con.lms.util.FileHelper;
import con.lms.data.DataFactory;
import con.lms.log.FileLogger;
import con.lms.log.Logger;


public class Library{

	public static Book books [];
	public static Member members [];
	public static Staff staffs [];
	
		static {

					try{

						DataFactory.libraryData = FileHelper.readData();
						if(DataFactory.libraryData == null){
								DataFactory.libraryData = new Hashtable<String,Object>();
								DataFactory.libraryData.put("book", DataFactory.bookData);
								DataFactory.libraryData.put("member", DataFactory.memberData);
								DataFactory.libraryData.put("staff", DataFactory.staffData);

								FileHelper.writeData(DataFactory.libraryData);
						}

						if(DataFactory.libraryData != null){
							books = (Book []) DataFactory.libraryData.get("book");
							members = (Member []) DataFactory.libraryData.get("member");
							staffs = (Staff []) DataFactory.libraryData.get("staff");

						}

					}catch(Exception e){
						System.out.println("error : Library : static block : " + e);	
					}
					
				}


		public static void main(String args[]){
			int option,bookId,memberId,staffId;

			while(true){
					System.out.println("\n");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("1. Book : ");
					System.out.println("2. Member : ");
					System.out.println("3. Staff : ");
					System.out.println("4. exit Menu");
					//System.out.println("");
					System.out.println("Choose from option 1 to 4");

					 option = Helper.getIBetween(1,4);


						switch(option) {


							case 1 :

								int options;
								do{
											System.out.println("\n");
											System.out.println("1.  Display All Book details");
											System.out.println("2.  Search Book by Book Name");
											System.out.println("3.  Search Book by Author");
											System.out.println("4.  Search Book by Category");
											System.out.println("5.  List Books borrowed by Member");
											System.out.println("6.  List Book issued by Staff name");
											System.out.println("7.  Issue Book ");
											System.out.println("8.  Return Book ");
											System.out.println("9. exit Menu");

											 options = Helper.getIBetween(1,9);
											switch(options){
								 			
										 			case 1 :

										 				System.out.println("		BOOK DETAILS 		");
														System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


														Book books[] = (Book[])Library.getAllDetails("book");
														for(Book book: books){
															System.out.println(book);
														}



										 				break;
										 			case 2 :

										 				

										 				System.out.println("Enter the book name you wish to search : - ");
										 				String bookName1 = Helper.getS();
										 				Book checkBookName = Library.getBookDetails(bookName1);

														if(checkBookName == null){
															System.out.println("book not available");

														}else {
															System.out.println(checkBookName);
														}

										 				break;


										 			case 3 :



														

										 				System.out.println("Enter the Author name you wish to search : - ");
										 				String authorName = Helper.getS();
										 				

														System.out.println("Book details : ");
														ArrayList<Book> checkAuthorName = Library.searchBook(authorName,"author");

															if(checkAuthorName.size() > 0 ){
																for (Book book : checkAuthorName){
																	System.out.println(book);
																}
															}else{
																System.out.println("No books available with this Author name ");
															}

										 				break;

										 			case 4 :



										 				System.out.println("Enter the Category name you wish to search : - ");
										 				String bookCategory = Helper.getS();
										 				

														System.out.println("Book details : ");
														ArrayList<Book> checkBookCategory = Library.searchBook(bookCategory,"category");

															if(checkBookCategory.size() > 0 ){
																for (Book book : checkBookCategory){
																	System.out.println(book);
																}
															}else{
																System.out.println("No books available with this Category name ");
															}

										 				break;


										 			case 5 :



										 				System.out.println("Enter the member name you wish to search : - ");
										 				String bookMember = Helper.getS();
										 				

														
														ArrayList<Book> checkBookMember = Library.searchBook(bookMember,"member");

															if(checkBookMember.size() > 0 ){
																for (Book book : checkBookMember){
																	System.out.println(book);
																}
															}else{
																System.out.println("No books borrowed by this member  ");
															}

										 				break;

										 			case 6 :



										 				System.out.println("Enter the staff name you wish to search : - ");
										 				String staffName = Helper.getS();
										 				

														
														ArrayList<Book> checkBookStaff = Library.searchBook(staffName,"staff");

															if(checkBookStaff.size() > 0 ){
																for (Book book : checkBookStaff){
																	System.out.println(book);
																}
															}else{
																System.out.println("No books Issued by this staff id  ");
															}

										 				break;


										 			case 7 :
										 				System.out.println("Issue Book");
										 				System.out.println("enter the book id , member id, Staffid");
										 				 bookId = Helper.getI();
										 				 memberId = Helper.getI();
										 				 staffId = Helper.getI();
														
														String issuedBook = Library.issueBook(bookId,memberId,staffId);
														System.out.println(issuedBook);


														logTransaction(new FileLogger(), issuedBook);

										 				break;

										 			case 8 :

										 				System.out.println("Return Book");
										 				System.out.println("enter the book id , member id, Staffid for issuing book");
										 				 bookId = Helper.getI();
										 				 memberId = Helper.getI();
										 				 staffId = Helper.getI();
														
														String returnedBook = Library.returnBook(bookId,memberId,staffId);
														System.out.println(returnedBook);
														logTransaction(new FileLogger(), returnedBook);

										 				break;



								 				
										
											}


								}while(options != 9);
								 
								
								break;


							case 2 :

									do{
								
											System.out.println("1. List all Member ");
											System.out.println("2. Search member by name/email/mobile ");
											System.out.println("3. exit Menu");

											 options = Helper.getIBetween(1,3);
											switch(options){
								 			
								 			case 1 :


									 				System.out.println("		Member DETAILS 		");
													System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


													Member members[] = (Member[])Library.getAllDetails("member");
													for(Member member: members){
														System.out.println(member);

														System.out.println("\n");
													}

								 				break;

								 			case 2 :


													System.out.println("Enter the member details you wish to search : - ");
									 				String memberData = Helper.getS();
									 				

													
													ArrayList<Book> memberList = Library.searchBook(memberData,"member");

														if(memberList.size() > 0 ){
															for (Book book : memberList){
																System.out.println(book);
															}
														}else{
															System.out.println("No book Issued to this member  ");
														}

							 					break;

										
											}
									}while(options !=3);
								break;

								

							case 3 :

								do{
											System.out.println("1.  List all Staff : ");
											System.out.println("2.  Search Staff by name/email/mobile");
											
											System.out.println("3.  Payslip : ");
											System.out.println("4. exit Menu");

											 options = Helper.getIBetween(1,4);

											 switch(options){
											
												 case 1 :  

									 				System.out.println("		STAFF DETAILS 		");
													System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");


													Staff staffs[] = (Staff[])Library.getAllDetails("staff");
													for(Staff staff: staffs){
														System.out.println(staff);
													}

													System.out.println("\n");



									 				break;
												
												 case 2 :

														System.out.println("Enter the staff details you wish to search : - ");
										 				String staffData = Helper.getS();
										 				

														
														ArrayList<Book> checkStaffData = Library.searchBook(staffData,"staff");

															if(checkStaffData.size() > 0 ){
																for (Book book : checkStaffData){
																	System.out.println(book);
																}
															}else{
																System.out.println("No book Issued by this staff id  ");
															}

								 					break;
								 				}
									 				
											
									}while(options != 4);
									
								break;


							case 4 :
								closeLibrary();
								System.exit(0);
							break;

						}

					

			}

					
		}


					
			
				


	public static Book getBookDetails(int bookId){

		Book searchedBook = null;

		try{
			for(Book book : books){	 
				if(bookId == (book.getBookId())){
						searchedBook = book;
						break;
				}
			}

		}catch(Exception e){
			System.out.println("error : Library : searchBook" + e);
		}


		return searchedBook;

	}

	public static Member getMemberDetails(int memberId){

		Member memberObj = null;

		try{
			for(Member member : members){	 
				if(memberId == (member.getPersonId())){
						memberObj = member;
						break;
				}
			}

		}catch(Exception e){
			System.out.println("error : Library : getMemberDetails" + e);
		}


		return memberObj;

	}
	

	public static Staff getStaffDetails(int staffId){

		Staff staffObj = null;

		try{
			for(Staff staff : staffs){	 
				if(staffId == (staff.getPersonId())){
						staffObj = staff;
						break;
				}
			}

		}catch(Exception e){
			System.out.println("error : Library : getStaffDetails" + e);
		}


		return staffObj;

	}

	public static Book getBookDetails(String value){

		Book searchedBook = null;

		try{
			for(Book book : books){	 
				if(value.equalsIgnoreCase(book.getBookName())){
						searchedBook = book;
						break;
				}
			}

		}catch(Exception e){
			System.out.println("error : Library : searchBook" + e);
		}


		return searchedBook;

	}


	public static Member searchMember(String value,String inputType){

		Member searchedMember = null;

		try{
				for(Member member : members){
					if(inputType.equals("memberName")){
						if(value.equalsIgnoreCase(member.getPersonName())){
							searchedMember = member;
						}
						break;
					}else if(inputType.equals("memberEmail")){
							if(value.equalsIgnoreCase(member.getPersonEmail())){
								searchedMember = member;
								break;
							}
						}
						else if(inputType.equals("mobileNumber")){

								if(value.equalsIgnoreCase(member.getPersonMobile())){
									searchedMember = member;
									break;
								}
							}

				}


		}catch(Exception e){
			System.out.println("error : Library : searchMemeber" + e);

		}
		return searchedMember;

	}

		public static Staff searchStaff(String value,String inputType){

		Staff searchedStaff = null;

		try{
				for(Staff staff : staffs){
					if(inputType.equals("staffName")){
						if(value.equalsIgnoreCase(staff.getPersonName())){
							searchedStaff = staff;
						}
						break;
					}else if(inputType.equals("staffEmail")){
							if(value.equalsIgnoreCase(staff.getPersonEmail())){
								searchedStaff = staff;
								break;
							}
						}
						else if(inputType.equals("staffMobileNumber")){
								if(value.equalsIgnoreCase(staff.getPersonMobile())){
									searchedStaff = staff;
									break;
								}
							}

				}


		}catch(Exception e){
			System.out.println("error : Library : searchStaff" + e);

		}
		return searchedStaff;

	}


	public static Book[] getBooksByMember(String memberEmail){

		Book []searchedBooks = new Book[10];
		int i = 0;

		try{

			for(Book book : books){

				if(book.getBookIssuedTo() != null){
					if((book.getBookIssuedTo()).getPersonEmail().equalsIgnoreCase(memberEmail)){
						searchedBooks[i] = book;
						i++;
					}
				}
			}

		}catch(Exception e){
			System.out.println("error : Library : getBooksByMember : " + e);
		}

		return searchedBooks;
	}


	public static ArrayList<Book> getBooksByMember(String value, String inputType){

		ArrayList<Book> bookList = new ArrayList<Book>();
	
		try{

			for(Book book : books){
				if(inputType.equalsIgnoreCase("memberEmail")){
						if(book.getBookIssuedTo() != null){
							if((book.getBookIssuedTo()).getPersonEmail().equalsIgnoreCase(value)){
								bookList.add(book);
							}
						}
				}else if(inputType.equalsIgnoreCase("memberMobile")){
						if (book.getBookIssuedTo() != null){
							if((book.getBookIssuedTo()).getPersonMobile().equalsIgnoreCase(value)){
								bookList.add(book);
							}
						}
				}


			}

		}catch(Exception e){
			System.out.println("error : Library : getBooksByMember : " + e);
		}

		return bookList;
	}

	public static ArrayList<Book> getBooksByStaff(String value, String inputType){

		ArrayList<Book> bookList = new ArrayList<Book>();
	
		try{

			for(Book book : books){
				if(inputType.equals("staffEmail")){
						if(book.getBookIssuedBy() != null){
							if((book.getBookIssuedBy()).getPersonEmail().equalsIgnoreCase(value)){
								bookList.add(book);
							}
						}
				}else if(inputType.equalsIgnoreCase("staffMobile")){
						if (book.getBookIssuedBy() != null){
							if((book.getBookIssuedBy()).getPersonMobile().equalsIgnoreCase(value)){
								bookList.add(book);
							}
						}
				}


			}

		}catch(Exception e){
			System.out.println("error : Library : getBooksByStaff : " + e);
		}

		return bookList;
	}

	public static ArrayList<Book> getBookByCategory(String value){
		ArrayList<Book> bookList = new ArrayList<Book>();

	//	bookList = null;

		try{

			for(Book book : books){
				if(value.equalsIgnoreCase(book.getBookCategory())){
					bookList.add(book);
				}
				

				

			}

		}catch(Exception e){
			System.out.println("error : Library : getBookByCategory : " + e);
		}
		return bookList;
	}

	public static ArrayList<Book> searchBook(String inputValue , String inputType ){

		ArrayList <Book> bookList = new ArrayList <Book>();

			try{

				for(Book book : books){

					switch(inputType){
						case "category" :

								if(inputValue.equalsIgnoreCase(book.getBookCategory())){
									 bookList.add(book);
								}
							break;

						case "member" :

								//System.out.println("member " + inputValue + " " + inputType);

								if (book.getBookIssuedTo() != null){
							       if((inputValue.equalsIgnoreCase((book.getBookIssuedTo()).getPersonEmail())) ||
							       	  (inputValue.equalsIgnoreCase((book.getBookIssuedTo()).getPersonMobile())) ||
							       	  (inputValue.equalsIgnoreCase((book.getBookIssuedTo()).getPersonName()))){
							       			bookList.add(book);
							       }
								}
							break;

						case "author" :
								if(inputValue.equalsIgnoreCase(book.getBookAuthor())) {
									bookList.add(book);
								}
							break;

						case "staff" :

								if (book.getBookIssuedBy() != null){

							       if((inputValue.equalsIgnoreCase((book.getBookIssuedBy()).getPersonEmail())) ||
							       	  (inputValue.equalsIgnoreCase((book.getBookIssuedBy()).getPersonMobile())) || 
							       	  (inputValue.equalsIgnoreCase((book.getBookIssuedBy()).getPersonName())) ){
							       		bookList.add(book);
							       }
								}


							break;
					}

				}

			}catch(Exception e){
				System.out.println("Library : searchBook: " + e);
			}

			return bookList;
	}


	public static Object[] getAllDetails(String inputType){

		Object []data = null;

		try{

			switch(inputType){
				case "book" :
						data = Library.books;
					break;
				case "staff" :
						data = Library.staffs;
					break;
				case "member" :
						data = Library.members;
					break ;

			}

		}catch(Exception e){
			System.out.println("Library : getAllDetails: " + e);
		}

		return data;
	}


	public static String issueBook(int bookId, int memberId, int staffId){

			Book book = null;
			Staff staff = null;
			Member member = null;

			String message = "";

		try{

			book = getBookDetails(bookId);
			staff = getStaffDetails(staffId);
			member = getMemberDetails(memberId);

			if(book != null){

				if(book.getBookIssuedTo() == null){

					if(member != null){

						

						if(staff != null){

								if(member.getNoOfBooksBorrowed() < member.getMaxNoOfBooks()){
									book.setBookIssuedTo(member);
									book.setBookIssuedBy(staff);
									member.setNoOfBooksBorrowed(member.getNoOfBooksBorrowed() + 1);
									staff.setNoOfIssued(staff.getNoOfIssued()+1);

									message = "Book :" + book.getBookName()+ " is successfully issued to "  +  member.getPersonName();

								}else{
									message = "Maximum of books can be borrowed exceed for this member : " + memberId + " " + member.getPersonName();
								}
							

						}else{

							message = "No Staff available with this staffId : " + staffId + " " +  staff.getPersonName();

						}



					}else{
						message = "No members available with this memberId : " + memberId + " " + member.getPersonName();
					}
				}else{
					message = "Book : " + bookId + " "+ book.getBookName()  + " is already issued to " + memberId + " "+  member.getPersonName();
				}



			}else{
				message = "No books available with this bookId : "+ bookId + " " + book.getBookName();
			}

			



		}catch(Exception e){
			System.out.println("Library : getAllDetails: " + e);
		}



		return message;

	}


	public static String returnBook (int bookId,int memberId, int staffId){
		Book book = null;
		Member member = null;
		Staff staff = null;
		String message = " ";


		book = getBookDetails(bookId);
		member = getMemberDetails(memberId);
		staff = getStaffDetails(staffId);

		try{

			if(book != null){
				
				if(book.getBookIssuedTo() != null){
					

					if(member != null){
						if(staff != null){

							book.setBookIssuedTo(null);
							book.setBookIssuedBy(null);
							book.setBookIssuedBy(staff);
							member.setNoOfBooksBorrowed(member.getNoOfBooksBorrowed() - 1);
							staff.setNoOfReceived(staff.getNoOfReceived() + 1);

							message = ("The Book : " + book.getBookName() + " is returned by : " + member.getPersonName());

						}else {
							message = ("There is no Staff in records with this staff id " + staff.getPersonName());
						}

					}else {
						message = ("There is no member in records with this member id " + member.getPersonName());
					}
				
				}else{
					message = ("The book with book id " + book.getBookName() + " is not issued");
				}

			}else{
				message = ("The book is not in the records");
			}

		}catch(Exception e){
			message = (" Library : returnBook : " + e);
		}

		return message;

	}


	public static void closeLibrary(){


				Hashtable libraryClosingData = new Hashtable<String,Object>();

				try{


								libraryClosingData.put("book", books);
								libraryClosingData.put("member", members);
								libraryClosingData.put("staff", staffs);

								FileHelper.writeData(libraryClosingData);

								System.out.println("Library data updated successfully. Have a nice day ...");



				}catch(Exception e){
					System.out.println("Library : closeLibrary: " + e);
				}

			}

	public static int logTransaction(Logger logger, String transactionData){

				int result = 0;
				
				try{

					result = logger.logData(transactionData);

				}catch(Exception e){
					System.out.println("Library : logTransaction: " + e);
				}

		return result;

	}

}					

	
