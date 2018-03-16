//*************************************************************************************************
//
// 	SumEvens.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	[[[ ENTER DESCRIPTION HERE ]]]
//
//*************************************************************************************************

package Assignment7;

import java.util.Scanner;

public class SumEvens {

	private static Scanner scanner = new Scanner(System.in);
	private static int sum = 0;
	
	public static void main (String[] args) {
		
		System.out.print("Enter a positive integer: ");
	
		//Input value
		int value = scanner.nextInt();
		scanner.close();
		
		//Handle <2 error
		if (value < 2) {
			System.out.println("The value must be greater >= 2.");
			return;
		}
		
		//add up values
		for (int i = 2; i <= value; i+=2) {
				sum += i;
		}
		
		//Output results
		System.out.println(
				"The sum of the even integers from 2 to " +
				value + " is " + sum
		);
	
	}
	
}
