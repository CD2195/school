/**	
 * AddressBook
 * This complex and versatile program is an address book that stores up 100 people's contact
 * information including their name, phone number, email address and home address; just like
 * a conventional address book. The user can list, add, delete, modify and search address 
 * entries. All the entries can be saved and all the information will be saved for next use 
 * of this program.
 * 
 * @author Conor Dunne (65950DUN)
 * @date 05/06/13
 */

// The "AddressBook" class
import java.awt.*;
import java.io.*;
import hsa.Console;

public class AddressBook {
	
	// Declare global variables
	static Console c, help;
	static int count = 0;

	// Reserve 100 person objects in memory
	static AddressEntry[] person = new AddressEntry[100];

	/**
	 * This method reads from addresses.txt and inputs each entry into the array
	 * of AddressEntry objects.
	 * 
	 * @throws IOException
	 */
	public static void readFile() throws IOException {

		// Open addresses.txt
		BufferedReader input = new BufferedReader(new FileReader(
				"addresses.txt"));
		String text = input.readLine();

		// Count number of lines
		while (text != null) {
			text = input.readLine();
			count++;
		}

		// Calculate number of entries
		count = count / 10;

		// Close addresses.txt
		input.close();

		// Open addresses.txt and input information into AddressEntry objects
		input = new BufferedReader(new FileReader("Addresses.txt"));
		for (int i = 0; i < count; i++) {
			person[i] = new AddressEntry(input.readLine(), input.readLine(),
					input.readLine(), input.readLine(), input.readLine(),
					input.readLine(), input.readLine(), input.readLine(),
					input.readLine(), input.readLine(), false);
		}

		// Close addresses.txt
		input.close();
	} // void readFile ()

	/**
	 * This method writes to addresses.txt and inputs each entry from the array
	 * of AddressEntry objects to the file.
	 * 
	 * @throws IOException
	 */
	public static void writeFile() throws IOException {

		// Overwrite addresses.txt
		PrintWriter output = new PrintWriter(new FileWriter("addresses.txt"));

		// Write array of AddressEntry object values to addresses.txt
		for (int i = 0; i < count; i++) {
			output.println(person[i].getFirstName());
			output.println(person[i].getLastName());
			output.println(person[i].getPhoneNumber());
			output.println(person[i].getStreetName());
			output.println(person[i].getHouseName());
			output.println(person[i].getCityName());
			output.println(person[i].getProvince());
			output.println(person[i].getPostalCode());
			output.println(person[i].getCountry());
			output.println(person[i].getEmail());
		} // end for

		// Close addresses.txt
		output.close();

	} // void writeFile ()

	/**
	 * This method lists 20 entries from 5 groups of the array of AddressEntry
	 * objects
	 * 
	 * @param pageNum
	 *            - integer
	 */
	public static void list(int pageNum) {

		// Declare variables
		int entrySegment = 0;
		int colourCount = 0;

		// Choose which entries to list depending on page number
		if (pageNum == 1) {
			entrySegment = 0;
		} else if (pageNum == 2) {
			entrySegment = 25;
		} else if (pageNum == 3) {
			entrySegment = 50;
		} else if (pageNum == 4) {
			entrySegment = 75;
		} // end if

		// Clear list
		c.setTextBackgroundColor(Color.black);
		clearBlock(2, 27);

		// Display options
		optionMenu("[1]-Last [2]-Next [D]-Detail [A]-Add [R]-Remove [M]-Modify [Q]-Query [S]-Save & Exit [?]-Help");

		// Display list header
		c.setTextBackgroundColor(Color.green);
		c.setTextColor(Color.black);
		c.print("  #", 4);
		c.print("Name", 20);
		c.print("Phone Number", 24);
		c.println("Email Address", 28);

		// Display list
		for (int i = entrySegment; i < entrySegment + 25; i++) {

			// If entry is existent and not deleted
			if (person[i] != null && person[i].getDelete() == false) {

				// Alternate colour schemes
				colourCount++;
				if (colourCount % 2 > 0) {
					c.setTextBackgroundColor(Color.black);
					c.setTextColour(Color.green);
				} else if (colourCount % 2 == 0) {
					c.setTextBackgroundColor(Color.green);
					c.setTextColor(Color.black);
				} // end if

				// Show brief information
				c.print((i + 1), 3);
				c.print((" " + person[i].lastName + ", " + person[i].firstName),
						20);
				c.print(person[i].getPhoneNumber(), 24);
				c.print(person[i].getEmail(), 28);
				c.print("\n");

			} // end if
		} // end for

		// Set default colour scheme
		c.setTextBackgroundColor(Color.black);
		c.setTextColor(Color.green);
	} // void list (int)

	/**
	 * This method lists detailed information of a single address entry.
	 * 
	 * @param index
	 *            - integer
	 */
	public static void showEntry(int index) {

		// Display name
		c.print("\nName        : ");
		c.print(person[index].getFirstName() + " "
				+ person[index].getLastName());

		// Display phone number
		c.print("\n\nPhone Number: ");
		c.print(person[index].getPhoneNumber());

		// Display email
		c.print("\n\nEmail       : ");
		c.print(person[index].getEmail());

		// Display address
		c.print("\n\nAddress     : ");
		c.print(person[index].getHouseName() + " "
				+ person[index].getStreetName());
		c.print("\n              " + person[index].getCityName() + ", "
				+ person[index].getProvince());
		c.print("\n              " + person[index].getPostalCode());
		c.print("\n              " + person[index].getCountry());

	} // void showEntry (int)

	/**
	 * This method instantiates a new AddressEntry object with a minimal amount
	 * of information; the first and last name. The user has an option to add
	 * more information by short-cutting to the modEntry method.
	 */
	public static void addEntry() {

		// Declare variables
		char answer;
		String firstName;
		String lastName;

		// Ask user for first and last name
		c.print("Enter first name: ");
		firstName = c.readLine();
		c.print("Enter last name : ");
		lastName = c.readLine();

		// Instantiate object
		person[count] = new AddressEntry(firstName, lastName, false);

		// Ask user if they want to add the rest of the required information
		c.print("\nDo you want to add the rest of the information (Y/n)?");
		while (true) {
			answer = c.getChar();
			if (answer == 'y' || answer == 'Y' || answer == 'n'
					|| answer == 'N')
				break;
			c.print("Enter 'y' for yes or 'n' for no: ");
		} // end error trap

		// If answer is yes, use modify entry method
		if (answer == 'y' || answer == 'Y') {
			modEntry(count);
		} // end if

		// Add 1 to count
		count++;

	} // void addEntry ()

	/**
	 * This method removes a specific entry
	 * 
	 * @param index
	 *            - integer
	 */
	public static void delEntry(int index) {

		// Shift arrays over deleted entry
		for (int i = index; i < count - 1; i++) {
			person[i].setFirstName(person[i + 1].getFirstName());
			person[i].setLastName(person[i + 1].getLastName());
			person[i].setPhoneNumber(person[i + 1].getPhoneNumber());
			person[i].setHouseName(person[i + 1].getHouseName());
			person[i].setStreetName(person[i + 1].getStreetName());
			person[i].setCityName(person[i + 1].getCityName());
			person[i].setProvince(person[i + 1].getProvince());
			person[i].setPostalCode(person[i + 1].getPostalCode());
			person[i].setCountry(person[i + 1].getCountry());
			person[i].setEmail(person[i + 1].getEmail());
		} // end for

		// Delete last entry
		person[count - 1].setDelete(true);

		// Remove 1 from count
		count--;
	} // void delEntry (int)

	/**
	 * This method gives a set of options that modify different components of
	 * the entry. All the address components are bundled into 1 option, while
	 * every other component has its own option. When an option is selected, the
	 * user enters in the new value and the changes are made. To save changes
	 * and return to main list, the user can press 'Q'.
	 * 
	 * @param index
	 *            - integer
	 */
	public static void modEntry(int index) {

		// Declare variables
		char option;

		// Loop
		while (true) {
			// Clear list and reset options menu
			clearBlock(2, 27);
			optionMenu("[F]-First Name [L]-Last Name [P]-Phone Number [A]-Address [E]-Email [Q]-Back to list [?]-Help");

			// Change colour scheme
			c.setTextBackgroundColor(Color.black);
			c.setTextColor(Color.green);

			// List entry in detail
			showEntry(index);

			// Ask for option
			while (true) {
				option = c.getChar();
				if (option == 'F' || option == 'f' || option == 'L'
						|| option == 'l' || option == 'P' || option == 'p'
						|| option == 'A' || option == 'a' || option == 'E'
						|| option == 'e' || option == 'Q' || option == 'q'
						|| option == '?')
					break;
			} // end error trap

			// Option selection
			c.println("\n");

			// If option 'F'
			if (option == 'F' || option == 'f') {
				// Ask for first name
				c.print("Enter first name: ");
				person[index].setFirstName(c.readLine());
			} // end option 'F'

			// If option 'L'
			else if (option == 'F' || option == 'f') {
				// Ask for last name
				c.print("Enter last name: ");
				person[index].setLastName(c.readLine());
			} // end option 'L'

			// If option 'P'
			else if (option == 'P' || option == 'p') {
				// Ask for phone number
				c.print("Enter phone number: ");
				person[index].setPhoneNumber(c.readLine());
			} // end option 'P'

			// If option 'A'
			else if (option == 'A' || option == 'a') {
				// Ask for address components
				c.print(" Enter house name: ");
				person[index].setHouseName(c.readLine());
				c.print("Enter street name: ");
				person[index].setStreetName(c.readLine());
				c.print("  Enter city name: ");
				person[index].setCityName(c.readLine());
				c.print("   Enter province: ");
				person[index].setProvince(c.readLine());
				c.print("Enter postal code: ");
				person[index].setPostalCode(c.readLine());
				c.print("    Enter country: ");
				person[index].setCountry(c.readLine());
			} // end option 'A'

			// If option 'E'
			else if (option == 'E' || option == 'e') {
				// Ask for email address
				c.print("Enter email address: ");
				person[index].setEmail(c.readLine());
			} // end option 'E'

			// If option 'Q', exit
			else if (option == 'Q' || option == 'q')
				break;

			// If option '?'
			else {
				// Load help window, page 6
				help(6);
			} // end option '?'
		} // end while
	} // void modEntry (int)

	/**
	 * This method accepts a search string and searches every component of every
	 * entry for any matches. Each entry that has a match is displayed with the
	 * reference number and the corresponding name of that entry. The number of
	 * matches is returned.
	 * 
	 * @param search
	 *            - integer
	 * @return matchCount - integer
	 */
	public static int findEntry(String search) {

		// Declare variables
		int orderCount = 0;
		int matchCount = 0;

		// Clear list
		c.setTextBackgroundColor(Color.black);
		clearBlock(3, 26);

		// Display list header
		c.setTextBackgroundColor(Color.green);
		c.setTextColor(Color.black);
		c.print("  #", 25);
		c.print("  #", 25);
		c.print("  #", 25);
		c.print("  #", 25);

		// Change colour scheme
		c.setTextBackgroundColor(Color.black);
		c.setTextColor(Color.green);

		for (int i = 0; i < count; i++) {
			// If the search terms matches any of components of person[i], list
			if (person[i].getFirstName().indexOf(search) > -1
					|| person[i].getLastName().indexOf(search) > -1
					|| person[i].getPhoneNumber().indexOf(search) > -1
					|| person[i].getStreetName().indexOf(search) > -1
					|| person[i].getHouseName().indexOf(search) > -1
					|| person[i].getCityName().indexOf(search) > -1
					|| person[i].getProvince().indexOf(search) > -1
					|| person[i].getPostalCode().indexOf(search) > -1
					|| person[i].getCountry().indexOf(search) > -1
					|| person[i].getEmail().indexOf(search) > -1) {

				// Add 1 to orderCount and matchCount
				orderCount++;
				matchCount++;

				// If orderCount is 5, make new line
				if (orderCount == 5) {
					c.print("\n");
					orderCount = 0;
				} // end if

				// Show brief information
				c.print((i + 1), 3);
				c.print((" " + person[i].lastName + ", " + person[i].firstName + " "),
						22);
			} // end if
		} // end for

		// Return number of matches
		return matchCount;
	} // int findEntry (int)

	/**
	 * This method opens up a new console window that serves as a small help
	 * window for users. The help window will be interactive; the user can
	 * browse through pages and choose to close the window. Also, the method
	 * gives the ability for the help window to show any page first.
	 * 
	 * @param page
	 *            - integer
	 */
	public static void help(int page) {

		// Declare variables
		char option;
		int pageCount = page;

		// Create help window
		help = new Console();

		// Set background colour
		help.setTextBackgroundColor(Color.black);
		help.clear();

		// Display title
		help.setTextBackgroundColor(Color.blue);
		help.setTextColor(Color.white);
		help.println("");
		help.setCursor(1, (help.getMaxColumns() - 23) / 2);
		help.println("AddressBook V1.0 - Help");

		// Show options
		help.setTextBackgroundColor(Color.LIGHT_GRAY);
		help.setTextColor(Color.black);
		help.println("");
		help.setCursor(2, (help.getMaxColumns() - 50) / 2);
		help.println("[1]-Previous Page [2]-Next Page [Q]-Quit Help Window");

		// Change colour scheme
		help.setTextBackgroundColor(Color.black);
		help.setTextColor(Color.green);

		// Loop
		while (true) {

			// If main menu help has been selected
			if (pageCount == 1) {

				// Tell user what to do
				help.println("\nWelcome to the help page!\n");
				wordWrap(
						"This help page will guide you through the different options "
								+ "this program has to offer. Just simply press '1' to back a page or '2'"
								+ " to go to the next page to navigate through all the options. If you want"
								+ " to close the help window, press 'Q'.",
						help.getMaxColumns());
			} // end if

			// Wait for option
			while (true) {
				help.setCursor(help.getMaxRows() - 1, 1);
				option = help.getChar();
				if (option == '1' || option == '2' || option == 'Q'
						|| option == 'q')
					break;
			} // end error trap

			// Move cursor
			help.setCursor(help.getMaxRows() - 1, 1);

			// If option is '1'
			if (option == '1') {

				// If pageCount is 1, notify user
				if (pageCount == 1) {
					help.print("Page 1");
				}

				// If pageCount is between 1 and 10, go back one page
				else if (pageCount > 1 && pageCount < 10) {
					help.print("Page " + (pageCount - 1));
					pageCount--;
				} // end if
			} // end option '1'

			// If option is '2'
			else if (option == '2') {

				// If option is 9, notify user
				if (option == 9) {
					help.print("Page 9");
				}

				// If pageCount is less than 9, goto next page
				else if (pageCount < 9) {
					help.print("Page " + (pageCount + 1));
					pageCount++;
				} // end if
			} // end option '2'

			// If option 'Q', exit loop
			else break;

			// Clear page
			help.setCursor(3, 1);
			for (int i = 0; i < 21; i++) {
				help.println("");
			} // end for
			help.setCursor(3, 1);

			// Information for each page
			// if page X is selected
			if (pageCount == 2) {
				help.println("\nChanging Pages Option");
				help.println("\nOptions:");
				help.println("[1]-Last");
				help.println("[2]-Next\n");
				wordWrap(
						"The list of all the persons are displayed across 1-4 pages depending on the number of entries. "
								+ "You can have up to 100 people in your AddressBook, and those 100 entries are organised into 4 pages, meaning "
								+ "that there can be a maximum of 25 entries per page. All the entries have a corresponding number next to them. "
								+ "You can reference to a person using their corresponding number for when an option requires you to select an "
								+ "entry of your choice.", help.getMaxColumns());
				wordWrap(
						"\nYou can browse through these pages by pressing '1' or '2' on your keyboard. '1' will allow you to go back one "
								+ "page (unless you are already on page 1) and '2' will allow you to go forward one page (all the way up to page 4).",
						help.getMaxColumns());
			} else if (pageCount == 3) {
				help.println("\nShow Entry Option");
				help.println("\nOption:");
				help.println("[D]-Detail\n");
				wordWrap(
						"This option (press 'd' on the keyboard to select this option) asks you to select an entry by its reference number. After typing in the number, press enter. "
								+ "The screen will show detailed information about the person you selected. This information includes their first and last "
								+ "name, phone number, house address and email address. If some of the informstion has not been filled in or you want to make "
								+ "changes, see page 6 for the Modify Entry option.",
						help.getMaxColumns());
			} else if (pageCount == 4) {
				help.println("\nAdd Entry Option");
				help.println("\nOption:");
				help.println("[A]-Add\n");
				wordWrap(
						"This option (press 'a' on the keyboard to select this option) adds a new person to your AddressBook. On the screen you will be "
								+ "prompted to enter the first name of the person. Enter the name, then press enter. Then you will be asked whether if you would like "
								+ "to add the rest of the information. You can reply with 'y' for yes or 'n' for no. If you press yes, you will be directed to the Mod Entry "
								+ "interface to add in the rest of the values. (See page 6 for more information) If select no, you will be returned back to list with the new entry listed.",
						help.getMaxColumns());
			} else if (pageCount == 5) {
				help.println("\nRemove Entry Option");
				help.println("\nOption:");
				help.println("[R]-Remove\n");
				wordWrap(
						"This option (press 'r' on the keyboard to select this option) removes an entry that you are asked to select it by its reference number. Enter "
								+ "the reference number of the entry you wish to delete and press enter. You are then asked if you are sure you want to delete the entry. Press 'y' for "
								+ "yes or 'n' for no. If you choose yes, the entry is promptly deleted. If you pressed no, the entry is not deleted and you are returned back to the list",
						help.getMaxColumns());
			} else if (pageCount == 6) {
				help.println("\nModify Entry Option");
				help.println("\nOption:");
				help.println("[M]-Modify\n");
				wordWrap(
						"This option (press 'm' on the keyboard to select this option from the main menu) prompts you to enter the reference number of the entry you wish "
								+ "to modify and you are given a new set of options. Each option modifies a certain component of the entry. To modify a component of the entry, select an "
								+ "option that allows you to type and enter the new value(s) for that component. Here are the options and their purpose:",
						help.getMaxColumns());
				help.println("\n[F]-First Name   : Changes the first name");
				help.println("[L]-Last Name    : Changes the last name");
				help.println("[P]-Phone Number : Changes the phone number");
				help.println("[A]-Home Address : Changes the home address");
				help.println("[E]-Email Address: Changes the email address");
				help.println("[Q]-Back to List : Any changes are kept and you are returned back to the list");
				help.println("[?]-Help         : Shows this page of the help window");

			} else if (pageCount == 7) {
				help.println("\nSearch Entry Option");
				help.println("\nOption:");
				help.println("[Q]-Query\n");
				wordWrap(
						"This option (press 'q' on the keyboard to select this option from the main menu) prompts you to type and enter the information that you want "
								+ "to be searched. Any person(s) that match the criteria will be listed on the screen with their reference number and their full name. You can select any "
								+ "option as normal.", help.getMaxColumns());
			} else if (pageCount == 8) {
				help.println("\nSave & Quit Option");
				help.println("\nOption:");
				help.println("[S]-Save & Quit\n");
				wordWrap(
						"This option (press 's' on the keyboard to select this option from the main menu) asks if you are sure you want to save changes and exit. "
								+ "Press 'y' for yes or 'n' for no. If choose yes, the changes are saved to addresses.txt and the main window is closed. If you choose no, the program "
								+ "will not save chanages and will run normally.",
						help.getMaxColumns());
			} else if (pageCount == 9) {
				help.println("\nHelp Option");
				help.println("\nOption:");
				help.println("[?]-Help\n");
				wordWrap("This option opens this help window.",
						help.getMaxColumns());
			} // end if
		} // end while
		
		// Close window if option is quit
		help.close();

	} // void help (int)

	/**
	 * This method clears the list of Address Entries and relocates the cursor
	 * back to line 3.
	 */
	public static void clearBlock(int row, int lineNum) {
		c.setCursor(row, 1);
		for (int i = 0; i < lineNum; i++) {
			c.println("");
		} // end for
		c.setCursor(row, 1);
	} // void clearBlock (int, int)

	/**
	 * This method makes a bar on the screen that lists specified options
	 * 
	 * @param options
	 *            - String
	 */
	public static void optionMenu(String options) {

		// Change colour scheme
		c.setTextBackgroundColor(Color.LIGHT_GRAY);
		c.setTextColor(Color.black);

		// Apply colour scheme to line 2
		c.setCursor(2, 1);
		c.println("");

		// List options
		c.setCursor(2, (c.getMaxColumns() - options.length()) / 2);
		c.println(options);
	} // void optionMenu (String)

	/**
	 * This method accepts a String an an integer as a limit of the width of the
	 * screen. The String will be wrapped in a paragraph to the width of the
	 * screen, just like a word processor.
	 * 
	 * @param sentence
	 *            the string that will be 'word wrapped'
	 * @param widthLimit
	 *            the integer width of the paragraph (int # of chars)
	 */
	public static void wordWrap(String sentence, int widthLimit) {

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
				help.println(word.substring(0, pos));

				// Shorten word from position 12 to the end
				word = word.substring(pos + 1, word.length());

				// Reset position to widthLimit
				pos = widthLimit;
			} // end if
		} // end while

		// When word is less than widthLimit characters, display rest of word
		help.println(word);

	} // wordWrap method

	public static void main(String[] args) throws IOException {

		// Open console window
		c = new Console(31, 100);

		// Declare variables
		char option;
		int index = 0;
		int pageCount = 1;
		int matchCount;
		String searchString;

		// Read addresses.txt
		readFile();

		// Set background colour
		c.setTextBackgroundColor(Color.black);
		c.clear();

		// Display title
		c.setTextBackgroundColor(Color.blue);
		c.setTextColor(Color.white);
		c.println("");
		c.setCursor(1, (c.maxcol() - 16) / 2);
		c.println("AddressBook V1.0");

		// List entries
		list(1);

		// Loop
		while (true) {

			// Ask for option
			c.setTextBackgroundColor(Color.green);
			c.setTextColor(Color.black);
			c.setCursor(c.maxrow() - 2, 1);
			c.println("");
			c.setCursor(c.maxrow() - 2, 1);
			c.print("Enter an option: ");
			while (true) {
				option = c.getChar();
				if (option == '1' || option == '2' || option == 'D'
						|| option == 'd' || option == 'A' || option == 'a'
						|| option == 'R' || option == 'r' || option == 'M'
						|| option == 'm' || option == 'Q' || option == 'q'
						|| option == 'S' || option == 's' || option == '?')
					break;
				c.setCursor(c.maxrow() - 2, 1);
				c.print("Invalid option. Enter a valid option: ");
			} // end error trap

			// Change colour scheme
			c.setTextBackgroundColor(Color.black);
			c.setTextColor(Color.green);

			// Clear message line
			c.setCursor(c.maxrow() - 1, 1);
			c.println("");

			// Option selection

			// If option [1]
			if (option == '1') {
				// If pageCount is 1, notify user
				if (pageCount == 1) {
					c.setCursor(c.maxrow() - 1, 1);
					c.print("Page 1");
				}
				// If pageCount is between 1 and 5, go back one page
				else if (pageCount > 1 && pageCount < 5) {
					c.setCursor(c.maxrow() - 1, 1);
					c.print("Page " + (pageCount - 1));
					list(pageCount - 1);
					pageCount--;
				} // end if
			} // end option [1]

			// If option [2]
			else if (option == '2') {
				// If pageCount is 5, notify user
				if (pageCount == 4) {
					c.setCursor(c.maxrow() - 1, 1);
					c.print("Page 4");
				}
				// If pageCount < 4, goto next page
				else if (pageCount < 4) {
					c.setCursor(c.maxrow() - 1, 1);
					c.print("Page " + (pageCount + 1));
					list(pageCount + 1);
					pageCount++;
				} // end if
			} // end option [2]

			// If option 'D'
			else if (option == 'D' || option == 'd') {

				// If count is not 0
				if (count > 0) {
					// Ask user which entry they want to select
					c.setCursor(c.maxrow() - 1, 1);
					c.print("Which entry do you want to select?: ");
					while (true) {
						index = c.readInt();
						if (index > 0 && index <= count)
							break;
						c.setCursor(c.maxrow() - 1, 1);
						c.print("Invalid number. Enter a valid reference number from the list: ");
					} // end error trap

					// Clear list
					clearBlock(3, 26);

					// Show details of entry index - 1
					showEntry(index - 1);

					// Prompt user to press any key to get back to list
					c.setCursor(c.maxrow() - 1, 1);
					c.println("");
					c.setCursor(c.maxrow() - 1, 1);
					c.print("Press any key to return to list");
					c.getChar();
					list(pageCount);

				} else if (count == 0) {
					c.setCursor(c.maxrow() - 1, 1);
					c.print("There are no entries to show.");
				} // end if
			} // end option 'D'

			// If option 'R'
			else if (option == 'R' || option == 'r') {

				// If count is not 0
				if (count > 0) {
					// Ask user which entry is to be deleted
					c.setCursor(c.maxrow() - 1, 1);
					c.print("Which entry do you want to delete?: ");
					while (true) {
						index = c.readInt();
						if (index > 0 && index <= count)
							break;
						c.setCursor(c.maxrow() - 1, 1);
						c.print("Invalid number. Enter a valid reference number from the list: ");
					} // end error trap

					// Ask for confirmation
					c.setCursor(c.getMaxRows() - 1, 1);
					c.println("");
					c.setCursor(c.getMaxRows() - 1, 1);
					c.print("Are you sure you want to delete this entry (Y/n)?");
					while (true) {
						option = c.getChar();
						if (option == 'Y' || option == 'y' || option == 'N'
								|| option == 'n')
							break;
						c.setCursor(c.getMaxRows() - 1, 1);
						c.print("Press 'y' for yes or 'n' for no");
					} // end error trap

					// If user replies with yes, delete entry
					if (option == 'Y' || option == 'y') {
						// Delete selected entry
						delEntry(index - 1);
					} // end if

					// Update list
					list(pageCount);
				}
				// If count is 0, notify user
				else if (count == 0) {
					c.setCursor(c.maxrow() - 1, 1);
					c.print("There are no entries to delete.");
				}// end if
			} // end option 'R'

			// If option 'A'
			else if (option == 'A' || option == 'a') {

				// If count is 100, notify user that no entries can be added
				if (count == 100) {
					c.setCursor(c.getMaxRows() - 1, 1);
					c.print("You have reached a limit of 100 entries. No more can be added.");
				} // If count < 100
				else {
					// Clear list
					clearBlock(3, 26);

					// Call addEntry method
					addEntry();

					// Return back to list
					list(pageCount);
				} // end if

			} // end option 'A'

			// If option 'M'
			else if (option == 'M' || option == 'm') {

				// If count is not 0
				if (count > 0) {
					// Ask user which entry they want to select
					c.setCursor(c.maxrow() - 1, 1);
					c.print("Which entry do you want to modify?: ");
					while (true) {
						index = c.readInt();
						if (index > 0 && index <= count)
							break;
						c.setCursor(c.maxrow() - 1, 1);
						c.print("Invalid number. Enter a valid reference number from the list: ");
					} // end error trap

					// Show details of entry index - 1
					modEntry(index - 1);

					// Return to list
					list(pageCount);

				} else if (count == 0) {
					c.setCursor(c.maxrow() - 1, 1);
					c.print("There are no entries to modify.");
				} // end if
			} // end option 'M'

			// If option 'Q'
			else if (option == 'Q' || option == 'q') {

				// Reset matchCount
				matchCount = 0;

				// Ask for search string
				c.setCursor(c.maxrow() - 1, 1);
				c.print("Search: ");
				searchString = c.readLine();

				// Search for matches
				matchCount = findEntry(searchString);

				// If there are no matches, tell user and prompt to return
				c.setCursor(c.maxrow() - 1, 1);
				if (matchCount == 0) {
					c.print("The search for '"
							+ searchString
							+ "' returned 0 matches. Press any key to return to list");
					c.getChar();

					// Return to list
					list(pageCount);

				} // If there are matches, tell user the number of matches
				else {
					c.print("The search for '" + searchString + "' returned "
							+ matchCount + " matches.");
				} // end if

			} // end option 'Q'

			// If option 'S'
			else if (option == 'S' || option == 's') {

				// Ask for confirmation
				c.setCursor(c.getMaxRows() - 1, 1);
				c.println("");
				c.setCursor(c.getMaxRows() - 1, 1);
				c.print("Are you sure you want to save changes and quit (Y/n)?");
				while (true) {
					option = c.getChar();
					if (option == 'Y' || option == 'y' || option == 'N'
							|| option == 'n')
						break;
					c.setCursor(c.getMaxRows() - 1, 1);
					c.print("Press 'y' for yes or 'n' for no");
				} // end error trap

				// If user replies with yes, save changes to addresses.txt and
				// exit loop
				if (option == 'Y' || option == 'y') {
					writeFile();
					break;
				} // end if
			} // end option 'S'

			// If option '?'
			else {
				// Load help window, page 1
				help(1);
			} // end option '?'

		} // end loop
		
		// If option is save & quit, close window
		c.close();
		
	} // main method
} // AddressBook class