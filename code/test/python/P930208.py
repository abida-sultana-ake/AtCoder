moveList = raw_input()
print (len([x for x in moveList if x == 'g']) 
       - len([x for x in moveList if x == 'p']))/2 