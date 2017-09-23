def CheckAlpha (string):
    #Answer a string that contains a human-friendly answer format
    answer = ""
    booleans = string.isalpha()
    if string.isalpha():
        #Use \" for printing quotation marks in the Print method
        answer = "\"" + string + "\" is an alpha-only string"
    else:
        answer = "\"" + string + "\" contains non-alpha characters"
    #Print the answer
    print (answer)
    
quotes = """  "hhhhh"  """
