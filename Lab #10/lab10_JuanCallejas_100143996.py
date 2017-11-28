#lab10_JuanCallejas_100143996.py
#By Juan Callejas
#COMP 1110L X1
#Instructor: Greg Lee

#QUESTION 1
def masterFunction (word1, word2, num):
    #What's even the point of this??
    numberChecker (word1, word2, num)
    
    
def numberChecker (word1, word2, num):
    
    #Assignment spec indicates that nothing should happen if the number passed is 10 (since '> 10' was used instead of '>= 10')
    if num < 8:
        wordPrinterSmall (word1, num)
    elif num == 8 or num == 9:
        numberPrinter (num)
    elif num > 10:
        wordPrinterBig (word1, word2, num)
        
#Handle printing if num is less than 8        
def wordPrinterSmall (word, num):
    comp = ""
    for i in range (0, num):
        comp += word
        if (i < num - 1):
            comp += "+"
    print (comp)
#Handle printing if num is 8 or 9
def numberPrinter (num):
    print ("Just the number " + str (num))
#Handle printing if num is greater than 10
def wordPrinterBig (word1, word2, num):
    comp = ""
    for i in range (0, num):
        comp += word1
        if (i < num - 1):
            comp += "-"
    print (comp)
    
    comp = ""
    num += 1
    for i in range (0, num):
        comp += word2
        if (i < num - 1):
            comp += "-"
    print (comp)