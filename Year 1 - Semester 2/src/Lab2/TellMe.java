//*************************************************************************************************
//
// 	TellMe.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Prompts user for data and then prints out results
//
//*************************************************************************************************

package Lab2;

import java.util.Scanner;

public class TellMe {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main (String[] params) {
		
		//Fetch user input
		String name = Prompt("Name:\t");
		int age = Integer.parseInt(Prompt("Age:\t"));
		int years = Integer.parseInt(Prompt("Years:\t"));
		
		//Print the final result and close the scanner
		System.out.println(GenerateOutput(name, age, years));
		scanner.close();
	
	}
	
	//Prints out the prompt and returns the user's response
	public static String Prompt (String prompt) {
	
		System.out.print(prompt);
		
		return scanner.next();
	
	}
	
	//Takes in the variables and places them in a string
	public static String GenerateOutput (String name, int age, int years) {
	
		String comp = "\nI think your name is " + name + "\n";
		comp += "Your age is probably " + age + "\n";
		comp += "Your age in " + years + " years will be approximately " + (age + years) + "\n";
	
		return comp;
		
	}
	
}
