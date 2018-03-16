//*************************************************************************************************
//
// 	CountFlips.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Flips a coin instance 100x and how many times it flips heads, tails,
//  and the maximum number of times it flips heads in a row
//
//*************************************************************************************************

package Assignment7;

public class CountFlips {
	
	private static final int flip = 100;
	private static int headsCount;
	private static int tailsCount;
	private static int headsStreak;
	private static int headsStreakMax;
	private static Coin coin = new Coin();
	
	public static void main (String[] args) {
	
		for (int i = 0; i < flip; i ++) {
		
			coin.flip();
			
			if (coin.isHeads()) {
			//Increase the heads count and heads streak
				headsCount++;
				headsStreak++;
			} else {
			//Otherwise increase tails count and reset the heads streak
				tailsCount++;
				headsStreak = 0;
			}
			//if the current streak is greater than the max, update the max
			if (headsStreakMax < headsStreak)
				headsStreakMax = headsStreak;
			
		}
		
		//Output data
		System.out.println("Total flips: " + flip);
		System.out.println("Head: " + headsCount);
		System.out.println("Tails: " + tailsCount);
		System.out.println("Longest streak of heads: " + headsStreakMax);
		
	
	}
	
}
