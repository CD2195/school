/**
 *
 * The AddressEntry class
 *
 * Generated using Mr. Milardovic's ObjectMaker
 *
 * Created: Wednesday, April 3, 2013, 13:00 PM
 *
 */

import java.awt.*;

public class AddressEntry {
	protected String firstName = "";
	protected String lastName = "";
	protected String phoneNumber = "";
	protected String streetName = "";
	protected String houseName = "";
	protected String cityName = "";
	protected String province = "";
	protected String postalCode = "";
	protected String country = "";
	protected String email = "";
	protected boolean delete;

	// Constructor method
	public AddressEntry(String firstName, String lastName, String phoneNumber,
			String streetName, String houseName, String cityName,
			String province, String postalCode, String country, String email,
			boolean delete) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.streetName = streetName;
		this.houseName = houseName;
		this.cityName = cityName;
		this.province = province;
		this.postalCode = postalCode;
		this.country = country;
		this.email = email;
		this.delete = delete;
	}
	
	public AddressEntry(String firstName, String lastName, boolean delete) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.delete = delete;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	} // void setFirstName (String)

	public String getFirstName() {
		return this.firstName;
	} // String getFirstName ()

	public void setLastName(String lastName) {
		this.lastName = lastName;
	} // void setLastName (String)

	public String getLastName() {
		return this.lastName;
	} // String getLastName ()

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	} // void setPhoneNumber (String)

	public String getPhoneNumber() {
		return this.phoneNumber;
	} // String getPhoneNumber ()

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	} // void setStreetName (String)

	public String getStreetName() {
		return this.streetName;
	} // String getStreetName ()

	public void setHouseName(String houseName) {
		this.houseName = houseName;
	} // void setHouseName (String)

	public String getHouseName() {
		return this.houseName;
	} // String getHouseName ()

	public void setCityName(String cityName) {
		this.cityName = cityName;
	} // void setCityName (String)

	public String getCityName() {
		return this.cityName;
	} // String getCityName ()

	public void setProvince(String province) {
		this.province = province;
	} // void setProvince (String)

	public String getProvince() {
		return this.province;
	} // String getProvince ()

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	} // void setpostalCode (String)

	public String getPostalCode() {
		return this.postalCode;
	} // String getpostalCode ()

	public void setCountry(String country) {
		this.country = country;
	} // void setCountry (String)

	public String getCountry() {
		return this.country;
	} // String getCountry ()

	public void setEmail(String email) {
		this.email = email;
	} // void setEmail (String)

	public String getEmail() {
		return this.email;
	} // String getEmail ()
	
	public void setDelete (boolean delete) {
		this.delete = delete;
	} // void setDelete (boolean)
	
	public boolean getDelete () {
		return this.delete;
	} // boolean getDelete ()

} // end AddressEntry class
