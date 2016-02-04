// The "DrawMoon" class.
// Draws a moon at centre of console window
// of radius 60 pixels and colour green.
import java.awt.*;
import hsa.Console;

public class DrawMoon {
	
	// The output console
	static Console c;

	public static void main (String[]args) {
		
		c = new Console ();
		
		Turtle t;
		t = new Turtle (c);
		t.setColor(Color.green);

		for(int square = 1; square <= 36; square ++) {
			for (int side = 1; side <= 4; side ++) {
				t.move(60);
				t.turnRight(90);
			}
			t.turnRight(10);
		}
	} // main method
} // DrawMoon class

