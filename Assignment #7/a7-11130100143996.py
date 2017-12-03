#a7-1113-100143996.py
#By Juan Callejas
#COMP 1113 X1
#Instructor: Darcy Benoit

#If true, will enable numerous print statements throughout the program to communicate valuable info
#Call 'debugMode = true' from the JES command-line to get cool info
debugMode = false

#Main method to write the text parameter into the sound parameter,
def writeToSound (sound, text):
    
    if (len (text) >= 256):
        print ("This method does not (and isn't meant to) support strings longer than 256 characters.")
        print ("Method call cancelled.")
        return
    elif (len (text) <= 0):
        print ("Please pass a non-empty string.")
        print ("Method call cancelled.")
        return
    
    #Define a string containing the text parameter converted to binary
    binText = textToBin (text)
    
    #Define a string containing the length of the converted text, being converted to binary
    metadata = intToBin(len(binText))
    
    #Debug data.
    if (debugMode):
        print ("Text length " + str (len(binText)))
        print ("In binary " + str (metadata))
        print ("MetadataLength (should be 8): " + str (len (metadata)))
    
    #Warn if the metadata is longer than 8 bits
    if (len(metadata) > 8):
        print ("ERROR! METADATA EXCEEDS 8 BITS")
        print ("Method call cancelled.")
        return
    
    #Add the metadata to the beginning of the binary data that will be encoded in the audio
    binText = metadata + binText
    
    #Define sample array for easy access
    samples = getSamples (sound)
    
    #Index
    i = 0
    
    #Loop through every sample 
    for i in range (0, len (samples)):
        
        #Stop changing sample values if all the data has been encoded
        if (i >= len(binText)):
            break
        
        #Check whether the current sample value is odd or even, and if the binary sequence is 1, and adjust the sample value accordingly
        setTo = getSampleValue (samples [i])
        if (not getSampleValue (samples [i]) % 2 == 0):
            setTo -= 1
        if (binText [i] == "1"):
            setTo += 1
            
        #Apply the change to the sound
        setSampleValueAt (sound, i, setTo)
    
    #Return the sound
    return sound
        
#Main method to extract the string from the sound file
def extractFromSound (sound):
    
    #Define variables
    binary = ""         #Extracted binary data
    index = 8           #Keep track of the index to stop decoding data when we're done. Start at 8 since the first 8 characters are metadata and should be ignored
    metadata = ""       #Extracted binary metadata (8-bit binary value)
    dataLength = 0      #Integer representing encoded data length
    
    #Define samples array for easy access
    samples = getSamples (sound)
    
    for sample in getSamples (sound):
        
        #Read the metadata if isn't entirely present
        if (len (metadata) < 8):
            
            #Write binary sequence depending on whether the sample is odd or even
            if (not getSampleValue (sample) % 2 == 0):
                metadata += "1"
            else:
                metadata += "0"
            #Don't read non-metadata binary if we're still reading metadata
            continue
        
        #If we have all the metadata, convert to int
        if (len (metadata) == 8):
            dataLength = binToInt (metadata)
            if (debugMode):
                print (metadata)
                print ("Decoded data length: " + str (dataLength))
                print (binary)
            #Add an extra character to the end of the metadata binary sequence so we do not perform the conversion again
            metadata += " "
        
        #Write binary sequence depending on whether the sample is odd or even (again, but to a different variable)
        if (not getSampleValue (sample) % 2 == 0):
            binary += "1"
        else:
            binary += "0"
        #Increase the index
        index += 1
        
        #Stop extracting data if it's been completely extracted
        if (index >= dataLength + 8):
            break
            
    if (debugMode):
        print (binary)
    
    return binToText (binary)
    
    
#Convert a string to binary
def textToBin (string):
    
    comp = ""
    for char in string:
        #Convert the character to int, convert that int into binary, and add it to the binary sequence
        comp += intToBin (ord(char))
        if (debugMode):
            print (str(char) + " " + str(ord(char)))

    return comp
    

#Convert a single integer into binary
def intToBin (num):
    #If the int is 0, then the binary sequence is 00000000
    if num == 0:
        return "00000000"
    result = ""
    #Convert int to binary
    while (num != 0):
        mod = num % 2
        num = num / 2
        result = str(mod) + result
    #Pad the left side of the 8-bit binary sequence so it is always 8 characters long
    return result.zfill (8)

#Convert binary to text  
def binToText (binary):
    byte = ""   #A binary sequence that, when 8 bits long, is converted to a character
    comp = ""   #The converted string
    for bit in binary:
        byte += bit
        #If we've collected 8 bits, convert them to a character
        if len (byte) >= 8:
            comp += chr (binToInt (byte))
            byte = ""
    #Return the compilation
    return comp

#Convert binary to integer
def binToInt (binary):
    empty = ""
    counter = -1
    n = len(binary)
    u = 0
    if binary == 0:
        return str(0)
    for digits in binary:
        empty = empty + " " + digits
        data = empty.split()
        counter += 1
        n -= 1
        u += int(data[counter]) * (2**(n))
    if (debugMode):
        print (u)
    return u