//*************************************************************************************************
//
// 	GetPoints.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Calculates team score given wins, overtime wins, and overtime losses
//
//*************************************************************************************************

package Lab2;

import java.util.Scanner;

public class GetPoints {
	
	private static Scanner scanner = new Scanner(System.in);
	//Store how much each type of win/loss is worth
	private static final int worthWin = 3;
	private static final int worthOverWin = 2;
	private static final int worthOverLoss = 1;
	
	public static void main (String[] params) {
	
		//Fetch data from user
		int wins = Prompt("Wins:\t\t\t\t");
		int overWins = Prompt("Overtime wins:\t\t");
		int overLoss = Prompt("Overtime Losses:\t");
		
		//Prints out the result
		System.out.println(GenerateResults(wins, overWins, overLoss));
	
	}
	
	//Prints out the prompt and returns the user's response
	public static int Prompt (String prompt) {
		
		System.out.print(prompt);
		
		return scanner.nextInt();
		
	}
	
	//Generates and returns results
	public static String GenerateResults (int wins, int overWins, int overLoss) {
		
		//Calculate the score
		int score = (wins * worthWin) + (overWins * worthOverWin) + (overLoss * worthOverLoss);
		
		//Return the score
		return "\nYour team has " + score + " points.";
	
	}
	
}
