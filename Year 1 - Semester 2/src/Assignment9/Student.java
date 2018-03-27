//*************************************************************************************************
//
// 	Student.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Student object. Holds first/last name, home/school address. Can be locked
//	Complete clone from the slides
//
//*************************************************************************************************

package Assignment9;

public class Student implements Lock {
	
	private String firstName, lastName;
	private Address homeAddress, schoolAddress;
	
	private int Grade;
	
	private static boolean locked = false;
	
	//-----------------------------------------------------------------
	//  Constructor: Sets up this student with the specified values.
	//-----------------------------------------------------------------
	public Student(String first, String last, Address home,
				   Address school) {
		
		this (first, last, home, school, 0);
		
	}
	
	public Student(String first, String last, Address home,
				   Address school, int grade) {
		
		firstName = first;
		lastName = last;
		homeAddress = home;
		schoolAddress = school;
		
	}
	
	@Override
	public String toString () {
		
		if (locked)
			return this.getClass().getSimpleName() + " is locked.";
		else
			return	firstName + " " + lastName +
				"\nGrade: " + Grade +
				"\nHome address:\n" +
				homeAddress  +
				"\nSchool address:\n" +
				schoolAddress.toString();
		
	}
	
	@Override
	public void lock() {
		locked = true;
	}
	
	@Override
	public void unlock() {
		locked = false;
	}
	
}