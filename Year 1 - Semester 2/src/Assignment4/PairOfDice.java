//*************************************************************************************************
//
// 	PairOfDice.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Handles two dice. Rolls and gets values from both, and has toString method.
//
//*************************************************************************************************

public class PairOfDice {

	private Die die1;
	private Die die2;
	
	public PairOfDice () {
		
		die1 = new Die();
		die2 = new Die();
	
	}
	
	//Rolls the two dice and returns their sum
	public int roll () {
	
		return die1.roll() + die2.roll();
	
	}
	//Returns the sum of the two dice (without rerolling them)
	public int getTotalFaceValue () {
	
		return die1.getFaceValue() + die2.getFaceValue();
	
	}
	//Returns value of die 1
	public int getDie1FaceValue () {
	
		return die1.getFaceValue();
	
	}
	//Returns value of die1
	public int getDie2FaceValue () {
	
		return die2.getFaceValue();
		
	}
	//toString method for implicitly casting to string
	public String toString () {
	
		return	"Die 1: " + die1.getFaceValue() +
				"\tDie 2: " + die2.getFaceValue();
		
	}
	
}
