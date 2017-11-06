#a4-1113-100143996.py
#By Juan Callejas
#COMP 1113 X1
#Instructor: Darcy Benoit

import time

#This method generates a mask for us to use for the main method
def makeMask (w, h, x, y, r):
    canvas = makeEmptyPicture (w, h, black)
    addOvalFilled (canvas, x-r, y-r, r*2, r*2, white)
    return canvas

#This method checks if the mask pixel is set to show or hide
def maskCheck (col):
    return (col.getRed() + col.getGreen() + col.getBlue())/3 > 128

#QUESTION 1
def circlePic (img, x, y, r):
    
    #Width and Height variables defined for easy access
    w = img.getWidth()
    h = img.getHeight()
    
    #Since we are told to not modify the original image, we create a new blank image to write onto
    canvas = makeEmptyPicture (w, h, white)
    
    #This image is a black-and-white image representing which areas of the image should be normal and which should be white
    mask = makeMask (w, h, x, y, r)
    
    #Make the pixels of each image into array variables for easy access
    originalPixels = img.getPixels()
    maskPixels = mask.getPixels()
    canvasPixels = canvas.getPixels()
    
    for i in range (0, len (originalPixels)):
        #If the mask pixel is set to show, make the current canvas pixel be the colour of the corresponding pixel in our original image  
        if (maskCheck (maskPixels [i])):
            canvasPixels [i].setColor (originalPixels [i].getColor())
    
    return canvas

#QUESTION 2
def border (img, border):
    
    w = img.getWidth()
    h = img.getHeight()
    
    border *= 2
    
    canvas = makeEmptyPicture (w + border, h + border, black)
    
    canvas = copyInto (img, canvas, border/2, border/2)
    
    return canvas

#QUESTION 3
def animation (framerate):
    
    if (framerate == None):
        #60fps PC master race
        framerate = 60
    
    #Define animation size
    width = 1920/2
    height = 1080/2
    
    canvas = makeEmptyPicture (width, height, white)
    
    #Ball 'physics' variables
    xOffset = 300
    xPos = 0;
    radius = 64;
    arcWidth = -50
    arcTravel = arcWidth
    
    while (true):
        #Clear the canvas
        setAllPixelsToAColor (canvas, white)
        #Define the y position using a quadratic formula
        yPos = (1080*0.5) + (0.1 * (arcTravel * arcTravel))
        #Draw the ball at the x and y position
        addOval (canvas, int(xPos) - radius, int(yPos) - radius - xOffset, radius, radius, blue)
        #Move the ball to the right
        xPos += 0.3
        arcTravel += 0.3
        #Keep the ball in bounds by looping around
        if (xPos > width + radius*2):
            xPos = -radius
        #If the ball hits the virtual ground, bounce it, by resetting the position of the quadratic formula's x position
        if (yPos > (1080*0.5) + (0.1 * (arcWidth * arcWidth))):
            arcTravel = arcWidth
        #Render the frame to the screen
        repaint (canvas)
        time.sleep (1/framerate)
        
#QUESTION 4
def generateChessBoard (size, col):
    #Create a canvas
    canvas = makeEmptyPicture (size*8, size*8, white)
    #Each square, and the distance between squares, is an eighth of the size of the image (since chess boards are 8 x 8 grids)
    squareSize = size
    for x in range (0, 8):
        for y in range (0, 8):
            #If both/neither X and/nor Y are multiples of 2, draw a square 
            if ((x % 2 == 0) == (y % 2 == 0)):
                #Draw the square by multiplying the spacing by which square on the grid this is, and using the spacing as the width and height
                addRectFilled (canvas, squareSize * x, squareSize * y, squareSize, squareSize, col)
    return canvas