//*************************************************************************************************
//
// 	SquareCalculations.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Calculates the perimeter and area of a square when given the length of one of its sides
//
//*************************************************************************************************

package Assignment2;

import java.util.Scanner;

public class SquareCalculations {
	
	public static void main (String[] params) {
	
		System.out.print("Enter the length of a square's side: ");
		
		double length = FetchUserInput();
	
		double perimeter = length * 4;
		double area = Math.pow(perimeter, 2);
		
		System.out.println("Perimeter: " + perimeter + "\nArea: " + area);
		
		System.out.println((length < 20) ? "\n\n\nASCII Visualization:\n\n" + GenerateAsciiSquare((int)length, (int)length) : "\n\n\nSquare size is too large to generate ASCII");
		
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
	
	// Generates ASCII:
	//   ╔ ══ ══ ══ ╗
	//   ║ ░ ░ ░ ║
	//   ║ ░ ░ ░ ║
	//   ║ ░ ░ ░ ║
	//   ╚ ══ ══ ══ ╝
	public static String GenerateAsciiSquare (int width, int height) {
		
		String square = "";
		
		width ++;
		height ++;
	
		for (int i = 0; i <= height; i++) {
			for (int j = 0; j <= width; j++) {
				String append = "";
				//First Row
				if (i == 0 && j == 0)
					append = "╔ ";
				else if (i == 0 && j < width)
					append = "══ ";
				else if (i == 0 && j == width)
					append = "╗\n";
				//Middle Rows
				if (i > 0 && i < height && j == 0)
					append = "║ ";
				if (i > 0 && i < height && j > 0 && j < width)
					append = "░ ";
				if (i > 0 && i < height && j > 0 && j == width)
					append = "║\n";
				//Last Row
				if (i == height && j == 0)
					append = "╚ ";
				if (i == height && j > 0 && j < width)
					append = "══ ";
				if (i == height && j > 0 && j == width)
					append = "╝\n";
				square += append;
			}
		}
		
		return square;
	
	}
	
}
