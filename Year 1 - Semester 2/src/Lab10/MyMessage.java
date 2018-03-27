//*************************************************************************************************
//
// 	MyMessage.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Prints a positive/negative message using methods from Message interface
//
//*************************************************************************************************

package Lab10;

public class MyMessage implements Message {

	private static int allNumber;
	
	private int count;
	private String positive;
	private String negative;
	
	public MyMessage (String pos, String neg) {
	
		count = 0;
		
		positive = pos;
		negative = neg;
	
	}
	
	public void variableMessage (int mode) {
	
		if (mode == 1)
			positiveMessage();
		else if (mode == 2)
			negativeMessage();
		else
			System.out.println(defaultMessage);
		
		count++;
		allNumber++;
		
	}
	
	@Override
	public void positiveMessage() {
		System.out.println(positive);
	}
	
	@Override
	public void negativeMessage() {
		System.out.println(negative);
	}
	
	public int getNumber () {
		return count;
	}
	
	public int getAllNumber () {
		return  allNumber;
	}

}
