/**
 * Average Calculator
 * This program simply calculates the average grade from using
 * percentages from each course that makes up the average.
 * This program is rather versatile; it offers no limit to
 * the number of courses that can be entered, and allows for a
 * choice between running again or stopping the program. 
 *
 * @author Conor Dunne (65950DUN)
 * @date 02/12/13
 */

// The AverageCalc class
import java.awt.*;

import hsa.Console;

public class AverageCalc {
	
	// The output console
	static Console c;
	
	public static void main(String[] args) {
		
		// Open console window
		c = new Console();
		
		// Declare variables
		char again;
		int courseNum;
		int mark;
		double totalMark;
		
		// Colour and formatting
		c.setTextBackgroundColor(Color.black);
		c.setTextColor(Color.green);
		c.clear();
		
		// Start program loop
		do {
		
			// Initialize variables
			totalMark = 0;
			
			// Clear console for when program runs again
			c.clear();
			
			// Display title
			c.println("Term Average Calculator");
			c.println("-----------------------");
			
			// Ask user for number of courses
			c.println();
			c.print("How many courses do you want to enter?: ");
			courseNum = c.readInt();
			
			// Ask user for marks
			for (int i = 1; i <= courseNum; i ++) {
				
				c.print("Enter your mark for course #" + (i) + ": ");
				
				// Error trap
				while (true) {
					mark = c.readInt();
					if (mark > -1 && mark < 101)break;
					c.print("Must be between 0 and 100: ");
				}
				totalMark = totalMark + mark;
			}
			
			// Calculate and display average
			c.println();
			c.print("Your average is ");
			c.print((totalMark / courseNum), 0, 1);
			c.print("%.\n");
			
			
			// Give user feedback depending on average mark
			// If mark is less than 50
			if (totalMark < (50 * courseNum)) {
				c.println("Well, there is the fast food industry...");
			}
			// If mark is between 50 and 79
			else if (totalMark >= (50 * courseNum) && totalMark < (80 * courseNum)) {
				c.println("I heard community college can be fun!");
			}
			// If mark is between 80 and 89
			else if (totalMark >= (80 * courseNum) && totalMark < (89 * courseNum)) {
				c.println("You're safe this time...");
			}
			// If mark is greater than 90
			else /*(totalMark >= (90 * courseNum)) */ {
				c.println("You can become a rocket surgeon! Well done!");
			} // end if
			
			
			// Ask user if they want to run again
			c.println();
			c.print("Do you want to try again? (y/n) ");
			
			// Error trap
			while (true) {
				again = c.getChar();
				if (again == 'Y' || again == 'y' || again == 'N' || again == 'n')break;
			} // end while
			
		} // end main loop
		
		// If user chooses 'y' then repeat
		while (again == 'y' || again == 'Y');
		
	} // main method
} // AverageCalc