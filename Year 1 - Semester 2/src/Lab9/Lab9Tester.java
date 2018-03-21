package Lab9;
//Class is named Lab7Tester, but file is named Lab9Tester
//Which one is it??
//public class Lab7Tester {
public class Lab9Tester {
  public static void main(String args[])
  {
    //NumberWord was used, but assignment specifies NumbersWord as class name
    //Which one is it??
    //NumberWord
    NumbersWord a = new NumbersWord(1,2,3,"Sleepless");
    System.out.println("My object is " + a);
    
    a.shuffle();
    System.out.println("My object is " + a);

    a.shuffle();
    System.out.println("My object is " + a); 
    
    a.reset();
    System.out.println("My object is " + a);
    
    a.addOneTwoThree();
    System.out.println("My object is " + a);
    
    a.addOneTwoThree();
    System.out.println("My object is " + a);
    
    
    
    String result = a.changeLetter('X',5);
    System.out.println(result);
    result = a.changeLetter('Y',0);
    System.out.println(result);
    
  }
}