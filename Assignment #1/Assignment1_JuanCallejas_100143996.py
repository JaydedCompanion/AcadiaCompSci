#Assignment1_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1113 X1
#Instructor: Darcy Benoit


#Student data shall be stored in a global multidimensional array
StudentData = []

run = true
message = "What would you like to do?\n"

#These variables are idices for each column
#And make it unnecessary to memorize the index of each column
Row_StudentID = 0
Row_GivenName = 1
Row_FamilyName = 2
Row_Assignment = 3
Row_Mark = 4


#Separate method for printing a column with (usually) correct spacing
def PrintRow (row):
    print (CompileRow (row))
    
#Compile the row with nice spacing and formatting
def CompileRow (row):
    compilation = ""
    for i in range (0, len (row)):
        #Tabulate elements per row
        compilation += row[i] + "\t"
    return compilation

#Small tool to print the multidimensional array in neat, organized rows and columns
def PrintArrayTidy (array):
    for i in range (0, len (array)):
        PrintRow (array[i])

#Small tool to compile and return the multidimensional array in neat, organized rows and columns
def GetArrayTidy (array):
    compilation = ""
    for i in range (0, len (array)):
        compilation += CompileRow (array[i]) + "\n"
    return compilation

#Load the CSV file and parse it into a multidimensional array for easy access
def LoadAndParse ():
    
    File = pickAFile()
        
    print "Loaded file \"" + File + "\"\n"
    FileContent = open (File, "rt").read()
    
    #Separate the FileContent by NewLine chars (\n) into an array of strings (Rows)
    Rows = FileContent.split ("\n")
    
    #Loop through every row
    #TODO Identify and remove invalid/incorrectly formatted rows
    for i in range (0, len (Rows)):
        #Separate the row by commas, and append the array of items in the row into a row in StudentData
        if len((Rows[i].split(","))) != 5:
            print ("Row #" + str (i) + " was ignored as it does not contain 5 elements: \"" + str(Rows[i]) + "\"")
            continue
        
        StudentData.append (Rows[i].split (","))
        print "Generated row #" + str(i) + " with " + str(len (StudentData[-1])) + " elements."
    print "\nSuccessfully generated 2D array of spreadsheet!\n"
    
    #Print the generated array to make sure it was properly generated
    PrintArrayTidy (StudentData)
        

def filterByAssignment (assignmentID):
    #Range should start at 1 (skip the first one) since the first row contains the column labels
    rowCompilation = ""
    for i in range (1, len (StudentData)):
        if int(StudentData[i] [Row_Assignment]) == int (assignmentID):
            rowCompilation += CompileRow (StudentData[i]) + "\n"
            
    if rowCompilation == "":
        return "No data\n"
    
    return rowCompilation

def filterByStudent (studentID):
    #Range should start at 1 (skip the first one) since the first row contains the column labels
    rowCompilation = ""
    for i in range (1, len (StudentData)):
        if int(StudentData[i] [Row_StudentID]) == int (float (studentID)):
            rowCompilation += CompileRow (StudentData[i]) + "\n"
            
    if rowCompilation == "":
        return "No data\n"
    
    return rowCompilation

def assignmentAverage (assignmentID):
    valueSum = 0
    valueCount = 0
    #Range should start at 1 (skip the first one) since the first row contains the column labels
    for i in range (1, len (StudentData)):
        if int(StudentData[i] [Row_Assignment]) == int (float (assignmentID)):
            valueSum += float(StudentData [i] [Row_Mark])
            valueCount += 1
                    
    #Make sure we don't get an error if we attempt to divide by 0
    #Or in case that no values were found
    if (valueCount == 0):
        print "ERROR: No values found for assignment " + str (assignmentID)
        return "ERROR: No values found for assignment " + str (assignmentID)


    average = float (valueSum) / float(valueCount)
    return "Assignment #" + str (assignmentID) + " average: " + str (average)

def studentAverage (studentID):
    valueSum = 0
    valueCount = 0
    name = ""
    #Range should start at 1 (skip the first one) since the first row contains the column labels
    for i in range (1, len (StudentData)):
        if int(StudentData[i] [Row_StudentID]) == int (float (studentID)):
            #Get the student name for use in final print string
            name = StudentData[i] [Row_GivenName] + " " + StudentData[i] [Row_FamilyName]
            valueSum += float(StudentData [i] [Row_Mark])
            valueCount += 1
    
    #Make sure we don't get an error if we attempt to divide by 0
    #Or in case that no values were found
    if (valueCount == 0):
        print "ERROR: No values found for ID " + str (studentID)
        return "ERROR: No values found for ID " + str (studentID)
    
    average = float(valueSum) / float(valueCount)
    return "Student ID " + str (studentID) + " (" + name + ") average: " + str (average)
    


#Call LoadAndParse when the program is loaded to assure that no other operation
#is attempted on an empty StudentData array
LoadAndParse()


while run:
    
    #Do I need these assignments in new lines? no
    #Does it look nicer through? Hell yes
    message += "\n"
    message += "1: Filter by assignment\n"
    message += "2: Filter by student\n"
    message += "3: Show assignment average\n"
    message += "4: Show student average\n"
    message += "5: Show spreadsheet"
    
    #RequestIntegerInRange... doesn't use a slider. WHY??
    userInput = requestIntegerInRange (message, 1, 5);
    
    #Hey! Let's use a switch statement, this would be the best use case for it
    #Oh wait.... Thanks, jython.
    #Also, thanks to JES's awful GUI, we must replace all instances of \t to something else
    #since it just ignores tabs. AT LEAST REPLACE THEM WITH SPACES! C'mon
    if userInput == None:
        run = false
        break
    elif userInput == 1:
        message = filterByAssignment (requestInteger ("Enter assignment ID")).replace ("\t", " - ")
    elif userInput == 2:
        message = filterByStudent (requestInteger ("Enter student ID")).replace ("\t", " - ")
    elif userInput == 3:
        message = assignmentAverage (requestInteger ("Enter assignment ID")).replace ("\t", " - ") + "\n"
    elif userInput == 4:
        message = studentAverage (requestInteger ("Enter student ID")).replace ("\t", " - ") + "\n"
    elif userInput == 5:
        message = GetArrayTidy (StudentData).replace ("\t", " - ")
    else:
        message = "INVALID INPUT - OUT OF RANGE"

print "Success"