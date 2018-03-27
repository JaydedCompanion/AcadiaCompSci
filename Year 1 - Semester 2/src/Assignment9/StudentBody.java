//********************************************************************
//  StudentBody.java       Author: Lewis/Loftus
//
//  Demonstrates the use of an aggregate class, and an interface.
//********************************************************************

package Assignment9;

public class StudentBody 
{
    //-----------------------------------------------------------------
    //  Creates some Address and Student objects and prints them.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        Address school = new Address("800 Lancaster Ave.", "Villanova",
                "PA", 19085);
        Address jHome = new Address("21 Jump Street", "Blacksburg",
                "VA", 24551);
        Student john = new Student("John", "Smith", jHome, school);
        Student adam = new Student("Adam", "Smith", jHome, school, 80);

        Address mHome = new Address("123 Main Street", "Euclid", "OH",
                44132);
        Student marsha = new Student("Marsha", "Jones", mHome, school);

        System.out.println(john);
        System.out.println();
        System.out.println(adam);
        System.out.println();
        System.out.println(marsha);
        
        school.lock();
        System.out.println();
        System.out.println(john);
        System.out.println();
        System.out.println(adam);
        System.out.println();
        System.out.println(marsha);
        
        john.lock();
        System.out.println();
        System.out.println(john);
        System.out.println();
        System.out.println(adam);
        System.out.println();
        System.out.println(marsha);
        
        adam.unlock();
        System.out.println();
        System.out.println(john);
        System.out.println();
        System.out.println(adam);
        System.out.println();
        System.out.println(marsha);
    }
}
