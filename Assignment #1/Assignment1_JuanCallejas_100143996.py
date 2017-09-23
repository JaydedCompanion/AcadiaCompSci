#Assignment1_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1113 X1
#Instructor: Darcy Benoit


#Student data shall be stored in a global multidimensional array
StudentData = []

#These variables are idices for each column
#And make it unnecessary to memorize the index of each column
Row_StudentID = 0
Row_GivenName = 1
Row_FamilyName = 2
Row_Assignment = 3
Row_Mark = 4


#Separate method for printing a column with (usually) correct spacing
def PrintRow (row):
    compilation = ""
    for i in range (0, len (row)):
        #Tabulate elements per row
        compilation += row[i] + "\t"
    print compilation

#Small tool to print the multidimensional array in neat, organized rows and columns
def PrintArrayTidy (array):
    for i in range (0, len (array)):
        PrintRow (array[i])

#Load the CSV file and parse it into a multidimensional array for easy access
def LoadAndParse ():
    File = pickAFile();
    FileContent = open (File, "rt").read()
    
    #Separate the FileContent by NewLine chars (\n) into an array of strings (Rows)
    Rows = FileContent.split ("\n")
    
    #Loop through every row
    for i in range (0, len (Rows)):
        #Separate the row by commas, and append the array of items in the row into a row in StudentData
        StudentData.append (Rows[i].split (","))
        print "Generated row #" + str(i) + " with " + str(len (StudentData[-1])) + " elements."
    print "\n"
    
    #Print the generated array to make sure it was properly generated
    PrintArrayTidy (StudentData)
        

def filterByAssignment (assignmentID):
    #Range should start at 1 (skip the first one) since the first row contains the column labels
    for i in range (1, len (StudentData)):
        if int(StudentData[i] [Row_Assignment]) == int (float (assignmentID)):
            PrintRow (StudentData[i])

def filterByStudent (studentID):
    #Range should start at 1 (skip the first one) since the first row contains the column labels
    for i in range (1, len (StudentData)):
        if int(StudentData[i] [Row_StudentID]) == int (float (studentID)):
            PrintRow (StudentData[i])

def assignmentAverage (assignmentID):
    valueSum = 0
    valueCount = 0
    #Range should start at 1 (skip the first one) since the first row contains the column labels
    for i in range (1, len (StudentData)):
        if int(StudentData[i] [Row_Assignment]) == int (float (assignmentID)):
            valueSum += int(StudentData [i] [Row_Mark])
            valueCount += 1
                    
    #Make sure we don't get an error if we attempt to divide by 0
    #Or in case that no values were found
    if (valueCount == 0):
        print "ERROR: No values found for assignment " + str (assignmentID)
        return;

    average = valueSum / valueCount
    print "Assignment #" + str (assignmentID) + " average: " + str (average)

def studentAverage (studentID):
    valueSum = 0
    valueCount = 0
    name = ""
    #Range should start at 1 (skip the first one) since the first row contains the column labels
    for i in range (1, len (StudentData)):
        if int(StudentData[i] [Row_StudentID]) == int (float (studentID)):
            #Get the student name for use in final print string
            name = StudentData[i] [Row_GivenName] + " " + StudentData[i] [Row_FamilyName]
            valueSum += int(StudentData [i] [Row_Mark])
            valueCount += 1
    
    #Make sure we don't get an error if we attempt to divide by 0
    #Or in case that no values were found
    if (valueCount == 0):
        print "ERROR: No values found for ID " + str (studentID)
        return;
    
    average = valueSum / valueCount
    print "Student ID " + str (studentID) + " (" + name + ") average: " + str (average)
    


#Call LoadAndParse when the program is loaded to assure that no other operation
#is attempted on an empty StudentData array
LoadAndParse()