//*************************************************************************************************
//
// 	Counter.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Counter class stores a value and increases it with the click() method
//
//*************************************************************************************************

//package Assignment4;

public class Counter {

	private int count = 0;
	
	//Default constructor
	//Returns counter instance with count set to 0
	public Counter () {
		
		count = 0;
	
	}
	
	//Increases count by 1
	public void click () {
		
		count ++;
	
	}
	
	//Returns count value
	public int getCount () {
		
		return count;
		
	}
	
	//Resets count value to 0
	public void reset () {
	
		count = 0;
	
	}
	
	//Returns a string to represent this counter
	public String toString () {
	
		return Integer.toString(count);
	
	}
	
}
