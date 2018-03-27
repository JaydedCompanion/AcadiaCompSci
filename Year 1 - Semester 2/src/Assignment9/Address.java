//*************************************************************************************************
//
// 	Address.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Address object, holds address, city, state, zip. Can be locked.
//	Complete clone from the slides.
//
//*************************************************************************************************

package Assignment9;

public class Address implements Lock {
	
	private String streetAddress, city, state;
	private long zipCode;
	
	private static boolean locked = false;
	
	//-----------------------------------------------------------------
	//  Constructor: Sets up this address with the specified data.
	//-----------------------------------------------------------------
	public Address(String street, String town, String st, long zip) {
		
		streetAddress = street;
		city = town;
		state = st;
		zipCode = zip;
	}
	
	@Override
	public String toString () {
		if (locked)
			return this.getClass().getSimpleName() + " is locked.";
		else
			return	streetAddress + "\n" +
					city+", "+state+" "+zipCode;
	}
	
	@Override
	public void lock() {
		locked = true;
	}
	
	@Override
	public void unlock() {
		locked = false;
	}
	
}