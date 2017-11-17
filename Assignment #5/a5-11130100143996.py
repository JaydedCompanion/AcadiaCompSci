#a5-1113-100143996.py
#By Juan Callejas
#COMP 1113 X1
#Instructor: Darcy Benoit

#QUESTION 1
def step (sound, cut):
	
	#Multiply time by cut instead of divide because the variable cut is a decimal
	cutIndex = float (getLength (sound)) * cut
	
	i = 0
	for sample in getSamples(sound):
		
		sampleValue = 10000
		
		if i > cutIndex:
			sampleValue = -10000
		
		setSampleValue (sample, sampleValue)
		
		i += 1
	
	return sound

#QUESTION 2
def stats (sound):
    
    #Store first sample in individual variable for easy access
    firstSample = getSamples (sound) [0]
    
    #Define variables in broader scope so they aren't reset during each loop
    zeroCount = 0
    largestValue = getSampleValue (firstSample)
    largestCount = 0
    smallestValue = largestValue
    smallestCount = 0
    
    #Loop through every sample in the sound
    for sample in getSamples (sound):
        
        #Store the sample value in individual variable for easy access
        val = getSampleValue (sample)
        
        #Check for zero-value
        if (val == 0):
            zeroCount += 1
        
        #Check if the sample value matches the smallest or largest value
        if (val == largestValue):
            largestCount += 1
        if (val == smallestValue):
            smallestCount += 1
        
        #If the current sample value is greater than the existing max value
        #reset the largest count and increase the largestValue to the new max
        #and do the same with the smallestValue and smallestCount variables
        if (val > largestValue):
            largestCount = 1    #Reset to 1 instead of 0 since technically the value was found/exists at least once
            largestValue = val
            print ("New max found. Clearing counter")
        if (val < smallestValue):
            smallestCount = 1   #Reset to 1 instead of 0 since technically the value was found/exists at least once
            smallestValue = val
            print ("New min found. Clearing counter")
    
    print ("The largest value (" + str(largestValue) + ") occurs " + str(largestCount) + " times.")
    print ("The smallest value (" + str(smallestValue) + ") occurs " + str(smallestCount) + " times.")
    print ("There are " + str(zeroCount) + " zeros.")
    
