#lab4_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee

def alterPicture (picture, percentR, percentG, percentB):
    picture =   alterChannel (picture, percentR, "R")
    picture =   alterChannel (picture, percentG, "G")
    return      alterChannel (picture, percentB, "B")


def alterChannel (picture, percent, channel):  
    for pixel in getPixels (picture):
        if (channel == "R"):
            pixel.setRed (int (pixel.getRed() * (float (percent) / 100)))
            continue
        elif (channel == "G"):
            pixel.setGreen (int (pixel.getGreen() * (float (percent) / 100)))
            continue
        elif (channel == "B"):
            pixel.setBlue (int (pixel.getBlue () * (float (percent) / 100)))
            continue
    return picture

#Uncomment the following line for a simple automatic demo
#show (alterPicture (makePicture (pickAFile()), 100, 70, 40))