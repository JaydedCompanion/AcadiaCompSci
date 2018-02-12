//******************************************************************************
//
// 	LuckyNumber.java			Author: Juan Callejas		ID:100143996
//
//	Handles methods that are called in the LuckyNumberTester class
//
//******************************************************************************

import java.util.Random;

public class LuckyNumber {
	
	private int Number = 0;
	private Random random = new Random();
	
	public LuckyNumber (int number) {
	
		Number = number;
	
	}
	
	public String toString () {
	
		return Integer.toString(Number);
	
	}
	
	public void setX (int x) {
		
		Number = x;
		
	}
	
	public int getX () {
		
		return Number;
		
	}
	
	public void incX () {
		
		Number ++;
		
	}
	
	public void decX () {
		
		Number --;
		
	}
	
	public void zeroAllX () {
	
		Number = 0;
	
	}
	
	public void randomX (double max) {
	
		Number = Math.round (random.nextFloat() * (float) max);
	
	}
	
	public void zeroLastX () {
	
		if (Number > 0)
			Number = (int) ((Math.floor (Number * 0.1)) * 10);
		else
			Number = (int) ((Math.ceil (Number * 0.1)) * 10);
	
	}
	
}
