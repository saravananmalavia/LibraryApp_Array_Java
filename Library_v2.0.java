package con.lms.app;


import java.util.ArrayList;

import con.lms.dto.Book;
import con.lms.util.Helper;
import con.lms.dto.Member;
import con.lms.dto.Staff;


public class Library{

	public static Book books[] = 
				  { new Book(1,"java","James","Programming"),
					new Book(2,"html","Tim","Programming"),
					new Book(3,"css","Hakon","Programming"),
					new Book(4,"javascript","Brendan","Programming"),
					new Book(5,"Spring","Rod","Programming"),
					new Book(6,"Thinking, Fast and Slow","Kahneman","STEM"),
					new Book(105,"react","Jordan","Programming"),
					new Book(106,"A Brief History of Time","Stephen ","STEM"),
					new Book(107,"Sapiens","Yuval ","STEM"),
					new Book(108,"Why We Sleep","Matthew ","STEM"),
					};

	public static Member members[] =
							{ 	new Member(1001,"Hans","hans@hans.org","9100000011",5),
							   	new Member (1002,"Feynman","feynman@feynman.org","9100000012",5),
								new Member (1003,"Teller","teller@teller.org" ,"9100000013",5),
								new Member (1004,"Ernest","Ernest@Ernest.org" ,"9100000014",5),
								new Member (1005,"john","john@john.org" ,"9100000015",5),
								new Member (1006,"niels","niels@niels.org","9100000016",5),
								new Member (1007,"Szilard","Szilard@Szilard.org" ,"9100000017",5),
								new Member (1008,"Oppie","oppie@oppie.org" ,"9100000018",5),
								new Member (1009,"Otto","otto@otto.org" ,"9100000019",5)

								};

	public static Staff staffs[] = 
							{			new Staff (1,"Raj","raj@library.org","8000000011"),
										new Staff (2,"Kumar","kumar@library.org","8000000012"),
										new Staff (3,"bob","bob@library.org","8000000013"),
										new Staff (4,"Tom","tom@library.org","8000000014"),
										new Staff (5,"Hal","hal@library.org","8000000015")

							};




	public static Book searchBook(String value,String inputType){

		Book searchedBook = null;

		try{
				for(Book book : books){
					if(inputType.equals("category")){ 
						if(value.equalsIgnoreCase(book.getBookCategory())){
							searchedBook = book;
							break;
						}
					}else if(inputType.equals("authorName")){
							if(value.equalsIgnoreCase(book.getBookAuthor())){
								searchedBook = book;
								break;
							}
					}else if(inputType.equals("bookName")){
							if(value.equalsIgnoreCase(book.getBookName())){
								searchedBook = book;
								break;
							}
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





}					

	
