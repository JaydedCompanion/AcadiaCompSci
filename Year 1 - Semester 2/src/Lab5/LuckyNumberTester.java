public class LuckyNumberTester
{
  public static void main(String[] args)
  {
    int temp;
    
    // My lucky number is 10.
    LuckyNumber lucky = new LuckyNumber(10);
    System.out.println("1: " + lucky);
    
    // I changed my mind.
    lucky.setX(15);
    System.out.println("2: " + lucky);
    
    // What was my lucky number?
    temp = lucky.getX();
    System.out.println("It was: " + temp);
    
    // I think 16 is better. I'll add 1 to my lucky number.
    lucky.incX();
    System.out.println("3: " + lucky);
    
    // 17 has to be better than 16.
    lucky.incX();
    System.out.println("4: " + lucky);
    
    // No, I'll keep 15.
    lucky.decX();
    lucky.decX();
    System.out.println("5: " + lucky);
    
    // Zero out the lucky number.
    lucky.zeroAllX();
    System.out.println("6: " + lucky);
    
    // The method randomX(r) generates a random integer in the range [-r,r].
    // Generate a new random lucky number between -100 and +100.
    lucky.randomX(100);
    System.out.println("7: " + lucky);
    
    // Change just the last digit of my lucky number to zero.
    lucky.zeroLastX();
    System.out.println("8: " + lucky);
    
    // Get my lucky number and make sure it is positive.
    temp = lucky.getX();
    temp = Math.abs(temp);  // abs returns the absolute value of temp.
    System.out.println("temp: " + temp);
    // Generate a new random lucky number between -temp and +temp.
    lucky.randomX(temp);
    System.out.println("9: " + lucky);
    
    // Zero out the last digit for good luck!
    lucky.zeroLastX();
    System.out.println("Lucky 10'th println: " + lucky);
    
  }
}