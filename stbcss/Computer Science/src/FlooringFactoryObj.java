/**	
 * Flooring Factory
 * This program will calculate the cost of flooring depending on the size
 * of a room specified by the user. The user is given a choice of flooring
 * and once chosen will be given a detailed statement of the cost of
 * installing the floor. The program uses methods and arrays to make
 * the program much more simplified. 
 *
 * @author Conor Dunne (65950DUN)
 * @date 03/08/13
 */

// The FlooringFactory class
import java.awt.*;
import java.io.*;
import hsa.Console;

public class FlooringFactoryObj {
	
	// The output console
	static Console c;
	

	/**
	 * This method asks for length and width of room and returns the area
	 * 
	 * @return area - area of the room in metres squared
	 */
	public static double getArea() {

		// Declare variables
		double length, width;
		double area;

		// Ask for length
		c.print("Enter the length of the room in metres: ");
		while (true) {
			try {
				length = Double.parseDouble(c.readLine());
				if (length > 0)
					break;
				c.print("Length must be greater than 0!: ");

			} catch (NumberFormatException e) {
				c.print("Not a real!: ");
			} // catch
		} // end error trap

		// Ask for width
		c.print(" Enter the width of the room in metres: ");
		while (true) {
			try {
				width = Double.parseDouble(c.readLine());
				if (length > 0)
					break;
				c.print("Width must be greater than 0!: ");

			} catch (NumberFormatException e) {
				c.print("Not a real!: ");
			} // catch
		} // end error trap

		// Calculate area
		area = length * width;

		// Return area back to main
		return area;

	} // getArea method
	

	/**
	 * This method gives user a choice of floor covering and returns the cost
	 * per sq.m to main program
	 * 
	 * @param floorType - String array that holds the names of the floor types
	 * @param softness - integer array that holds the softness factors of floor
	 * @param floorCost - double array that holds the cost per sq.m. for each floor
	 * @return floorCost - floor cost per sq.m.
	 */
	public static double getFloorTypeCost(FloorType [] floor) {

		// Declare variables
		int option;

		// Set up table of options
		c.println("\nPlease choose the type of covering\n");
		c.print("#. Type", 16);
		c.print("Softness", 10);
		c.print("Cost per sq.m.\n");

		// Display all floor options
		for (int i = 0; i < floor.length; i++) {
			c.print("\n" + (i + 1) + ". ");
			c.print(floor[i].getName(), 16);
			c.print("\t" + floor[i].getSoftness(), 9);
			c.print("$ ");
			c.print(floor[i].getCost(), 8, 2);
		}

		// Ask for option
		c.print("\n\nEnter your choice: ");
		while (true) {
			try {
				option = Integer.parseInt(c.readLine());
				if (option >= 1 && option <= floor.length)
					break;
				c.print("Enter option 1-5: ");
			} catch (NumberFormatException e) {
				c.print("Not an integer!: ");
			}
		} // end error trap

		// Return floor cost
		return floor[option - 1].getCost();

	} // getFloorTypeCost method
	

	/**
	 * This method takes the area of the room and floor cost per sq.m. and
	 * calculates and display a detailed estimate of material cost, labour,
	 * subTotal, tax and the grand total.
	 * 
	 * @param area - double value of area of room
	 * @param floorTypeCost - double value of cost of flooring per sq.m.
	 * @return total - grand total of all the materials
	 */
	public static double displayEstimate(double area, double floorTypeCost) {

		// Declare variables
		double materialCost, labourCost, subTotal, tax, total;

		// Declare constants
		final double HST = 0.13;
		final double labour = 6.50;

		// Calculate material cost
		materialCost = area * floorTypeCost;

		// Calculate labour charge
		labourCost = area * labour;

		// Calculate sub-total
		subTotal = materialCost + labourCost;

		// Calculate tax
		tax = subTotal * HST;

		// Calculate grand total
		total = subTotal + tax;

		// Display estimate:

		// Display material cost
		c.print("\nMaterial cost:", 14);
		c.print(materialCost, 16, 2);

		// Display labour charge
		c.print("\nLabour charge:", 14);
		c.print(labourCost, 16, 2);

		// Display separator
		c.print("\n", 22);
		c.print("---------");

		// Display sub-total
		c.print("\nSub-total", 15);
		c.print(subTotal, 16, 2);

		// Display tax
		c.print("\n     HST (13%)", 14);
		c.print(tax, 16, 2);

		// Display separator
		c.print("\n", 22);
		c.print("---------");

		// Display grand-total
		c.print("\nTOTAL COST", 15);
		c.print(total, 16, 2);

		// Return total to main program
		return total;

	} // displayEstimate method
	

	/**
	 * This method asks user to press any key to continue.
	 */
	public static void pressAnyKey() {

		// Ask user to press any key
		c.println("Press any key to enter more rooms");
		c.getChar();

	} // pressAnyKey method
	

	// Main program
	public static void main(String[] args) {

		c = new Console();
		FloorType[] floor = new FloorType[8];
		
		// Declare variables
		double allTotal = 0;
		int roomCount = 0;

		
		// Input values into FloorType objects
		floor[0] = new FloorType("Low pile carpet", 4, 18.75);
		floor[1] = new FloorType("Shag rug", 5, 11.05);
		floor[2] = new FloorType("Parquet", 0, 14.35);
		floor[3] = new FloorType("Linoleum", 1, 10.40);
		floor[4] = new FloorType("Hardwood", 0, 28.15);
		floor[5] = new FloorType("Marble", 0, 32.64);
		floor[6] = new FloorType("Slate", 0, 23.19);
		floor[7] = new FloorType("Gold", 2, 1617.11);
		

		// Colour and formatting
		c.setTextBackgroundColor(Color.black);
		c.setTextColor(Color.white);
		c.clear();

		// Display title
		c.println("Astronomical Ast.X's Flooring Factory");

		// Display explanation
		c.println("\nWelcome to Astronomical Ast.X's! Where prices are");
		c.println("astronmically cheap! We aim to amaze you with high ");
		c.println("quality floors for your spacious rooms!");
		c.println("\nThis program will help you determine the cost");
		c.println("for flooring for your room.\n");

		do {

			// Call display estimate method and count combined total of all rooms
			allTotal = allTotal + displayEstimate(getArea(), getFloorTypeCost(floor));
			
			// Count room
			roomCount = roomCount + 1;

			// Display combined total if there is more than 1 room estimated
			if (roomCount > 1) {
				c.print("\nRunning total:", 15);
				c.print(allTotal, 16, 2);
			} // end if

			// Inform user that estimate is valid for 30 days
			c.println("\n\nThis estimate is valid for 30 days.");
			c.println("Thank you, and have a nice day!\n");

			// Ask user to press any key to continue if they want to enter more rooms
			pressAnyKey();
			c.clear();

		} while (true); // end do

	} // main method
} // FlooringFactory class
