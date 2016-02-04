// The "FatTurtle" class.
import java.awt.*;
import hsa.Console;



public class FatTurtle extends Turtle
{ //new var
    protected int lineWidth;

    //1 version of constructor
    public FatTurtle (Console c)
    {
	super (c);
	//default settings for other
	lineWidth = 1;
    } //constructor


    //add new method to set LineWidth
    public void setLineWidth (int newWidth)
    {
	lineWidth = newWidth;
    } //setLineWidth method


    //draw filled ball
    protected void drawBall (int xc, int yc, int radius)
    {
	int diameter = radius * 2;
	int x = xc - radius;
	int y = yc - radius;
	c.fillOval (x, y, diameter, diameter);
    } //drawBall method


    //add drawFatLine
    protected void drawFatLine (int x1, int y1, int x2, int y2)
    {
	final double LEN = Math.sqrt (((x2 - x1) * (x2 - x1)) + ((y2 - y1) * (y2 - y1)));
	final double SINA = (y2 - y1) / LEN;
	final double COSA = (x2 - x1) / LEN;
	final int RADIUS = (lineWidth / 2) + 1;
	final double DX = RADIUS * COSA / 2;
	final double DY = RADIUS * SINA / 2;
	//set postion
	double xpos = x1;
	double ypos = y1;

	do
	{
	    drawBall ((int) Math.round (xpos), (int) Math.round (ypos), RADIUS);
	    xpos += DX;
	    ypos += DY;

	}
	while (Math.sqrt ((x2 - xpos) * (x2 - xpos) + (y2 - ypos) * (y2 - ypos)) >= RADIUS / 2);
	//end do

    } //drawFatLine method


    //overrides the move method of Turtle class
    public void move (int distance)
    {
	double rAngle = angle * Math.PI / 180;
	final int newx = (int) Math.round (x + Math.cos (rAngle) * distance);
	final int newy = (int) Math.round (y + Math.sin (rAngle) * distance);
	if (showing)
	{
	    c.setColor (clr);
	    if (lineWidth == 1)
		c.drawLine (x, y, newx, newy);
	    else
		drawFatLine (x, y, newx, newy);
	}
	x = newx;
	y = newy;
    } //move method
} // main method


