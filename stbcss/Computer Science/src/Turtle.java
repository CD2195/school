// The Turtle class
import java.awt.*;
import hsa.Console;

public class Turtle
{
	protected Console c;
	protected int x, y, angle;
	protected boolean showing = true;
	protected Color clr = Color.black;
	
	// Constructor for default initial values of position and angle.
	public Turtle (Console c) {
		this.c = c;
		x = c.maxx () / 2;
		y = c.maxy () / 2;
		angle = 0;
	} // Default Turtle Constructor.
	
	// Alternate Constructor.
	public Turtle (Console c, int x, int y, int angle) {
		this.c = c;
		this.x = y;
		this.y = y;
		this.angle = angle;
	} // Alternate Constructor
	
	// Other methods of Turtle class.
	
	public void setColor (Color clr) {
		this.clr = clr;
	} // setColor method
	
	public void setPosition (int x, int y) {
		this.x = x;
		this.y = y;
	} // setPosition method
	
	public void setAngle (int angle) {
		this.angle = angle;
	} // setAngle method
	
	public void turnLeft (int turnAngle) {
		angle += turnAngle;
		angle = angle % 360;
	} // turnLeft method
	
	public void turnRight (int turnAngle) {
		angle += turnAngle;
		angle = angle % 360;
	} // turnRight method
	
	public void showTrace () {
		showing = true;
	} // showTrace method
	
	public void hideTrace () {
		showing = false;
	} // hideTrace method
	
	public void move (int distance) {
		int newx, newy;
		double rAngle = (angle * Math.PI) / 180;
		newx = (int) Math.round (x + Math.cos(rAngle) * distance);
		newy = (int) Math.round (y + Math.sin(rAngle) * distance);
		if (showing) {
			c.setColor(clr);
			c.drawLine (x, y, newx, newy);
		}
		x = newx;
		y = newy;
	} // move method
} // Turtle class
