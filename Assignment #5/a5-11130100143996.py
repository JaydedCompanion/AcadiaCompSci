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