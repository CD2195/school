/**
* Program Name
* Description of your program which
* should be written in proper grammar
* using sentences.
*
* @author Conor Dunne (65950DUN)
* @date mm/dd/yy
*/

// The BasicMethods class
import java.awt.*;
import hsa.Console;

public class BasicMethods
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
   
   
    public static int centerline (String text int line ) {
    	
    }
   	
    public static void main (String[] args)
    {
	
    	c = new Console ();

    	// Place your program here.  'c' is the output console



    } // main method
} // BasicMethods class
