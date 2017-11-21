#lab8_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee

import random

#QUESTION 1
def cleaner (clip, step):
    
    #Instead of looping through the samples themselves we will loop through their indexes
    #Since we have to check wheather the indices are multiples of step
    samples = getSamples (clip)
    
    for i in range (0, len(samples)):
        
        #If the sample index is not a multiple of step, alter the value
        if (not i % step == 0):
            
            #It appears min and max are builtin python variable names
            #So I will use rmin and rmax instead to remove any risk of value override
            rmin = 0
            rmax = 500
            
            #If the sample is past the midway point make the min-max random range -500 to 0 instead of 0 to 500
            if (i > len(samples)/2):
                rmin = -500
                rmax = 0
            
            setSampleValue (samples [i], random.randint (rmin, rmax))
            
    return clip

#lab8_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee

import random

#BONUS
def cleanerBonus (clip, step, oscillatorAmplitude):
    
    #Instead of looping through the samples themselves we will loop through their indexes
    #Since we have to check wheather the indices are multiples of step
    samples = getSamples (clip)
    
    sampleDir = 1.0
    sampleVal = 0.0
    
    if (oscillatorAmplitude == None):
        oscillatorAmplitude = 1
    
    #Since the higher the oscillatorAmplitude is, the change to the sampleDir should be smaller
    #To do this, take 1 and divide it by oscillatorAmplitude
    oscillatorAmplitude = 1/float(oscillatorAmplitude)
    
    for i in range (0, len(samples)):
        
        #If the sample index is not a multiple of step, alter the value
        if (not i % step == 0):
        
            #If the value reaches it's max or min, set it's direction of travel to +1
            if (sampleVal >= 500):
                sampleDir = -oscillatorAmplitude
            if (sampleVal <= -500):
                sampleDir = oscillatorAmplitude
            
            #Generate a simple triangle wave by making the sampleVal
            #value pingpong between -500 and 500
            sampleVal += sampleDir
            
            setSampleValue (samples [i], sampleVal)
            
    return clip