/**
 * Personal Profile Generator
 * This program generates a brief profile of a person by asking
 * several questions.
 * 
 * @author Conor Dunne (65950DUN)
 * @date 02/13/13
 */

// Import section
import java.util.*;

// The ProfileGen class
public class ProfileGen {

	// Main program
	public static void main(String[] args) {
		
		// Declare variables
		String strFName; // first name
		String strLName; // last name
		int birthYear; // year of birth
		String birthMonth; // month of birth
		int birthDay; // day of birth
		String gender; // gender of user
		String country; // country of residence
		String county; // county of residence
		String city; // city of residence
		String interest; // something that user likes 
		
		
		// Set up scanner
		Scanner sc = new Scanner(System.in);
		
		
		// Display title
		System.out.println("<<<< Welcome to the Personal Profile Generator! >>>>");
		System.out.println("====================================================");
		
		
		// Ask for name
		System.out.print("\nEnter your first name: ");
		strFName = sc.nextLine();
		System.out.print("Enter your last name: ");
		strLName = sc.nextLine();
		
		// Ask for year of birth
		System.out.print("\nEnter your year of birth: ");
		birthYear = sc.nextInt();
		
		// Bug with the above sc.nextInt - I don't really know how to fix it.
		birthMonth = sc.nextLine();
		// Problem solved...
		
		// Ask for month of birth
		System.out.print("Enter your month of birth: ");
		birthMonth = sc.nextLine();
		
		// Ask for day of birth
		System.out.print("Enter your day of birth: ");
		birthDay = sc.nextInt();
		
		// Bug with the above sc.nextInt - I don't really know how to fix it.
	    gender = sc.nextLine();
		// Problem solved...
		
		// Ask for Gender
		System.out.print("\nEnter your gender: ");
		gender = sc.nextLine();
		
		// Ask for country of residence
		System.out.print("\nEnter your current country of residence: ");
		country = sc.nextLine();
		
		// Ask for province/state/county of residence
		System.out.print("Enter your current province/state/county of residence: ");
		county = sc.nextLine();
		
		// Ask for city of residence
		System.out.print("Enter your current city/town of residence: ");
		city = sc.nextLine();
	
		// Ask user for area of interest
		System.out.print("\nEnter your area of interest: ");
		interest = sc.nextLine();
		
		// Start generating profile
		System.out.print("\nGenerating Profile");
		
		// Make loading interface with delay (Interrupted exception is handled)
		for (int i = 0; i < 10; i ++ ) {
			System.out.print(".");
			
			try {
				// Delay by 100 milliseconds.
				Thread.sleep(500);
			} // Close try  
			catch (InterruptedException ie){
				ie.printStackTrace();
			} // Close catch
		} // Close loading loop
		
		
		// Display name
		System.out.println("\n\nName                 : " + strLName + ", " + strFName);
		
		// Display Gender
		System.out.println("Gender               : " + gender);
		
		// Display date of birth
		System.out.println("Date of birth        : " + birthDay + " " + birthMonth + ", " + birthYear);
		
		// Display current location of residence
		System.out.println("Location of residence: " + city + ", " + county + ", " + country);
		
		// Display extra information
		System.out.println("\nNotes:");
		System.out.println(strFName + " is interested in " + interest + ".");
		
	} // Close main program
} // ProfileGen class
