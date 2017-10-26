#lab6_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee


def invert (pix):
	pix.setColour (255 - pix.getRed(), 255 - pix.getGreen(), 255 - pix.getBlue())
	return pix
	
def greyscale (pix):
	value = (pix.getRed() + pix.getGreen() + pix.getBlue()) / 3
	pix.setColour (makeColor (value, value, value))
	return pix
	
def RGB_Percent (pix, r, g, b):
	pix.setRed (pix.getRed() * r)