//*************************************************************************************************
//
// 	NumbersWord.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Class to be used by Lab9Tester, should print correct output.
//  ==============================================================
//  Labs are much harder to do when we are provided with broken,
//  and vague code. We are required to name our class 	NumbersWord
//  but the code provided creates an instance of 		NumberWord
//
//*************************************************************************************************

package Lab9;

public class NumbersWord {

	private int a, b, c;
	private String s;
	
	//Constructor
	public NumbersWord (int newA, int newB, int newC, String newS) {
	
		a = newA;
		b = newB;
		c = newC;
		
		s = newS;
	
	}
	
	//Getters
	private int getA () {return a;}
	private int getB () {return b;}
	private int getC () {return c;}
	private String getS() {return s;}
	//Setters
	private void setA (int val) {a = val;}
	private void setB (int val) {b = val;}
	private void setC (int val) {c = val;}
	private void setS(String val) {s = val;}
	
	public void shuffle () {
		int oldA = a;
		a = b;
		b = c;
		c = oldA;
	}
	
	public void reset () {
		a = b = c = 0;
	}
	
	public void addOneTwoThree () {
		a ++;
		b += 2;
		c += 3;
	}
	
	public String changeLetter (char letter, int i) {
	
		StringBuilder builder = new StringBuilder(s);
		builder.setCharAt(i, letter);
		return builder.toString();
	
	}
	
	@Override
	public String toString() {
		
		return 	"A is " + a + ", B is " + b + ", C is " + c +
				", and word is " + s;
	
	}
	
}
