//*************************************************************************************************
//
// 	Box.java			Author: Juan Sebastian Callejas Rodriguez		ID:100143996
//
//	Box class has a width, height, depth, and fill value that can be accessed
//  and modified and instanced
//
//*************************************************************************************************

//package Assignment4;

public class Box {

	private double w;
	private double h;
	private double d;
	
	private boolean full;
	
	public Box (double width, double height, double depth) {
	
		w = width;
		h = height;
		d = depth;
		
		full = false;
	
	}
	
	//Getter methods for W, H, D, Full
	public double getWidth () {
		return w;
	}
	public double getHeight () {
		return h;
	}
	public double getDepth () {
		return d;
	}
	public boolean getFull () {
		return full;
	}
	
	//Setter methods for W, H, D, Full
	public void setWidth (double val) {
		w = val;
	}
	public void setHeight (double val) {
		h = val;
	}
	public void setDepth (double val) {
		d = val;
	}
	public void setFull (boolean val) {
		full = val;
	}
	
	//Returns a string with various data about this box instance
	public String toString () {
	
		String comp = "";
		
		comp += "Box size: " + w + " W x " + h + " H x " + d + " D\n";
		comp += "This box is " + (full ? "" : "not ") + "full.";
		
		return comp;
		
	}
	
	
}
