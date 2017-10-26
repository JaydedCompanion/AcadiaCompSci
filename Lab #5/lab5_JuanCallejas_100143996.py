#lab5_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee

def horizontalFlag (pic):
	for pix in pic.getPixels ():
		if (pix.getY() < (pic.getHeight()/3)):
			pix.setColor (makeColor (255, 229, 0))
		elif (pix.getY() < (pic.getHeight()/3) * 2):
			pix.setColor (makeColor (0, 165, 255))
		else:
			pix.setColor (makeColor (255, 50, 0))
	return (pic)
	
	
def verticalFlag (pic):
	for pix in pic.getPixels ():
		if (pix.getX() < (pic.getWidth()/3)):
			pix.setColor (makeColor (0, 135, 255))
		elif (pix.getX() < (pic.getWidth()/3) * 2):
			pix.setColor (white)
		else:
			pix.setColor (makeColor (255, 50, 0))
	return (pic)
	
