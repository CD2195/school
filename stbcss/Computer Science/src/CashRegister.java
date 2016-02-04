/**
 * Express Lane Cash Register
 * 
 * This program will accept up to 16 items with prices for each limited to $19.99. 
 * Then it will calculate & display HST, Sub-total and Grand Total of all the items.
 * When entering item prices, entering 0 will go straight to the totals of the items entered
 * previously. Entering 1 after this step will restart the program, while entering 0 will stop
 * the program and display the total value of all sales since the program started and then stop
 * the program.
 *
 * @author Conor Dunne (65950DUN)
 * @date 02/15/13
 */

// The CashRegister class
import java.awt.*;
import hsa.Console;

public class CashRegister
{
    // The output console
    static Console c;

    public static void main (String[] args)
    {
    	
    	// Declare Constants
    	final double HST = 0.13;
    	
    	// Declare variables
    	double itemPrice;
    	double subTotal;
    	double tax;
    	double grandTotal;
    	double totalCount = 0;
    	int runCount = 0;
    	char option;
    	
    	// Open new console
    	c = new Console ();
    	
		// Loop sale program
		do {
			
			// Clear console for reruns
			c.clear();
			
			// Reset subTotal to 0
			subTotal = 0;
			
			// Display title & description
			c.println("Zehrs St. Benedict Location");
			c.println("===========================");
			
			c.println("\nWelcome to my Zehrs! Enter the prices of");
			c.println("your 16 items and I will calculate the total");
			c.println("cost, including both taxes. Press 0 to stop");
			c.println("inputting items.");
			c.println();
			
			// Loop - input item prices
			for (int i = 0; i < 16; i++) {
				// Enter item price (error trap to limit itemPrice to $19.99)
				while (true) {
					itemPrice = c.readDouble();
					if (itemPrice > -1 && itemPrice < 20)break;
					c.print("Price cannot exceed $19.99: ");
				} // Close error trap
				
				// If price of item is 0, exit
				if (itemPrice == 0)break;
				
				// Add current price to subTotal
				subTotal = subTotal + itemPrice;
				
			} // Close sales loop
			
			// Calculate tax
			tax = HST * subTotal;
			
			// Calculate grand total
			grandTotal = tax + subTotal;
			
			// Display sub-total
			c.print("\n\nSub-total: $ ");
			c.println(subTotal, 6, 2);
			
			// Display HST
			c.print("\n HST:", 13); 
			c.println(tax, 6, 2);
			
			// Display grand total
			c.print("\nTotal:", 13);
			c.println(grandTotal, 6, 2);
			
			// Add grand total to sales record 
			totalCount = totalCount + grandTotal;
			
			// Add this run to run record
			runCount = runCount + 1;
			
			// Display 'goodbye' message
			c.println("\n\nThank you! Please come again!");
			c.println("=============================");
			
			// Wait for user to press 1 to continue, 0 to exit (error trap)
			while (true) {
				option = c.getChar();
				if (option == '0' || option == '1') break;
			}
    			
    			
    	}
		
		// If option = 1, restart sales loop. If 0, continue to next line
    	while (option == '1'); 
		
		// Clear console
		c.clear();
		
		// Display number of reruns
		c.println("Total runs: " + runCount);
		
		// Display total value of all sales
		c.print("Total of all sales: ");
		c.println(totalCount, 0, 2);   				

    } // main method
} // CashRegister class
