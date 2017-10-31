#lab6_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee

avgCol = makeColor (0, 0, 0)

def sixSection (img, flag):
    
    if (flag != 1 and flag != 2):
        setAllPixelsToAColor (img, red)
        return img
    
    print "Param \"flag\" is either 1 or 2, so it will not be red"
    
    w = img.getWidth()
    h = img.getHeight()
    
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
    
    for pix in img.getPixels():
        
        x = pix.getX()
        y = pix.getY()
        
        if (x < w/2):
            if (y < h/3):
                handleTL(pix)
            elif (y > (h/3)*2):
                handleBL(pix)
            else:
                handleML(pix)
        else:
            if (y < h/3):
                if (flag == 1):
                    handleTR(pix, black)
                else:
                    handleTR(pix, white)
            elif (y > (h/3)*2):
                handleBR(pix)
            else:
                if (flag == 1):
                    handleMR(pix, black)
                else:
                    handleMR(pix, white)
            
    return img


def handleTL(pix):
    if (pix.getRed() > 128):
        pix.setRed(0)
    if (pix.getGreen() > 128):
        pix.setGreen(128)
    if (pix.getBlue() > 128):
        pix.setBlue(255)
        
def handleML(pix):
    if (distance (getColor(pix), blue) <= 200):
        pix.setColor (white)
    
def handleBL(pix):
    if (distance (getColor(pix), green) <= 220):
        pix.setColor (green)
    
def handleTR(pix, col):
    if (pix.y % 2 == 0):
        pix.setColor (col)

def handleMR(pix, col):
    if (pix.x % 2 == 0):
        pix.setColor (col)
    
def handleBR(pix):
    if (pix.getGreen() > avgCol.getGreen() and pix.getBlue() > avgCol.getBlue()):
        pix.setGreen(200)
        pix.setBlue (55)