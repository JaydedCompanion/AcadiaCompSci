#a7-1113-100143996.py
#By Juan Callejas
#COMP 1113 X1
#Instructor: Darcy Benoit

def writeToSound (sound, text):
    
    binText = textToBin (text)
    
    samples = getSamples (sound)
    
    i = 0
    
    for i in range (0, len (samples)):
        
        if (i >= len(binText)):
            break
        
        setTo = getSampleValue (samples [i])
        
        if (not getSampleValue (samples [i]) % 2 == 0):
            setTo -= 1
            
        if (binText [i] == "1"):
            setTo += 1
            
        setSampleValueAt (sound, i, setTo)
        
    return sound
        
        
def extractFromSound (sound):
    
    binary = ""
    index = 0
    
    for sample in getSamples (sound):
        
        if (not getSampleValue (sample) % 2 == 0):
            binary += "1"
        else:
            binary += "0"
            
        index += 1
        
        if (index >= 2048):
            break
            
    print ("Converted 2048 samples of sound to binary")
    
    return binToText (binary)
    
    
#Convert a string of less than 256 characters to binary
def textToBin (string):
    
    comp = ""
    for char in string:
        comp += intToBin (ord(char))
        print (str(char) + " " + str(ord(char)))

    return comp
    

#Convert a single integer into binary
def intToBin (num):
    
    if num == 0:
        return str(0)
    
    result = ""
    
    while (num != 0):
        
        mod = num % 2
        num = num / 2
        
        result = str(mod) + result
     
    return result.zfill (8)


#Convert binary to text  
def binToText (binary):
    
    byte = ""
    comp = ""
    
    for bit in binary:
        
        byte += bit
        
        if len (byte) >= 8:
            
            comp += chr (binToInt (byte))
            
            byte = ""
            
    print str(comp)
    
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
        empty = empty + " " +digits
        data = empty.split()
        counter += 1
        #print counter
        n -= 1
        u += int(data[counter]) * (2**(n))
        
    print (u)

    return u