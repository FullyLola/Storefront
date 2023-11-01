package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 * This class holds utility methods to keep other classes organized
 * @author Elayne Medina
 *@version 1
 *August 21, 2022
 */
public class Utils {
/**
 * This method is used to make asking the user questions and 
 * evaluating their response simpler	
 * @param scnr - the user's response to the question
 * @param question - a question asking the user what action they'd like to perform (yes or no)
 * @return true if yes and false if no
 */
	public static boolean askUserBool(Scanner scnr, String question) {
		System.out.println(question + " [Y or N]?");
		  char response = scnr.next().toUpperCase().charAt(0);
		  if(response == 'Y'){
		    return true;
		  }
		  else{
		    return false;
		  }
	}
/**
 * This method is used to provide users with methods and accept a numerical response	
 * @param scnr - users response to the message
 * @param message - information guiding the user
 * @return an integer value or a new message if an exception is caught
 */
	public static int askUserInt(Scanner scnr, String message) {
		  System.out.println(message);
		  while(true){
		    try{
		      int a = scnr.nextInt();
		      return a;
		    }
		    catch (Exception e){
		      System.out.println("Please enter an integer");
		    }
		  }
		}
/**
 * This method reads from a file and turns it into a String	
 * @param fileName name of the file being input
 * @return a string of contents from the file
 */


}
