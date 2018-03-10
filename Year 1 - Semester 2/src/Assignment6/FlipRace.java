//*************************************************************************************************
//
// 	FlipRace.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Flips two coin instances until one (or both) flip heads 3 times in a row.
//
//*************************************************************************************************

package Assignment6;

public class FlipRace {
	
	private static int count;
	private static int countA;
	private static int countB;
	
	/*
	* We want to use pre-fabricated strings to avoid
	* Creating a new string instance every time a coin
	* Flip loop is performed
	*/
	private static final String AH = "Coin 1: Heads\t";
	private static final String AT = "Coin 1: Tails\t";
	private static final String BH = "Coin 2: Heads";
	private static final String BT = "Coin 2: Tails";
	
	private static Coin A = new Coin();
	private static Coin B = new Coin();
	
	public static void main (String[] args) {
		
		/*
		 * We want to use pre-fabricated strings to avoid
		 * Creating a new string instance every time a coin
		 * Flip loop is performed
		 */
		String AHBH = AH + BH;
		String ATBT = AT + BT;
		String AHBT = AH + BT;
		String ATBH = AT + BH;
		
		while (true) {
		
			//Flip both coin instances and store their results in local vars
			A.flip();
			B.flip();
			boolean Ah = A.isHeads();
			boolean Bh = B.isHeads();
			
			//Increase tally if heads, otherwise reset tally
			if (Ah)
				countA++;
			else
				countA = 0;
			
			//Increase tally if heads, otherwise reset tally
			if (Bh)
				countB++;
			else
				countB = 0;
			
			//Print out coin results
			if (Ah && Bh)
				System.out.println(AHBH);
			else if (!Ah && !Bh)
				System.out.println(ATBT);
			else
				System.out.println(Ah ? AHBT : ATBH);
			
			//If either coin reaches three heads in a row, end the loop
			if (countA >= 3 || countB >= 3)
			 	break;
			
			count++;
			
		}
		
		//Print out winner
		if (countA == countB)
			System.out.print("It's a TIE after " + count + " flips!");
		else
			System.out.print(
				"Coin " + ((countA >= 3) ? "1" : "2") +
				" Wins after " + count + " flips!"
			);
	
	}
	
}
