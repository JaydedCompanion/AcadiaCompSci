//*************************************************************************************************
//
// 	HockeyStats.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Prints out feedback based on a player's stats
//
//*************************************************************************************************

package Lab7;

import java.util.Scanner;

public class HockeyStats {

	private static Scanner scanner = new Scanner(System.in);
	
	private static int goals;
	private static int assists;
	private static int games;
	private static int shots;
	
	public static void main (String[] args) {
	
		//Gather inputs
		goals = prompt("How many goals do you have?");
		assists = prompt("How many assists do you have?");
		games = prompt("How many games have you played?");
		shots = prompt("How many shots have you taken on net?");
		
		System.out.print(output());
		
		//Print out a quote depending on the average points
		if (avgPoints() >= 1.5)
			System.out.println("You are a superstar");
		else if (avgPoints() >= 1)
			System.out.println("You are really really good");
		else if (avgPoints() > 0.8)
			System.out.println("You are a really solid player");
		else
			System.out.println("Pick it up, friend");
		
		//Print a tally of goals, with an asterisk every 5th goal
		for (int i = 1; i <= goals; i ++) {
			if (i % 5 == 0)
				System.out.print("*");
			else
				System.out.print("!");
		}
		
	}
	
	//Asks for user input based on prompt
	public static int prompt (String prompt) {
	
		System.out.println(prompt);
		System.out.print("> ");
		return scanner.nextInt();
	
	}
	
	//Converts stats to string format
	public static String output () {
		
		return	"You have scored " + (goals + assists) +
				" points, you shooting percentage is " + shotPercent() +
				" and you points per game is " + avgPoints() + "\n";
	
	}
	
	//Calculates a player's average points per game
	public static double avgPoints() {
	
		return decimalPlaces ((goals + assists)/(double)games, 2);
	
	}
	
	//Calculates the number of successful shots a player has made
	public static double shotPercent () {
		
		return decimalPlaces(goals/(double)shots, 2);
		
	}
	
	//Rounds a double to "decimals" number of decimal places
	public static double decimalPlaces (double val, int decimals) {
	
		int multi = (int) Math.pow(10, decimals);
		val *= multi;
		val = Math.round(val);
		return val / multi;
	
	}
	
}
