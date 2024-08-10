package con.lms.app;

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
					 new Book(6,"Thinking, Fast and Slow","Kahneman","STEM")
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
							{			new Staff (1,"Raj","8000000011","raj@library.org"),
										new Staff (2,"Kumar","8000000011","kumar@library.org"),
										new Staff (3,"bob","8000000011","bob@library.org"),
										new Staff (4,"Tom","8000000011","tom@library.org"),
										new Staff (5,"Hal","8000000011","hal@library.org")

							};


	public static Book searchByBookName(String bookName){

		Book searchedBook = null;

		for(Book book : books){
			if(bookName.equalsIgnoreCase(book.getBookName())){
				searchedBook = book;
				break;
			}

		}
		return searchedBook;
	}

	public static Book searchByBookAuthor(String authorName){

		Book searchedBook = null;

		for(Book book : books){
			if(authorName.equalsIgnoreCase(book.getBookAuthor())){
				searchedBook = book;
				break;
			}

		}
		return searchedBook;
	}

	public static Book searchByBookCategory(String category){

		Book searchedBook = null;

		for(Book book : books){
			if(category.equalsIgnoreCase(book.getBookCategory())){
				searchedBook = book;
				break;
			}

		}
		return searchedBook;
	}

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





}					

	
