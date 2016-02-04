/**
* Advanced Calculator
*
* @author Conor Dunne (65950DUN)
* @date 02/22/13
*/

// Import section
import java.util.*;

// The AdvCalculator class
public class AdvCalculator
{

    public static void main (String[] args)
    {
	
    	// Set up Scanner 
    	Scanner sc = new Scanner(System.in);
    	
    	// Declare variables
    	String strOption;
    	double radius; // radius of circle
    	double base; // base of triangle
    	double height; // height of triangle
    	double length; // length of triangle
    	double width; // width of triangle
    	
    	// Display title
    	System.out.println("<<<<< Advanced Calculator Terminal >>>>>");

    	// Start main loop
    	while (true) {
    		
    		// Ask user for command (restrict strOption to known commands)
    		System.out.print("\nEnter command (? for list of commands): ");
    		while (true) {
    			strOption = sc.nextLine();
    			strOption = strOption.toLowerCase();
    			if (strOption.equals("?") || strOption.equals("circumference") || strOption.equals("areac") 
    					|| strOption.equals("areat") || strOption.equals("areas") || strOption.equals("pythag")) break;
    			System.out.print("Command does not exist. (Enter '?' for list of known commands): ");
    		} // error trap
    		
    		// If strOption is ?, then show list of known commands
    		if (strOption.equals("?")) {
    			System.out.println("\nList of known commands:");
    			System.out.println("\t'?' - Shows this help menu");
    			System.out.println("\t'circumference' - Calculates the circumference of a circle");
    			System.out.println("\t'areaC' - Caclulates the area of a circle");
    			System.out.println("\t'areaT' - Calculates the area of a triangle");
    			System.out.println("\t'areaS' - Caculates the area of a square");
    			System.out.println("\t'pythag' - Calculates Pythagoras Theorem");
    			
    		} // end '?' option
    		
    		// If strOption is circumference
    		else if (strOption.equals("circumference")) {
    			
    			// Ask for radius
    			System.out.print("\nEnter the radius of the circle in cm: ");
    			while (true){
    				radius = sc.nextDouble();
    				if (radius > 0)break;
    				System.out.print("Radius must be greater than 0: ");
    			} // error trap
    			
    			// Calculate and display circumference
    			System.out.println("\nThe circumference of the circle is " + (radius * Math.PI) + " cm.");
    			
    		} // circumference
    		
    		// If strOption is area of circle
    		else if (strOption.equals("areac")) {
    			
    			// Ask for radius
    			System.out.print("\nEnter the radius of the circle in cm: ");
    			while (true){
    				radius = sc.nextDouble();
    				if (radius > 0)break;
    				System.out.print("Radius must be greater than 0: ");
    			} // error trap
    			
    			// Calculate and display area of circle
    			System.out.println("\nThe area of the circle is " + (Math.PI * Math.pow(radius, 2)) + " cm²");
    			
    		} // area of circle
    		
    		// If strOption is area of triangle
    		else if (strOption.equals("areat")) {
    			
    			// Ask for base of triangle
    			System.out.print("\nEnter the base of the triangle in cm: ");
    			while (true){
    				base = sc.nextDouble();
    				if (base > 0)break;
    				System.out.print("Base must be greater than 0: ");
    			} // error trap
    			
    			// Ask for height of triangle
    			System.out.print("Enter the height of the triangle in cm: ");
    			while (true){
    				height = sc.nextDouble();
    				if (height > 0)break;
    				System.out.print("height must be greater than 0: ");
    			} // error trap
    			
    			// Calculate and display area of triangle
    			System.out.println("\nThe area of the triangle is " + ((base * height) / 2) + " cm²");
    			
    		} // area of triangle
    		
    		// If strOption is area of rectangle
    		else if (strOption.equals("areas")) {
    			
    			// Ask for length of rectangle
    			System.out.print("\nEnter the length of the rectangle in cm: ");
    			while (true){
    				length = sc.nextDouble();
    				if (length > 0)break;
    				System.out.print("Length must be greater than 0: ");
    			} // error trap
    			
    			// Ask for width of rectangle
    			System.out.print("Enter the width of the rectangle in cm: ");
    			while (true){
    				width = sc.nextDouble();
    				if (width > 0)break;
    				System.out.print("Width must be greater than 0: ");
    			} // error trap
    			
    			// Calculate and display area of rectangle
    			System.out.println("\nThe area of the rectangle is " + (length * width) + " cm²");
    		
    		} // area of rectangle
    		
    		// If strOption is Pythagoras Theorem
    		else if (strOption.equals("pythag")) {
    			
    			// Ask for base
    			System.out.print("\nEnter the base of the triangle in cm: ");
    			while (true){
    				base = sc.nextDouble();
    				if (base > 0)break;
    				System.out.print("Base must be greater than 0: ");
    			} // error trap
    			
    			// Ask for height of triangle
    			System.out.print("Enter the height of the triangle in cm: ");
    			while (true){
    				height = sc.nextDouble();
    				if (height > 0)break;
    				System.out.print("height must be greater than 0: ");
    			} // error trap
    			
    			// Calculate and display hypotenuse
    			System.out.println("\nThe hypotenuse is " + (Math.sqrt(Math.pow(base, 2) + Math.pow(height, 2))) + " cm.");
    			
    		} // Pythagoras theorem 
    		
    		// Separate next line
    		System.out.println("----------------------------------------------------------------");
    		
    		// Resolve integer/real input bug
    		if (!strOption.equals("?")) {
        	strOption = sc.nextLine();
    		}
    		
    	} // main loop
    	
    } // main method
} // AdvCalculator class
