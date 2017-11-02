#a4-1113-100143996.py
#By Juan Callejas
#COMP 1113 X1
#Instructor: Darcy Benoit

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
