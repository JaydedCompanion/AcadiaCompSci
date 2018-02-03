package Assignment1;

import java.util.ArrayList;

public class Diamond {
	
	/**
	 *
	 *     Desired output:
	 *
	 *           *
	 *         * * *
	 *       * * * * *
	 *     * * * * * * *
	 *   * * * * * * * * *
	 *     * * * * * * *
	 *       * * * * *
	 *         * * *
	 *           *
	 *
	 **/
	
	private static final int RowLength = 21;
	
	public static void main (String[] params) {
	
		Diamond();
		
	}
	
	public static void Diamond () {
		
		Diamond(9);
	
	}
	
	public static void Diamond (int size) {
		
		System.out.println(GenerateDiamond(size));
		
	}
	
	//GenerateAsteriskRow generates 'amount' number of asterisks (with spaces in between) and then returns the generated string
	public static String GenerateAsteriskRow (int amount) {
	
		String row = "";
		
		//Generate asterisks
		for (int i = 0; i < amount; i ++) {
			
			row += "*";
			
			if (amount != i)
				row += " ";
			
		}
		
		//Calculate the number of whitespace needed before the asterisks to keep them centered
		int gap = (Math.round(RowLength/2f - 0.5f) - Math.round(amount/2f - 0.5f) * 2) + 1;
		
		for (int i = 0; i < gap; i ++) {
		
			//row += " " cannot be used because the space must be added to the start of the row
			row = " " + row;
		
		}
		
		return row;
		
	}
	
	//GenerateDiamond generates an array of lengths for each row in the diamond and then calls GenerateAsteriskRow with the corresponding length
	public static String GenerateDiamond (int height) {
		
		int halfHeight = Math.round(height/2f + 0.5f);
		ArrayList<Integer> sizes = new ArrayList<Integer>();
		String diamond = "";
		
		for (int i = 0; i < height; i ++) {
			
			if (i < halfHeight) {
				
				sizes.add((i + 1) * 2 - 1);
				
			} else {
				
				sizes.add(sizes.get(height - i - 1));
				
			}
			
		}
		
		for (int i = 0; i < sizes.size(); i ++) {
		
			diamond += GenerateAsteriskRow(sizes.get(i));
			if (i != sizes.size())
				diamond += "\n";
		
		}
		
		return diamond;
		
	}
	
}
