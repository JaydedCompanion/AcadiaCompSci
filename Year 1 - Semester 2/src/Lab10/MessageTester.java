package Lab10;

public class MessageTester
{
  
 public static void main(String args[])
 {
  
   MyMessage m1 = new MyMessage("Dr. Lee is nice","Dr. Lee is not nice");
   MyMessage m2 = new MyMessage("Dr. Benoit is nice", "Dr. Benoit is not nice");
   
   m1.variableMessage(1);
   m2.variableMessage(2);
   m1.variableMessage(222);
   
   System.out.println("M1 has put out " + m1.getNumber() + " messages");
   System.out.println("M2 has put out " + m2.getNumber() + " messages"); 
   System.out.println("There have been " + m1.getAllNumber() + " total messages");
 }
  
}