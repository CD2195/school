/**
 * Logo
 * Description of your program which
 * should be written in proper grammar
 * using sentences.
 *
 * @author Conor Dunne (65950DUN)
 * @date 05/13/13
 */

// The Logo class.
import java.awt.*;
import java.io.*;
import hsa.Console;

public class Logo {
	// The output console
	static Console c;

	// Declare FatTurle class
	static FatTurtle t;

	/**
	 * Passes the commands line-by-line to performAction method
	 * @param commands - String array
	 */
	public static void drawArray (String [] commands) {
		
		// Declare variables
		int start;
		int end;
		int j = 0;
		int arraySize;
		int index;
		int repeatNum;
		
		// Compile and run .logo file line-by-line
		for (int i  = 0; i < commands.length; i ++) {
			
			// If there is no repeat, perform action
			if (!commands[i].startsWith("repeat")) {
				performAction(commands[i]);
			}
			// If repeat
			else {
				
				// Find first element
				while(true) {
					
					// If start bracket is found
					if (commands[i + j].indexOf("[") > 0) {
						start = i + j + 1;
						break;
					} // end if
					
					// Increment j by 1
					j++;
					
				} // end while
				
				// Find last element
				j = 0;
				while (true) {
					
					// If end bracket is found
					if (commands[start + j].indexOf("]") > 0) {
						end = start + j - 1;
						break;
					} // end if
					
					// Increment j by 1
					j++;
					
				} // end while
				
				// Calculate size of array
				arraySize = end - start + 1;
				
				// Declare repeat array
				String [] repeatArray = new String [arraySize];
				
				// Input values into repeat array
				for (int k = 0; k < arraySize; k ++)
				{
					repeatArray[k] = commands[i + k];
				} // end for
				
				// Get number of times to repeat
				index = commands[i].indexOf(" ");
				repeatNum = Integer.parseInt(commands[i].substring(index +1, commands[i].length()));
				
				// Pass repeatArray into drawArray repeatNum times
				for (int l = 0; l < repeatNum; l++) {
					drawArray(repeatArray);
				} // end for
				
				// Set i to after the end of the repeat block
				i = end + 1;				
			
			} // end if	
		}
	} // void drawArray (String[])

	/**
	 * Splits the command into string and variable so it can be emulated
	 * by the FatTurtle class
	 * @param command - String
	 */
	public static void performAction (String command) {

		// Declare variables
		int index;
		int num = 0;
		String cmd;
		Color clr = Color.black;

		// Split up the command
		index = command.indexOf(" ");
		cmd = command.substring(0, index);
		num = Integer.parseInt(command.substring(index +1, command.length()));


		// Carry out command
		if (cmd.equals("fd")) {
			t.move(num);
		} else if (cmd.equals("bk")) {
			t.move(-num);
		} else if (cmd.equals("lt")) {
			t.turnRight(num);
		} else if (cmd.equals("rt")) {
			t.turnLeft(num);
		} else if (cmd.equals("pu")) {
			t.hideTrace();
		} else if (cmd.equals("pd")) {
			t.showTrace();
		} else if (cmd.equals("pw")) {
			t.setLineWidth(num);
		} else if (cmd.equals("hm")) {
			t.setPosition(c.maxx() / 2, c.maxy() / 2);
		} // end if

		// If command uses colour
		if (cmd.equals("pc") || cmd.equals("cs")) {

			// Set colour
			if (num == 1) {
				clr = Color.black;
			} else if (num == 2) {
				clr = Color.red;
			} else if (num == 3) {
				clr = Color.blue;
			} else if (num == 4) {
				clr = Color.green;
			} else if (num == 5) {
				clr = Color.yellow;
			} else if (num == 6) {
				clr = Color.orange;
			} else if (num == 7) {
				clr = Color.magenta;
			} else if (num == 8) {
				clr = Color.white;
			} // end if

			// Carry out colour command
			if (cmd.equals("pc")) {
				t.setColor(clr);				
			} else if (cmd.equals("cs")) {
				
				// If num is not entered
				if (num == 0) {
					c.setTextBackgroundColor(Color.white);
				} else {
					c.setTextBackgroundColor(clr);
				} // end if 
				
				c.clear();
			} // end if
		} // end if 
	} // void performAction (String)

	public static void main (String[] args) throws IOException {
		
		// Open console window
		c = new Console ();

		// Declare variables
		int count = 0;
		String fileName;
		String text;

		// Instantiate new turtle
		t = new FatTurtle (c);

		// Set turtle heading to 270
		t.setAngle(270);

		// Read file routine

		// Ask for .logo file
		c.print("Enter the filename: ");
		while (true) {
			fileName = c.readLine();
			if (fileName.indexOf(".logo") > 0) {
				fileName = fileName + ".logo";
			} // end if
			if(fileName.length() > 0)break;
			c.print("Enter a valid fileName: ");
		} // end error trap

		// Open file
		BufferedReader input = new BufferedReader(new FileReader (fileName));
		text = input.readLine();

		// Count number of lines
		while (text != null) {
			text = input.readLine();
			count++;
		} // end while

		// Close file
		input.close();

		// Declare array
		String[] commands = new String[count];

		// Reopen file
		input = new BufferedReader (new FileReader(fileName));

		// Read data into array
		for (int i = 0; i < count; i++) {
			commands[i] = input.readLine();
		} // end for

		// Compile .logo file
		drawArray(commands);


	} // main method
} // Logo class
