//*************************************************************************************************
//
// 	Fraction.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Takes two ints from user and prints out the quotient as a double
//
//*************************************************************************************************

package Assignment2;

import java.util.Scanner;

public class Fraction {
	
	//Initialize Scanner
	public static Scanner scanner = new Scanner(System.in);

	public static void main (String[] Params) {
	
		int numerator = FetchUserInput("Enter Numerator:	\t");
		int denominator = FetchUserInput("Enter Denominator:\t");
		
		System.out.println("\nDecimal equivalent of " + numerator + "/" + denominator + " is: " + (((double)numerator)/denominator));
		
		scanner.close();
	
	}
	
	public static int FetchUserInput (String prompt) {
	
		//Print user prompt
		System.out.print(prompt);
		//Fetch next user-inputted double
		int userIn = scanner.nextInt();
		//Return the scanner input
		return userIn;
	
	}
	
}
