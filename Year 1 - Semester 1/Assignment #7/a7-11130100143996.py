#a7-1113-100143996.py
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

