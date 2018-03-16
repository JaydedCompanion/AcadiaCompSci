//*************************************************************************************************
//
// 	FileStats.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Reads a file and gathers various stats regarding its contents.
//  Also prints results in a fancy window 🆕
//
//*************************************************************************************************

package Assignment7;

import java.io.File;
import java.util.Scanner;

public class FileStats {
	
	private static int LineCount = 0;
	private static String shortestLine = "";
	private static String longestLine = "";
	private static String firstLine = "";
	private static int va;
	private static int ve;
	private static int vi;
	private static int vo;
	private static int vu;
	
	private static int boxWidth;
	
	public static void main (String[] args) {
		
		//Initialize file instance
		String filePath = "NorvigInputFile.txt";
		File file = new File(filePath);
		String contents = "";
		Scanner scanner = null;
		
		//Create the scanner from the file
		try {
			scanner = new Scanner(file);
		} catch (Exception e) {
			System.out.println("File not found.");
			System.out.println("File location: " + file.getAbsolutePath());
			return;
		}
		
		//Loop through every line of the file
		while (scanner.hasNextLine()) {
			
			contents = scanner.nextLine();
		
			LineCount ++;
			
			//If there's no shortest line declared set it's value to the
			//current line
			if (shortestLine.length() == 0) {
				shortestLine = contents;
				firstLine = contents;
			}
			
			//Depending on the line length, set the shortest/longest line vars
			if (contents.length() < shortestLine.length())
				shortestLine = contents;
			if (contents.length() > longestLine.length())
				longestLine = contents;
			
			//Lexicographical ordering
			int alphaOrder = 0;
			while (true) {
				
				if (alphaOrder > firstLine.length() - 1)
					break;
				if (alphaOrder > contents.length() - 1) {
					firstLine = contents;
					break;
				}
				//Make sure we compare same-case chars
				char a = Character.toUpperCase(contents.charAt(alphaOrder));
				char b = Character.toUpperCase(firstLine.charAt(alphaOrder));
				//If one of the characters comes first, update the firstLine
				//variable accordingly, and stop the loop
				if (a < b) {
					firstLine = contents;
					break;
				} else if (b < a) {
					break;
				}
				//If the characters are the same, check the next character
				alphaOrder++;
			}
			
			//Count the vowels of the current line
			for (int i = 0; i < contents.length(); i ++) {
				char c = contents.charAt(i);
				switch (c) {
					case 'a':
						va ++;
						break;
					case 'e':
						ve ++;
						break;
					case 'i':
						vi ++;
						break;
					case 'o':
						vo ++;
						break;
					case 'u':
						vu ++;
						break;
				}
			}
		}
		
		//Output results in a fancy window
		System.out.println(PipeWindow.IntoPipeBox(new String [] {
				"File Stats for \"" + filePath + "\"",
				"Line count:      " + LineCount,
				"Shortest line:   " + shortestLine,
				"Longest line:    " + longestLine,
				"First line:      " + firstLine,
				"═════════════",
				"Vowel counts:",
				"A:    " + va,
				"E:    " + ve,
				"I:    " + vi,
				"O:    " + vo,
				"U:    " + vu,
		}));
		
		scanner.close();
	
	}

}


//This class contains methods to generate a fancy output
class PipeWindow {
	
	//Given an array of strings, generate an ASCII-pipe-based window UI
	public static String IntoPipeBox (String[] contents) {
		
		int max = 0;
		String out = "";
		
		for (int i = 0; i < contents.length; i++)
			if (contents[i].length() > max)
				max = contents[i].length();
		
		out += IntoPipeHeader(contents[0], max);
		out += IntoPipeLine("", max);
		for (int i = 1; i < contents.length; i++)
			out += IntoPipeLine(contents[i], max - contents[i].length());
		out += IntoPipeLine("", max);
		out += PipeEnd (max);
		
		return out;
		
	}
	
	//Generates the header for the window
	private static String IntoPipeHeader (String str, int w) {
		
		return "╔" +
				new String(new char[str.length() + 2]).replace("\0","═") +
				"╗" +
				"\n║ " + str + " ╠" +
				new String(new char[w-(str.length()) + 7]).replace("\0","═") +
				"╗\n╠" +
				new String(new char[str.length() + 2]).replace("\0","═") +
				"╝" +
				new String(new char[w-(str.length()) + 7]).replace("\0"," ") +
				"║\n";
		
	}
	
	//Generates a single row of the window
	private static String IntoPipeLine (String str, int w) {
		
		String spacing = new String(new char[w + 5]).replace("\0", " ");
		
		return "║     " + str + spacing + "║\n";
		
	}
	
	//Generates bottom edge of window
	private static String PipeEnd (int w) {
		
		String spacing = new String(new char[w + 10]).replace("\0", "═");
		
		return "╚" + spacing + "╝\n";
		
	}
	
}