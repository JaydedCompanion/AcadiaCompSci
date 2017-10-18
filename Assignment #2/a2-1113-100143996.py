#a2-1113-100143996.py
#By Juan Callejas
#COMP 1113 X1
#Instructor: Darcy Benoit

#Change the colour of the pixel to the second parameter
def changePixelColor (pixel, col):
	setColor (pixel, col)
	
#Make the RGB values of the pixel to the smallest of the three
def changePixelGrey (pix):
	
	value = int (getMin (pix.getColor()))
	
	changePixelColor (pix, makeColor (value, value, value))
	
	return pix

#Set the colour of all the pixels in the image to the second parameter
def wipeOut (pic, col):
	for pix in pic.getPixels():
		changePixelColor (pix, col)
	return pic

def greyOut (pic):
	
	for pix in pic.getPixels():
		changePixelGrey (pix)
		
	return pic

#Call the changePixelGrey() method on every other pixel
def everySecond (pic):
	i = 0
	for pix in pic.getPixels():
		if i % 2 == 0:
			changePixelGrey (pix)
		i += 1
	return pic
	
#Find the smallest value of an array,
#An alternate mode is available, where individual rgb values may be passed and an array will be generated and used
#Yet another altername mode is available where a color object is passed, and it is called again but with those values as parameters instead
def getMin (r = None, g = None, b = None):	
	
	#If we're using rgb parameters use this code
	if (not r == None) and (not g == None) and (not b == None) and (not isinstance (r, list)):
		
		#print "Getting smallest value in rgb: " + str (r) + ", " + str (g) + ", " + str (b)
		
		#Create an array out of the rgb parameters
		rgb = []
		rgb.append (r)
		rgb.append (g)
		rgb.append (b)
		
		#Is this technically recusion?
		#Call this method again, but pass the rgb array as a parameter instead
		return getMin (rgb)
		
		
	#Why the hell is '!=' not a thing in python
	#If we're using only one parameter, do this instead
	
	elif (not r == None) and (g == None) and (b == None):
		
		if isinstance (r, java.awt.Color):
			return getMin (r.getRed(), r.getGreen(), r.getBlue())
		
		#Do not proceed if something other than an array with at least 1 element is passed
		if not isinstance (r, list) or len (r) < 1:
			print "ERROR: parameter \"array\" is not an array with at least 1 value"
		
		minimum = r [0];
		for i in range (0, len (r)):
			if (r[i] < minimum):
				minimum = r [i]
	
	#Return the lowest minimum value
	return minimum

explore (greyOut (makePicture (pickAFile())))