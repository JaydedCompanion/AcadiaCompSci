#lab3_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee/Darcy Benoit

def getStory (filename):
    
    #Open the file provided through the method parameter
    FileContent = open (filename, "rt").read()
    
    #Separate the FileContent by NewLine chars (\n) into an array of strings (Lines)
    Lines = FileContent.split ("\n")
    
    for i in range (0, len (Lines)):
        #Offset the index by -2.... because reasons.
        if (i-2) % 3 == 0:
            print Lines[i]