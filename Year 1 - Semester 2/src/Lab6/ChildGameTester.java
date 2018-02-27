package Lab6;

public class ChildGameTester
{
  public static void main(String[] args)
  {
    int temp;
    
    //Let's play this childish game
    ChildGame c = new ChildGame(4,"flunk");
    System.out.println("1: " + c);
    
    // Try to change the number, deal with the childish consequences.
    c.changeNumber(7);
    System.out.println("2: " + c);
    
    // Try to change the word, deal with the childish consequences.
    c.changeWord("yep");
    System.out.println("3: " + c);
    
    //Let's lay down the law
    c.setFavNumber(88);
    System.out.println("4: " + c);
    
    // That's more like it
    c.setFavWord("hello");
    System.out.println("5: " + c);
    
    //Let's mess things up
    System.out.println("6: What a mess " + c.messedUpNumber());
    
    // Get my favourite number and make sure it's less than 10
    temp = c.getFavNumber();
    if(temp > 10)
      temp = 9;
    System.out.println("temp: " + temp);
    
  }
}