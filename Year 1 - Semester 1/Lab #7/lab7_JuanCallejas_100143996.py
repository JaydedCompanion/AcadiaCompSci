#lab7_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee

#Global average color variable to be accessed in any variable without having to pass it as a parameter
avgCol = makeColor (0, 0, 0)

def sixSection (img, flag):
    
    if (flag != 1 and flag != 2):
        #If the flag is not 1 or 2, make the image red and end the method call
        setAllPixelsToAColor (img, red)
        return img
    
    print ("Param \"flag\" is either 1 or 2, so it will not be red")
    
    #Define width and height variables for easier access (and less method calls)
    w = img.getWidth()
    h = img.getHeight()
    
    #Calculate the average colour of the image for the Bottom-Right section of the image
    pixels = 0
    r = 0
    g = 0
    b = 0
    for pix in img.getPixels():
        pixels += 1
        r += pix.getRed()
        g += pix.getGreen()
        b += pix.getBlue()
    avgCol = makeColor (r/pixels, g/pixels, b/pixels)
    
    #Loop though the pixels and alter them depending on which section they are on
    for pix in img.getPixels():
        
        #Define x and y positions of the current pixel for easier access (and less method calls)
        x = pix.getX()
        y = pix.getY()
        
        #Declare wheather the rows and columns should be black or white
        col = white
        if flag == 1:
            col = black
        
        if (x < w/2):
            #If pixel is in left half
            if (y < h/3):
                #If in top third
                handleTL(pix)
            elif (y > (h/3)*2):
                #If in bottom third
                handleBL(pix)
            else:
                #Otherwise it must be in middle third
                handleML(pix)
        else:
            #If pixel is in right half
            if (y < h/3):
                #If in top third
                handleTR(pix, col)
            elif (y > (h/3)*2):
                #If in bottom third
                handleBR(pix)
            else:
                #Otherwise it must be in middle third
                handleMR(pix, col)
            
    return img


#Each of these methods will alter the given pixel depending on which section it is in
#Top Left
def handleTL(pix):
    if (pix.getRed() > 128):
        pix.setRed(0)
    if (pix.getGreen() > 128):
        pix.setGreen(128)
    if (pix.getBlue() > 128):
        pix.setBlue(255)
#Middle Left
def handleML(pix):
    if (distance (getColor(pix), blue) <= 200):
        pix.setColor (white)
#Bottom Left
def handleBL(pix):
    if (distance (getColor(pix), green) <= 220):
        pix.setColor (green)
#Top Right
def handleTR(pix, col):
    if (pix.y % 2 == 0):
        pix.setColor (col)
#Middle Right
def handleMR(pix, col):
    if (pix.x % 2 == 0):
        pix.setColor (col)
#Bottom Right
def handleBR(pix):
    if (pix.getGreen() > avgCol.getGreen() and pix.getBlue() > avgCol.getBlue()):
        pix.setGreen(200)
        pix.setBlue (55)