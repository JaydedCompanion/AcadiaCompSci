#lab8_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee

#QUESTION 1
def ZerodbSamples (clip):
    
    #This variable keeps track of all the samples that have a 0-value
    Zeroes = 0;
    
    for sample in getSamples (clip):
        if getSampleValue (sample) == 0:
            #If the currently looping sample has a value of 0, increase the zero-sample counter
            Zeroes += 1
    
    #Return the zero-sample count
    return Zeroes

#QUESTION 2
def increaseAndDecrease(sound, percent):
    length = getLength(sound)
    decimal = (float (percent) /100)
    
    for index in range(0, length * decimal):
        value = getSampleValueAt(sound, index)
        setSampleValueAt(sound, index, value*2)
        
    for index in range(length * decimal, length):
        value = getSampleValueAt(sound, index)
        setSampleValueAt(sound, index, value*0.1)
        
    return sound

#BONUS
def bestProf (best, profever):
    
    #Starting index for "-- prof ever"
    profeverOffset = 55000
    
    #Size of blank sound
    blankSize = getLength (best) + (getLength (profever) - profeverOffset)
    
    #Create new sound using calculated lenght, and the same sample rate as the two provided sounds to avoid distortion
    canvas = makeEmptySound (blankSize, 44100)
    sampleIndex = 0
    
    for i in range (0, blankSize):
        
        sample = None
        
        if (i < profeverOffset):
            sample = best
        elif (i == profeverOffset):
            #Change the index to read the sound so it starts copying the second sound at the right position
            sampleIndex = profeverOffset
            sample = profever
        else:
            sample = profever
            
        #Avoid IndexOutOfRange Exceptions by breaking the loop if the sampleIndex goes above the size of the sound profever
        if (sampleIndex >= getLength (profever)):
            break
            
        #Stich 'em up
        setSampleValueAt (canvas, i, getSampleValueAt (sample, sampleIndex))
        
        #Increment
        sampleIndex += 1
    
    #Return the sound
    return canvas
    