/**	
* FloorType
*
* @author Conor Dunne (65950DUN)
* @date 03/22/13
*/

// The FloorType class
import java.awt.*;

public class FloorType
{
    // Declare protected variables
	protected String name;
	protected int softness;
	protected double cost;
	
	//Blank constructor
	public FloorType () {
	} // Blank constructor
	
	// Default constructor
	public FloorType (String name, int softness, double cost) {
		this.name = name;
		this.softness = softness;
		this.cost = cost;
	} // Default constructor
	
	// Other methods of the FloorType class
	
	// Setters
	
	public void setName (String name) {
		this.name = name;
	} // void setName (String)
	
	public void setSoftness (int softness) {
		this.softness = softness;
	} // void setSoftness (int)
	
	public void setCost (double cost) {
		this.cost = cost;
	} // void setCost (double)
	
	// Getters
	
	public String getName () {
		return this.name;
	} // String getName ()
	
	public int getSoftness () {
		return this.softness;
	} // int getSoftness ()
	
	public double getCost () {
		return this.cost;
	} // double getCost ()
	
} // FloorType class
