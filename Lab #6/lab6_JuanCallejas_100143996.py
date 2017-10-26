#lab6_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee

def 

#So-called "negatize"
def invert (pix):
	pix.setColour (255 - pix.getRed(), 255 - pix.getGreen(), 255 - pix.getBlue())
	return pix
	
#Unlike Assignment 2, this method will actually use the correct
#method of obtaining the greyscale value of a pixel, which is by
#calculating the average of the RGB values, instead of using the
#smallest value for all three.
def greyscale (pix):
	value = (pix.getRed() + pix.getGreen() + pix.getBlue()) / 3
	pix.setColour (makeColor (value, value, value))
	return pix
	
#To eliminate all red, this method will be used with parameters (0, 1, 1)
#Which will use 0% red and 100% green and blue
def RGB_Percent (pix, r, g, b):
	pix.setRed ((float) pix.getRed() * r)
	pix.setRed ((float) pix.getGreen() * g)
	pix.setRed ((float) pix.getBlue() * b)
    
def SwapGreenBlue (pix):
    #Store the green value in a variable since it will be overridden before we use it
    green = pix.getGreen()
    pix.setGreen (pix.getBlue())
    pix.setBlue (green)