package con.lms.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.*;
import java.util.*;
public class FileHelper{

	private static String dataFile;
	private static String transactionDataFile;

	static{
		dataFile = "library.data";
		transactionDataFile = "transaction.txt";
	}

	public static void setDataFileName(String file){
		dataFile = file;
	}

	public static void setTransactionDataFile(String file){
		transactionDataFile = file;
	}


	public static Hashtable readData(){

		 FileInputStream inputFIS = null;
		 ObjectInputStream outputOIS = null;

		 Hashtable htLibrary = null;
		 try {
		 	 inputFIS = new FileInputStream(dataFile);
			 outputOIS = new ObjectInputStream(inputFIS);

			 htLibrary = (Hashtable) outputOIS.readObject();
			 inputFIS.close();
			 outputOIS.close();

			}
			catch(Exception e) {
				//e.printStackTrace();
				//System.out.println("IMSHelper.readData()");
				System.out.println(e);
			}

		 return htLibrary;
	}
	public static boolean writeData(Hashtable htLibrary){

		FileOutputStream outputFOS = null;
		ObjectOutputStream outputOOS = null;
		boolean result = false;

		try{
			outputFOS = new FileOutputStream(dataFile);
			outputOOS = new ObjectOutputStream(outputFOS);
			outputOOS.writeObject(htLibrary);
			
			outputFOS.close();
			outputOOS.close();
			result = true;
		}
		catch(Exception e) {
			//e.printStackTrace();
			//result = true;
			System.out.println(e);
		}

		return result;
	}


	public static void updateTransaction(String transactionData) {  
        try {  
            // Create a BufferedWriter object with FileWriter to append to the file  
            BufferedWriter writer = new BufferedWriter(new FileWriter(transactionDataFile, true));  
              
            // Write the string to the file and add a new line character  
            writer.write(transactionData);  
            writer.newLine();  
              
            // Close the writer  
            writer.close();  
        }  
        catch (IOException e) {  
            // Catch any exceptions that occur and print the error message  
            System.out.println("Exception occurred: " + e);  
        }  
    }
}