/**
 * DeltaVCalc
 * A calculator which calculates the delta-V of each stage of a rocket as well as it's total delta-V.
 *
 * @author Emil Alexandru Danila
 * @date 02/08/13
 */

// The DeltaVCalc class
import java.awt.*;
import hsa.Console;

public class DeltaVCalc {
	
	// The output console
	static Console c;
	
	public static void main(String[] args) {
		
		c = new Console();
		
		// constants
		final double standardGravity = 9.81;
		// craft total variables
		double totalDeltaV = 0;
		double totalFullMass = 0;
		// stage variables
		double stageDeltaV = 0;
		double stageFullMass = 0;
		double stageDryMass = 0;
		int stageSpecificImpulse = 0;
		
		// stage count
		int stageCount = 0;
		
		
		// main program loop
		while (true) {
			// reset variables
			stageDeltaV = 0;
			stageFullMass = 0;
			stageDryMass = 0;
			stageSpecificImpulse = 0;
			stageCount++;
			
			// get stageFullMass
			while (true) {
				try {
					c.print("Enter the stage's parts' full mass:", 45);
					stageFullMass = Double.parseDouble(c.readLine())*1000;
					break;
				} catch (NumberFormatException e) {
					c.println("\tInput not a number");
				}
			} // end get stageFullMass
			
			// get stageDryMass
			while (true) {
				try {
					c.print("Enter the stage's parts' dry mass:", 45);
					stageDryMass = Double.parseDouble(c.readLine())*1000;
					break;
				} catch (NumberFormatException e) {
					c.println("\tInput not a number");
				} 
			} // end get stageDryMass
			
			
			// get stageSpecificImpulse
			while (true) {
				try {
					c.print("Enter the stage's average specific impulse:", 45);
					stageSpecificImpulse = Integer.parseInt(c.readLine());
					break;
				} catch (NumberFormatException e) {
					c.println("\tInput not an integer");
				}
			} // end get stageSpecificImpulse
			
			
			// calculate totalFullMass
			totalFullMass = totalFullMass + stageFullMass;
			
			// calculate stageDeltaV
			stageDeltaV = standardGravity * stageSpecificImpulse * Math.log(totalFullMass / (totalFullMass - (stageFullMass - stageDryMass)));
			
			// calculate totalDeltaV
			totalDeltaV = totalDeltaV + stageDeltaV;
			
			// display stage report
			c.println("\nStage Report\n-------------");
			
			// display stage count
			c.println("\tStage Count: " + stageCount + "\n");
			
			// display full mass of rocket
			c.print("\t  Full Mass: "); 
				c.print(totalFullMass,14,2);
				c.println("  kg");
				
			// display mass with stage dry
			c.print("\t   Dry Mass: ");
				c.print(totalFullMass - (stageFullMass - stageDryMass),14,2); 
				c.println("  kg");
			
			// set colour for deltaV section
			c.setTextColor(Color.blue);
			
			// display stage deltaV
			c.print("\t   Stage ΔV: ");
				c.print(stageDeltaV,14,2);
				c.println(" m/s");
			
			// display total deltaV
			c.print("\t         ΔV: ");
				c.print(totalDeltaV,14,2);
				c.println(" m/s");
				
			// set colour back to black
			c.setTextColor(Color.black);
				
			// end of stage report
			c.println("-------------\n");
			
			
		} // while (true) - main program
	} // main method
} // DeltaVCalc
