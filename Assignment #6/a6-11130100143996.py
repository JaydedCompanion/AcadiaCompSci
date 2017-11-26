#a6-1113-100143996.py
#By Juan Callejas
#COMP 1113 X1
#Instructor: Darcy Benoit

import math

#=====# RUN ELABORATE USER DETECTION SYSTEM #=====#
#Greet user
print ("Welcome, " + os.getenv('username'))
#If I am the one running the script, use the predetermined media folder
if (os.getenv('username') == "TheShadyColombian"):
    localPath = "C:\\Users\\jcall\\Documents\\Jython Workspace\\AcadiaCompSci\\JES Stock Samples\\"
    oldMediaPath = getMediaPath()
    setMediaPath (localPath)
    #setMediaPath does not specify when the mediaPath does not exist, and instead uses the old path. To check whether the setMediaPath() call above functioned
    #check whether or not getMediaPath() returns a different path
    if (not getMediaPath() == localPath):
        print ("MediaPath was not changed. Please specify a new path manually, or use the current one.")
        setMediaPath()
    else:
        print ("MediaPath has been set automatically.")
#Otherwise, request specify mediaPath
else:
    print ("New user detected. Please specify MediaPath")
    setMediaPath ()
#=====# END ELABORATE USER DETECTION SYSTEM #=====#

    
#QUESTION 1
def audioSentence ():
    
    soundPaths = []
    soundBytes = []
    
    #Create list of soundbytes
    soundPaths.append ("you")
    soundPaths.append ("stole")
    soundPaths.append ("my")
    soundPaths.append ("awesome")
    soundPaths.append ("car")
    soundPaths.append ("and")
    soundPaths.append ("ran")
    soundPaths.append ("inside")
    soundPaths.append ("the")
    soundPaths.append ("great")
    soundPaths.append ("airplane")
    soundPaths.append ("with")
    soundPaths.append ("it")

    #Convert the file names to actual sounds using makeSound and appending the file extension .wav to each filename
    for path in soundPaths:
        #Since I have incorporated some custom sounds, make sure to handle scenarios where one of the sounds may be missing
        try:
            soundBytes.append (makeSound (path + ".wav"))
        except:
            print ("Sound \"" + path + ".wav\" could not be found.")
    
    #Pass the array of soundbytes through the stitcher and return the result
    return stitcher (soundBytes)

#Sound stitching engine allows for a sound compilation from just a simple array of sounds
def stitcher (sounds):
    
    #Make sure no empty arrays, or arrays not starting with a sound, are passed
    if len (sounds) == 0 or not isinstance (sounds [0], Sound):
        print ("ERROR: sound parameter must be an array containing at least one sound")
    
    #Add up the length of all the soundbytes and use that to create a canvas that is large enough for all our sounds
    length = 0
    for sound in sounds:
        if isinstance (sound, Sound):
            length += getLength (sound)
    canvas = makeEmptySound (length, int (getSamplingRate (sounds [0])))
    
    #This index is declared outside the loop since we want to rember where we left off every time we start stichting a new sound
    globalSampleIndex = 0
    
    #Once our canvas has been created, loop though all the sounds we want to stich together
    for sound in sounds:
        #If the current object in the array is not a sound, skip it... because apparently that's a thing arrays can do in python -_-
        if not isinstance (sound, Sound):
            continue
        #Create an array containing the samples of the currently looping sound for easy access
        samples = getSamples (sound)
        #Loop though the samples in the current sound and stitch them to their corresponding sample in the canvas
        for localSampleIndex in range (0, len (samples)):
            #Set the canvas sample at global-index to that of the current soundbyte's sample at local-index 
            setSampleValueAt (canvas, globalSampleIndex, getSampleValue (samples [localSampleIndex])) 
            #Increase the sample value of the 
            globalSampleIndex += 1
    
    #Return the finished sound
    return canvas
        

#QUESTION 2
def mountains (sound):
    
    waveCount = 2
    samples = getSamples (sound)
    waveAmplitude = 32767                       #Height of the triangle wave
    waveLength = getLength (sound)/(waveCount)  #Units before the wave loops
    
    for i in range (0, len(samples)):
        
        f = (2 * math.pi)/waveLength
        f *= i + (waveLength/4)
        f = math.sin (f)
        f = math.asin (f)
        f *= (2 * waveAmplitude)/math.pi
        
        if (i % 100 == 0):
            print (f)
        
        setSampleValue (samples [i], f)
        
    return sound

#QUESTION 2.1
def mountains2 (sound):
    
    waveCount = 2
    samples = getSamples (sound)
    waveAmplitude = 32767                       #Height of the triangle wave
    waveLength = getLength (sound)/(waveCount)  #Units before the wave loops
    
    for i in range (0, len(samples)):
        mountainSample (samples[i], i, waveLength, waveAmplitude)
    
    return sound

#Method to handle single sample instance
def mountainSample (sample, i, p, a):
    f = (2 * math.pi)/p
    f *= i + (p/4)
    f = math.sin (f)
    f = math.asin (f)
    f *= (2 * a)/math.pi

    if (i % 100 == 0):
        print (f)
    setSampleValue (sample, f)