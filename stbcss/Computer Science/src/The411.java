/**
* The 411
* This program asks standard questions (such as name, age, gender, etc..)
* about a person and then displays the answers as a report.
*
* @author Conor Dunne (65950DUN)
* @date 02/26/13
*/

// The The411 class
import java.awt.*;

import hsa.Console;

public class The411
{
    // The output console
    static Console c;
    
    
    /**
     * This method accepts a String an an integer as a limit of the width of the screen.
     * The String will be wrapped in a paragraph to the width of the screen, just like a
     * word processor.
     * 
     * @param sentence the string that will be 'word wrapped'
     * @param widthLimit the integer width of the paragraph (int # of chars)
     */
    public static void wordWrap (String sentence, int widthLimit) {
    	
    	// Declare and initialize variables
    	int pos = widthLimit;
    	String word = sentence;
    	
    	// When word is longer than widthLimit
    	while (word.length() >= widthLimit) {
    		
    		// If there is no space found at position 12 in word, go back 1 spot
    		if (word.charAt(pos) != ' ') {
    			pos = pos - 1;
    		}
    		// If there is a space found at position 12 in word then
    		else {
    			
    			// Display from start to position 12 of word
    		    c.println(word.substring(0, pos));
    		    
    		    // Shorten word from position 12 to the end
    		    word = word.substring(pos + 1, word.length());
    		    
    		    // Reset position to widthLimit
    		    pos = widthLimit;
    		} // end if
    	} // end while
    	
    	// When word is less than widthLimit characters, display rest of word
    	c.println(word);
    	
    } // wordWrap method
    
    
    // Main program
    public static void main (String[] args)
    {
	
    	c = new Console ();

    	// Declare variables
    	String report, name, school, food, subject, colour, idol ="";
    	char gender;
    	int age, brothers, sisters;
    	
    	
    	// Colour and formatting
    	c.setTextBackgroundColor(Color.black);
    	c.setTextColor(Color.green);
    	c.clear();
    	
    	
    	// Initialise variables 
    	age = brothers = sisters = -1;
    	
    	
    	// Display title
    	c.println("<<<< The 411 >>>>");
    	c.println("=================");
    	
    	
    	// Ask for name
    	c.print("\nWhat is your name? ");
    	while (true) {
    		name = c.readLine();
    		if (name.length() > 0) break;
    		c.print("Enter your name: ");
    	} // end error trap
    	
    	
    	// Ask for gender (restrict answer to m or f)
    	c.print("\nAre you m-male or f-female? ");
    	while (true) {
    		gender = c.getChar();
    		if (gender == 'm' || gender == 'f')break;
    		c.print("\nAnswer with 'm' for male or 'f' for female: ");
    	} // end error trap    	
    	
    	
    	// Ask for age (restrict answer to > -1)
    	c.print("\n\nHow old are you? ");
    	while (true) {
    		try {
    			age = Integer.parseInt(c.readLine());
    			if (age > -1)break;
    			c.print("Must be greater than -1: ");
    		}
    		catch (NumberFormatException e) {
    			c.print("Not an integer!: ");  
    		}
    		
    	} // end error trap
    	
    	
    	// Ask for current school
    	c.print("\nWhat school do you go to? ");
    	while (true) {
    		school = c.readLine();
    		if (school.length() > 0) break;
    		c.print("Enter your school name: ");
    	} // end error trap
    	
    	
    	// Ask for number of brothers (restrict answer to > -1)
    	c.print("\nHow many brothers do you have? ");
    	while (true) {
    		try {
    			brothers = Integer.parseInt(c.readLine());
    			if (brothers > -1)break;
    			c.print("Must be greater than -1: ");
    		}
    		catch (NumberFormatException e) {
    			c.print("Not an integer!: ");  
    		}
    	} // end error trap
    	
    	// Ask for number of sisters (restrict answer to > -1)
    	c.print("\nHow many sisters do you have? ");
    	while (true) {
    		try {
    			sisters = Integer.parseInt(c.readLine());
    			if (sisters > -1)break;
    			c.print("Must be greater than -1: ");
    		}
    		catch (NumberFormatException e) {
    			c.print("Not an integer!: ");  
    		}
    	} // end error trap
    	
    	
    	// Ask for favourite food
    	c.print("\nWhat is your favourite food? ");
    	while (true) {
    		food = c.readLine();
    		if (food.length() > 0) break;
    		c.print("Enter your favourite food: ");
    	} // end error trap
    	
    	
    	// Ask for favourite subject
    	c.print("\nWhat is your favourite subject? ");
    	while (true) {
    		subject = c.readLine();
    		if (subject.length() > 0) break;
    		c.print("Enter your favourite subject: ");
    	} // end error trap
    	
    	
    	// Ask for favourite colour
    	c.print("\nWhat is your favourite colour? ");
    	while (true) {
    		colour = c.readLine();
    		if (colour.length() > 0) break;
    		c.print("Enter your favourite colour: ");
    	} // end error trap
    	
    	
    	// Ask for idol
    	c.print("\nWho is your idol? ");
    	while (true) {
    		idol = c.readLine();
    		if (idol.length() > 0) break;
    		c.print("Enter the name of your idol: ");
    	} // end error trap
    	
    	
    	// Build report:
    	
    	// Add name, age, favourite subject and school to report
    	report = "This is " + name + ", who is " + age + " years old and loves taking " + subject + " at " + school + ". ";
        
    	// If user is male or female, add gender to report
    	if (gender == 'm') {
    		report = report + "He has ";
    	}
    	else if (gender == 'f') {
    		report = report + "She has ";
    	} 
    	
    	// Add number of brothers to report
    	report = report + brothers + " brother";
    	
    	// If # of brothers = 0 or > 1, add plural
    	if (brothers == 0 || brothers > 1) {
    		report = report + "s";
    	}
  
    	// Add number of sisters to report
    	report = report + " and " + sisters + " sister";
    	
    	// If # of sisters = 0 or > 1, add plural
    	if (sisters == 0 || sisters > 1) {
    		report = report + "s";	
    	}
    	    	
    	// Add favourite food, and idol to report
    	report = report + ", and often dreams about eating " + food + " with "  + idol + ". ";
    	
    	// If user is male or female, add gender to report
    	if (gender == 'm') {
    		report = report + "His";
    	}
    	else if (gender == 'f') {
    		report = report + "Her";
    	}
    	
    	// Add favourite colour to report
    	report = report + " favourite colour is " + colour + ".";
    	
    	
    	// Clear screen
    	c.clear();
    	
    	
    	// Display report header
    	c.println("<<<< 411 REPORT >>>>");
    	c.println("--------------------\n");
    	
    	// Display report with paragraph wrapped to 70 characters
    	wordWrap(report, 70);
    	
    } // main method
} // The411 class
