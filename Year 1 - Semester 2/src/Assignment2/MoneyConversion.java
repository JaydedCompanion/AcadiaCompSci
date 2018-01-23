//*************************************************************************************************
//
// 	MoneyConversion.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Takes the user's input (which is >=0) and outputs it in a human-legible format.
//
//*************************************************************************************************

package Assignment2;

import java.util.Scanner;

public class MoneyConversion {
	
	public static void main (String[] params) {
		
		//Get user input
		System.out.print("Enter monetary amount:\n$");
		double money = FetchUserInput();
		//Find amount per each type of bill
		int tenBills = ((int)money) / 10;
		int fiveBills = ((int)(money % 10)) / 5;
		int oneBills = (((int)money % 10) % 5);
		
		//Convert the number after the decimal point into its own integer
		//Example 42.53 -> 53
		int cents = (int)((money - Math.floor(money)) * 100);
		//Find amount per each type of coin
		int quarters = cents / 25;
		int dimes = ((int)cents % 25) / 10;
		int nickels = ((int)(cents % 25) % 10) / 5;
		int pennies = ((int)((cents % 25) % 10) % 5);
		
		//Print the output
		System.out.println(GenerateHumanOutput(tenBills, fiveBills, oneBills, quarters, dimes, nickels, pennies));
	
	}
	
	//Gets user input via scanner and returns as a double
	public static double FetchUserInput () {
	
		//Initialize Scanner
		Scanner scanner = new Scanner(System.in);
		//Fetch next user-inputted double
		double userIn = scanner.nextDouble();
		//Close the scanner to avoid leaks
		scanner.close();
		//Return the scanner input
		return userIn;
	
	}
	
	//Generates a string based on the number of bills of each kind
	//This method will automatically use "bill"/"bills" depending on whether the amount is 1
	public static String GenerateHumanOutput (int tens, int fives, int ones, int quarters, int dimes, int nickels, int pennies) {
	
		String comp = "\nThat's equivalent to:\n";
		
		//Dollars
		comp += tens + " ten dollar bill" + ((tens == 1) ? "\n" : "s\n");
		comp += fives + " five dollas bill" + ((fives == 1) ? "\n" : "s\n");
		comp += ones + " one dollar bill" + ((ones == 1) ? "\n" : "s\n");
		//Cents
		comp += quarters + " quarter" + ((quarters == 1) ? "\n" : "s\n");
		comp += dimes + " dime" + ((dimes == 1) ? "\n" : "s\n");
		comp += nickels + " nickel" + ((nickels == 1) ? "\n" : "s\n");
		comp += pennies + " penn" + ((pennies == 1) ? "y\n" : "ies\n");
		
		return comp;
		
	}
	
}
