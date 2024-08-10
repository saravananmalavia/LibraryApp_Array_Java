package con.lms.data;

import java.util.Hashtable;
import con.lms.dto.Book;
import con.lms.dto.Member;
import con.lms.dto.Staff;


public class DataFactory{

	public static Hashtable<String, Object> libraryData ;

	public static Book bookData[] = 
				  { new Book(1,"java","James","Programming"),
					new Book(2,"html","Tim","Programming"),
					new Book(3,"css","Hakon","Programming"),
					new Book(4,"javascript","Brendan","Programming"),
					new Book(5,"Spring","Rod","Programming"),
					new Book(6,"Thinking, Fast and Slow","Kahneman","STEM"),
					new Book(105,"react","Jordan","Programming"),
					new Book(106,"A Brief History of Time","Stephen","STEM"),
					new Book(107,"Sapiens","Yuval ","STEM"),
					new Book(108,"Why We Sleep","Matthew ","STEM"),
					new Book(109,"java Applications","James","Programming"),
					new Book(110,"weaving the web ","Tim","Programming"),
					new Book(111,"Black hole","Stephen","STEM"),

					};

	public static Member memberData[] =
							{ 	new Member(1001,"Hans","hans@hans.org","9100000011",3),
							   	new Member (1002,"Feynman","feynman@feynman.org","9100000012",3),
								new Member (1003,"Teller","teller@teller.org" ,"9100000013",5),
								new Member (1004,"Ernest","Ernest@Ernest.org" ,"9100000014",5),
								new Member (1005,"john","john@john.org" ,"9100000015",5),
								new Member (1006,"niels","niels@niels.org","9100000016",5),
								new Member (1007,"Szilard","Szilard@Szilard.org" ,"9100000017",5),
								new Member (1008,"Oppie","oppie@oppie.org" ,"9100000018",5),
								new Member (1009,"Otto","otto@otto.org" ,"9100000019",5)

								};

	public static Staff staffData[] = 
							{			new Staff (1,"Raj","raj@library.org","8000000011"),
										new Staff (2,"Kumar","kumar@library.org","8000000012"),
										new Staff (3,"bob","bob@library.org","8000000013"),
										new Staff (4,"Tom","tom@library.org","8000000014"),
										new Staff (5,"Hal","hal@library.org","8000000015")

							};


	


}