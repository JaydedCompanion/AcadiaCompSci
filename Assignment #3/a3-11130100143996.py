#a3-1113-100143996.py
#By Juan Callejas
#COMP 1113 X1
#Instructor: Darcy Benoit

#PART 1
def grid (img):
    img = gridBuilder (img, 10, 10, black)

#PART 2
def grid2 (img, size):
    img = gridBuilder (img, size, size, black)
    
#PART 3
def grid3 (img, size, color):
    img = gridBuilder (img, size, size, color)

#PART 4
def invert (pix):
    #invert the pixel rgb values
    pix.setColor (makeColor (255 - pix.getRed(), 255 - pix.getGreen(), 255 - pix.getBlue()))
    return pix
    
#PART 5
def negateHalf (img, side):
    w = img.getWidth();
    h = img.getHeight();
    
    for pix in img.getPixels():
        x = pix.getX();
        y = pix.getY();
        if (side == 1 and x < w/2) or (side == 2 and x > w/2) or (side == 3 and y < h/2) or (side == 4 and y > h/2):
            pix = invert (pix)
            

    
def gridBuilder (img, xs, ys, color):
    for pix in img.getPixels():
        #If the position of the pixel on the X or Y are multiples of the X or Y spacing respectively, make the pixel whatever colour is specified as the grid colour
        if pix.getX() % xs == 0 or pix.getY() % ys == 0:
            pix.setColor (color)
    return img

def interface ():
    
    imagePath = pickAFile ()
    if imagePath == None or imagePath == "" or imagePath == "None":
        return -1
    originalImage = makePicture (imagePath)
    workingImage = originalImage
    
    string = "What would you like to do with \"" + getShortPath (imagePath) + "\"?\n"
    string += "1: grid\n"
    string += "2: grid2 (custom spacing)\n"
    string += "3: grid3 (custom spacing and color)\n"
    string += "4: negateHalf\n"
    
    userInput = requestIntegerInRange (string, 1, 4);
    
    if (userInput == None):
        return -1
    
    if userInput == 1:
        grid (workingImage)
    elif userInput == 2:
        spacing = requestInteger ("grid2 spacing")
        grid2 (workingImage, spacing)
    elif userInput == 3:
        spacing = requestInteger ("grid3 spacing")
        col = pickAColor ()
        grid3 (workingImage, spacing, col)
    elif userInput == 4:
        half = requestIntegerInRange ("1: Left\n2: Right:\n3: Top\n4: Bottom", 1, 4)
        negateHalf (workingImage, half)
        
    show (workingImage)
        
print ("======= Program Running =======")

while (true):
    
    if interface() == -1:
        print ("======= Program Finished =======")
        break