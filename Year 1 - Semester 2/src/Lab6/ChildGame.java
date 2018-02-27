//*************************************************************************************************
//
// 	ChildGame.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Instantiable class with a favNumber and favWord, with childish setters
//
//*************************************************************************************************

package Lab6;

public class ChildGame {
	
	private int favouriteNumber;
	private String favouriteWord;
	//Messer constant
	private static final double MESSER = 0.8118;
	
	//Standard constructor
	public ChildGame (int number, String word) {
	
		favouriteNumber = number;
		favouriteWord = word;
	
	}
	
	//Changes the favourite number "childishly"
	public void changeNumber (int number) {
	
		if (number < 5)
			favouriteNumber = number * 2;
		else  if (number >= 5 && number <= 9)
			favouriteNumber = number / 2;
		else
			favouriteNumber = number + 1;
	
	}
	
	//Changes the word "childishly"
	public void changeWord (String word) {
	
		if (favouriteWord.equals(word))
			favouriteWord = "bad";
		else
			favouriteWord = "good";
	
	}
	
	//Returns a "messed up" number based on the favourite number
	public double messedUpNumber () {
	
		return Math.floor(favouriteNumber * MESSER) + 0.5;
	
	}
	
	//Setters
	public void setFavNumber (int number) {
		favouriteNumber = number;
	}
	public void setFavWord (String word) {
		favouriteWord = word;
	}
	//Getters
	public int getFavNumber () {
		return favouriteNumber;
	}
	public String getFavWord () {
		return favouriteWord;
	}
	
	
	public String toString () {
		return "Current state: " + favouriteNumber + "," + favouriteWord;
	}
	
}
