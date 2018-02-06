//*************************************************************************************************
//
// 	CityInfo.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Generates a string using user-provided inputs
//
//*************************************************************************************************

package Lab4;

import java.awt.event.ComponentListener;
import java.util.Arrays;
import java.util.Scanner;

public class CityInfo {
	
	private static Scanner scanner = new Scanner (System.in);
	private static boolean verbose;
	
	public static final String CityNameID = "CITY_NAME_ID";
	public static final String YearFoundedID = "YEAR_FOUNDED_ID";
	public static final String CityAgeID = "CITY_AGE_ID";
	public static final String FirstLetterID = "FIRST_LETTER_ID";
	public static final String AgeAverageID = "AGE_AVERAGE_ID";
	public static final String sentence =
"\nThe city of " +
		CityNameID +
" was founded in " +
		YearFoundedID +
", and is thus " +
		CityAgeID +
" years old. " +
		CityNameID +
" starts with the letter " +
		FirstLetterID +
" and the average age of its citizens is " +
		AgeAverageID +
".";

	public static void main (String[] args) {
		
		for (int i = 0; i < args.length; i ++) {
			if (args[i].toUpperCase().equals("-V"))
				verbose = true;
		}
		
		if (verbose) {
			System.out.println("Detected verbose flag\n");
			System.out.println("Sentence preset: \n" + sentence + "\n\n");
		}
	
		System.out.print("Enter city name:\t\t\t");
		String cityName	= scanner.next();
		System.out.print("Enter city year founded:\t");
		int yearFounded	= scanner.nextInt();
		System.out.print("Enter current year:\t\t\t");
		int currentYear	= scanner.nextInt();
		System.out.print("Enter city first letter:\t");
		char firstChar	= scanner.next().charAt(0);
		System.out.print("Enter city average age:\t\t");
		double ageAvg	= scanner.nextDouble();
		
		/*
		 * Why are we requesting the first letter of
		 * the name from the user when we can just do
		 * cityName.charAt (0) so we get a more reliable
		 * result and have less redundant prompts?
		 */
		
		System.out.println(Compile(
				cityName,
				yearFounded,
				currentYear - yearFounded,
				firstChar,
				ageAvg
		));
	
	}
	
	public static String Compile (String cityName, int yearFounded,
								  int cityAge, char firstLetter,
								  double ageAverage) {
	
		String compiled = sentence;
		compiled = compiled.replaceAll(CityNameID, cityName);
		compiled = compiled.replaceAll(YearFoundedID, Integer.toString(yearFounded));
		compiled = compiled.replaceAll(CityAgeID, Integer.toString(cityAge));
		compiled = compiled.replaceAll(FirstLetterID, Character.toString(firstLetter));
		compiled = compiled.replaceAll(AgeAverageID, Double.toString(ageAverage));
		
		return compiled;
	
	}
	
}
