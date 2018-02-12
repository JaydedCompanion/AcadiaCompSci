//********************************************************************
//  RollingDice.java       Author: Lewis/Loftus
//
//  Tester program for PairOfDice
//********************************************************************

public class RollingDice
{
    //-----------------------------------------------------------------
    //  Creates and exercises a PairOfDice object.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        PairOfDice dice = new PairOfDice();

        System.out.println(dice);

        System.out.println("Lucky roll: " + dice.roll());

        System.out.println(dice);
        System.out.println("Total: " + dice.getTotalFaceValue());

        dice.roll();

        System.out.println(dice);
        
        System.out.println("Die 1: " + dice.getDie1FaceValue());
        System.out.println("Die 2: " + dice.getDie2FaceValue());
    }
}
