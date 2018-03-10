//*************************************************************************************************
//
// 	CountDigits.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Loops through each digit in an integer and counts odd, even, and zero digits
//
//*************************************************************************************************

package Assignment6;

import java.util.Scanner;

public class CountDigits {

	private static Scanner scanner = new Scanner(System.in);
	
	private static int input;
	private static int length;
	private static int zeros;
	private static int evens;
	private static int odds;
	
	public static void main (String[] args) {
		
		//Initialize
		System.out.print("Enter an integer value:");
		input = scanner.nextInt();
		length = length(input);
		scanner.close();
		
		//Loop through digits, tally up odds, evens, zeros
		for (int i = 0; i < length; i ++) {
		
			int digit = getDigit(input, i);
			
			if (digit == 0)
				zeros ++;
			else
				if (digit % 2 == 0)
					evens ++;
				else
					odds ++;
		
		}
		
		//Print results
		System.out.println(output());
		
	}
	
	//Returns a digit from an integer given an index
	public static int getDigit (int input, int index)
			throws IndexOutOfBoundsException {
		
		//===== No Strings allowed? No problem =====//
		
		//Confirm index is within bounds
		if (index < 0 || index > length)
			throw new IndexOutOfBoundsException (
				"\nIndex " + index + " if out of range.\n"+
				"Max: " + length + "\t Min: " + 0
			);
		
		input = Math.abs(input);
		int multi = Math.abs((int)Math.pow(10, length - index - 1));
		int mod = (int) Math.round(Math.floor(input / multi));
		mod = (int) Math.round((mod/(double)10-Math.floor(mod/(double)10))*10);
		
		return mod;
		
	}
	
	//Use math magic to get the length of the int.
	private static int length (int input) {
		return (int) (Math.log10(Math.abs(input) + 1) + 1);
	}
	
	//Converts variables to a human-readable string
	public static String output () {
		
		return 	"\nZero digits:\t" + zeros +
				"\nEven digits:\t" + evens +
				"\nOdd digits:\t\t" + odds;
	
	}
	
}
