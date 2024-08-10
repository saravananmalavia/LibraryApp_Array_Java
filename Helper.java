package con.lms.util;

import java.util.Scanner;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;   

public class Helper{
	



	public static void main(String args[])	{

		
		Scanner sc = new Scanner(System.in);

	
	}


	public static int getIBetween(int a,int b){

			Scanner sc = new Scanner(System.in);
			//System.out.println("Enter the two numbers");
			int value = sc.nextInt();
			boolean flag = true;
			int num =0;
			while(flag){
				if(value >= a  && value <= b ){
				 	 num = value;
				 	flag =false;
				 	
				}else{
					System.out.println("wrong input, try again choose any of the below option between " + a + " to " + b);
					 num = 0;
					 break;
				}
			}
			return num;
			
		

	
	}
	public static String getS(){

			Scanner sc = new Scanner(System.in);
			//System.out.println("Enter the two numbers");
			String value = sc.nextLine();
			

			boolean flag = true;
			String num = null;
			
			try{
				while(flag){
				

					if(value.matches("[a-zA-Z\\s]+")){
					 	 num =  value;
					 	flag =false;
					 	break;
					 	
					}

					else{
						System.out.println("wrong input, numbers and symbols not allowed");
						 flag = false;
						 num = null;
						// break;

					}
				}
									
			}
			catch(Exception e){
						System.out.println(e);
						
					}	


			return num;
			
		

	
	}

	public static int getI(){
		Scanner sc =new Scanner(System.in);
		int value = 0;
		boolean isOK = true;

		do{
			try{
				value =sc.nextInt();
				isOK = false;
			}catch(Exception e){
				System.out.println("Wrong input, please eneter a valid integer");
				System.out.println(e.getMessage());
				sc.nextLine();
			}


		}while(isOK);

		return value;
	}


	public static String getCurretDateAndTime(){
		   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();  
		   String currentDateTime = (dtf.format(now)).toString();
		   return  currentDateTime;
     
	}

}