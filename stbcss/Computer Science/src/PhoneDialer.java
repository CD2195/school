// The "PhoneDialer" class.
import java.applet.*;
import java.awt.*;

public class PhoneDialer extends Applet
{
    // Place instance variables here
    Label brandName, status;
    TextField viewWindow;
    Button n0, n1, n2, n3, n4, n5, n6, n7, n8, n9, star, num, send, back, end;
    String redialNum = "";


    public void init ()
    {
	// Place the body of the initialization method here
	brandName = new Label ("CroBerry");
	brandName.setAlignment (1);
	brandName.setFont (new Font ("Serif", 3, 24));

	viewWindow = new TextField (10);
	viewWindow.setFont (new Font ("Dialog", 1, 16));
	//viewWindow.setAlignment(2);

	status = new Label ();

	n0 = new Button (" 0 ");
	n1 = new Button (" 1 ");
	n2 = new Button (" 2 ");
	n3 = new Button (" 3 ");
	n4 = new Button (" 4 ");
	n5 = new Button (" 5 ");
	n6 = new Button (" 6 ");
	n7 = new Button (" 7 ");
	n8 = new Button (" 8 ");
	n9 = new Button (" 9 ");

	star = new Button (" * ");
	num = new Button (" # ");

	send = new Button ("SND");
	back = new Button ("DEL");
	end = new Button ("END");

	// set canvas layout to BorderLayout
	setLayout (new BorderLayout ());

	// create north panel
	Panel north = new Panel ();

	// layout north panel as BorderLayout
	north.setLayout (new BorderLayout ());

	// add fields to north panel
	north.add ("North", brandName);
	north.add ("Center", viewWindow);
	north.add ("South", status);

	// create south panel
	Panel south = new Panel ();

	// layour south panel as GridLayout
	south.setLayout (new GridLayout (5, 3, 5, 5));

	// add buttons to south panel grid
	south.add (send);
	south.add (back);
	south.add (end);
	south.add (n1);
	south.add (n2);
	south.add (n3);
	south.add (n4);
	south.add (n5);
	south.add (n6);
	south.add (n7);
	south.add (n8);
	south.add (n9);
	south.add (star);
	south.add (n0);
	south.add (num);

	// add north and south panels to canvas
	add ("North", north);
	add ("South", south);

    } // init method


    public boolean action (Event e, Object o)
    {
	status.setText ("");

	if (e.target == n1)
	{
	    viewWindow.setText (viewWindow.getText () + "1");
	}
	else if (e.target == n2)
	{
	    viewWindow.setText (viewWindow.getText () + "2");
	}
	else if (e.target == n3)
	{
	    viewWindow.setText (viewWindow.getText () + "3");
	}
	else if (e.target == n4)
	{
	    viewWindow.setText (viewWindow.getText () + "4");
	}
	else if (e.target == n5)
	{
	    viewWindow.setText (viewWindow.getText () + "5");
	}
	else if (e.target == n6)
	{
	    viewWindow.setText (viewWindow.getText () + "6");
	}
	else if (e.target == n7)
	{
	    viewWindow.setText (viewWindow.getText () + "7");
	}
	else if (e.target == n8)
	{
	    viewWindow.setText (viewWindow.getText () + "8");
	}
	else if (e.target == n9)
	{
	    viewWindow.setText (viewWindow.getText () + "9");
	}
	else if (e.target == n0)
	{
	    viewWindow.setText (viewWindow.getText () + "0");
	}
	else if (e.target == send)
	{
	    status.setText ("Calling " + viewWindow.getText () + "...");
	}
	else if (e.target == end)
	{
	    status.setText ("Call ended");
	    redialNum = viewWindow.getText ();
	    viewWindow.setText ("");
	}
	else if (e.target == star)
	{
	    viewWindow.setText (redialNum);
	}
	else if (e.target == back && viewWindow.getText ().length () > 0)
	{
	    viewWindow.setText
		(viewWindow.getText ().substring (0, viewWindow.getText ().length () - 1));
	}


	return true;
    } // boolean action (Event, Object)

    // places a border between the panels and the outer margins of the applet
    public Insets insets ()
    {
	return (new Insets (10, 10, 10, 10));
    }
} // PhoneDialer class


