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
	
	print (value)
	
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
def getMin (array = None, r = None, g = None, b = None):
	
	#If we're using rgb parameters use this code
	if ((not r == None) and (not g == None) and (not b == None)):
		
		print ("Getting smallest value in rgb: " + str (r) + ", " + str (g) + ", " + str (b))
		
		#Create an array out of the rgb parameters
		rbg = [3]
		rgb [0] = r
        rgb [1] = g
        rgb [2] = b
		
		#Is this technically recusion?
		#Call this method again, but pass the rgb array as a parameter instead
		return getMin (rgb)
		
		
	#Why the hell is '!=' not a thing in python
	#If we're using the array parameter use this code instead
	
	if not array == None:
        
        #If the array variavle is not an array then it's *probably* a colour, so it should be handled as one
        if not isinstance (array, list):
            print ("Getting smallest value in colour " + str (array))
            return getMin (array.getRed(), array.getGreen(), array.getBlue())
        
		#Do not proceed if something other than an array with at least 1 element is passed
		if not isinstance (array, list) or len (array) < 1:
			print ("ERROR: parameter \"array\" is not an array with at least 1 value")
		
		print ("Getting smallest value in array " + str (array))
		
		minimum = array [0];
		for i in range (0, len (array)):
			if (array[i] < minimum):
				minimum = array [i]
	
	#Return the lowest minimum value
	return minimum