// The "ObjectMaker" class.
import java.awt.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import hsa.Console;

public class ObjectMaker
{
    static Console c;           // The output console

    /**
     * Convert first character of string to uppercase
     *
     * @param text String to have first character corrected.
     * @return String Same string as was entered except with first character capitalized (if necessary)
     */
    public static String upperFirst (String text)
    {
	// return the text with first character capitalized + rest of string
	return text.substring (0, 1).toUpperCase () + text.substring (1);
    } // String upperFirst (String)


    /**
     * Wait for user to press y or n
     *
     * @return char Either y or n
     */
    public static char YorN ()
    {
	char key;
	do
	{
	    key = c.getChar ();
	}
	while (key != 'y' && key != 'n');

	return key;
    } // char YorN()


    /**
     * Main method
     */
    public static void main (String[] args) throws IOException
    {
	c = new Console ();
	String tab = "    ";
	String objName;
	int numVars, varTypeChoice;
	char overwrite = 'y';

	// declare array, in case I want to add to it in the future
	final String VAR_TYPE[] = {"String", "int", "double", "char"};

	// error trap to ensure file doesn't get overwritten
	// (ask user if they want to overwrite it)
	do
	{
	    c.clear ();
	    c.print ("Enter name of object: ");
	    objName = c.readLine ();

	    // checks to see if you type in the object name without a first
	    // character capitalized, and if need be convert it.
	    if (objName.charAt (0) >= 'a' && objName.charAt (0) <= 'z')
	    {
		objName = upperFirst (objName);
		c.setTextColor (Color.RED);
		c.print (objName);
		c.setTextColor (Color.BLACK);
		c.println (" assumed.");
	    } // end if

	    // if the file exists it will ask user if they want to overwrite
	    if (new File (objName + ".java").exists () == true)
	    {
		c.println ("\nFile already exists. Do you want to overwrite?");
		overwrite = YorN ();
	    }

	} // end while
	while (overwrite == 'n');

	// get number of variables
	c.print ("\nEnter number of variables your object needs: ");
	numVars = c.readInt ();

	// declare arrays to contain the names and types of
	// the variables which make up your object
	String[] varName = new String [numVars];
	String[] varType = new String [numVars];

	// display the list of variable types for the user
	for (int i = 0 ; i < VAR_TYPE.length ; ++i)
	{
	    c.print (" " + (i + 1) + " - " + VAR_TYPE [i]);
	    if (i < VAR_TYPE.length - 1)
		c.print (";");
	    else
		c.println ("\n");
	} // end for

	// Ask the user for the variable names and types
	for (int i = 0 ; i < numVars ; ++i)
	{
	    c.print ("\nEnter variable type: ");
	    while (true)
	    {
		varTypeChoice = c.readInt ();
		if (varTypeChoice > 0 && varTypeChoice <= VAR_TYPE.length)
		    break;
		c.println ("Error! Number out of range. Try again.\n");
	    } // end while

	    varType [i] = VAR_TYPE [varTypeChoice - 1];

	    // NOTE TO STUDENTS: If I wasn't concerned about error trapping
	    // I would've been able to use this nifty piece of coding. Notice
	    // where the c.readInt() is? ---. (remember, it's just a function)
	    //                              V
	    // varType [i] = VAR_TYPE [c.readInt () - 1];

	    c.print ("Enter variable name: ");
	    varName [i] = c.readLine ();

	} // end for

	// open the file
	PrintWriter out = new PrintWriter (new FileWriter (objName + ".java"));

	// write the information to the file
	out.println ("/**");
	out.println (" *");
	out.println (" * The " + objName + " class");
	out.println (" *");
	out.println (" * Generated using Mr. Milardovic's ObjectMaker");
	out.println (" *");

	// display date in time in an appropriate formate
	out.println (" * Created: " + new SimpleDateFormat ("EEEE, MMMM F, yyyy, k:mm a").format (new Date ()));
	out.println (" *");
	out.println (" */");
	out.println ("");

	// for most objects, usually all you need is to import java.awt.*
	out.println ("import java.awt.*;");
	out.println ("");
	out.println ("public class " + objName);
	out.println ("{");

	// write protected variables
	for (int i = 0 ; i < numVars ; ++i)
	{
	    out.println (tab + "protected " + varType [i] + " " + varName [i] + ";");
	}
	out.println ("");

	// create contructor, asusming you need to pass in all the variables
	out.println (tab + "// Constructor method");
	out.print (tab + "public " + objName + " (");

	for (int i = 0 ; i < numVars ; ++i)
	{
	    out.print (varType [i] + " " + varName [i]);
	    if (i < numVars - 1)
		out.print (", ");
	} // end for

	out.println (")");
	out.println (tab + "{");
	for (int i = 0 ; i < numVars ; ++i)
	{
	    out.println (tab + tab + "this." + varName [i] + " = " + varName [i] + ";");
	} // end for
	out.println (tab + "}");
	out.println ("");

	for (int i = 0 ; i < numVars ; ++i)
	{
	    out.println (tab + "public void set" + upperFirst (varName [i]) + " (" + varType [i] + " " + varName [i] + ")");
	    out.println (tab + "{");
	    out.println (tab + tab + "this." + varName [i] + " = " + varName [i] + ";");
	    out.println (tab + "} // void set" + upperFirst (varName [i]) + " (" + varType [i] + ")");
	    out.println ("");
	    out.println (tab + "public " + varType [i] + " get" + upperFirst (varName [i]) + " ()");
	    out.println (tab + "{");
	    out.println (tab + tab + "return this." + varName [i] + ";");
	    out.println (tab + "} // " + varType [i] + " get" + upperFirst (varName [i]) + " ()");
	    out.println ("");
	} // end for
	out.println ("");
	out.println ("");
	out.println ("} // end " + objName + " class");

	out.close ();

	c.println ("\n\n\n\nDone!");

	c.getChar ();
	System.exit (0);
    } // main method
} // ObjectMaker class


