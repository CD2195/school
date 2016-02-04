/**
* Program Name
* Description of your program which
* should be written in proper grammar
* using sentences.
*
* @author Conor Dunne (65950DUN)
* @date mm/dd/yy
*/

// The WordWrap class
import java.awt.*;
import hsa.Console;

public class WordWrap
{
    // The output console
    static Console c;

    public static void main (String[] args)
    {
	
    	c = new Console ();
    	
    	int ww =12;
    	int pos = 12;
    	
    	String word = "Potatoes are essential to Irish culture and we would die without them. Word Wrap that.";
    
    	
    	while (word.length() >= ww) {
    		if (word.charAt(pos) != ' ') {
    			pos = pos - 1;
    		}
    		else {
    		    c.println(word.substring(0, pos));
    		    word = word.substring(pos + 1, word.length());
    		    pos = ww;
    		}
    	}
    	c.println(word);

    } // main method
} // WordWrap class
