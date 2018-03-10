//*************************************************************************************************
//
// 	ValidatePalindrome.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Reads a file (alphanumeric chars only) and checks if it is a palindrome
//
//*************************************************************************************************

package Assignment6;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ValidatePalindrome {
	
	private static Scanner scanner = new Scanner(System.in);
	
	//Set to true to print debugging info
	private static final boolean debug = false;
	private static final String isPalindrome = "Good News! It is a palindrome!";
	private static final String noPalindrome = "It is not a palindrome!";
	
	public static void main (String[] args) throws IOException{
		
		//Prompt user for file name, append ".txt" extension, close scanner.
		System.out.print ("Please enter a file name:\t");
		String filePath = scanner.next() + ".txt";
		File file = new File(filePath);
		String contents = "";
		scanner.close();
		
		try {
			//Recycle scanner, use file instead of System.in
			scanner = new Scanner(file);
			//Loop through lines, append alphanum chars only to contents string
			String line = "";
			while (scanner.hasNextLine()) {
				line = scanner.nextLine();
				for (int i = 0; i < line.length(); i++) {
					char r = line.charAt(i);
					if (Character.isDigit(r) || Character.isLetter(r))
						contents += Character.toUpperCase((char) r);
				}
			}
			scanner.close();
		} catch (Exception e) {
			System.out.println(
					"No file found at \"" +
					file.getAbsolutePath() + "\""
			);
			return;
		}
		
		for (int i = 0; i < contents.length()/2; i++) {
			
			char a = charAt(contents, i);
			char b = charAt(contents, -(i+1));
			
			if (a != b) {
				if (debug)
					System.out.println(
							"| " + a + " ≠ " + b + " |\n" +
							"× ^   ^ ×\n× ERROR ×\n× × × × ×"
					);
				System.out.print(noPalindrome);
				return;
			} else
				if (debug)
					System.out.println("| " + a + " = " + b + " |");
		
		}
		if (debug)
			System.out.println(
					"+ - - - +\n+ DONE! +\n+ + + + +"
			);
		System.out.print(isPalindrome);
		
	}
	
	public static char charAt (String str, int i) {
		
		//Quick and easy implementation of Python's negative index abilities
		if (i < 0)
			i = str.length() - (Math.abs(i));
		
		return str.charAt(i);
	
	}
	
}
