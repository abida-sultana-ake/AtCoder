list = str(input()).split()
if int(list[0]) == int(list[1]):
   if int(list[1]) == int(list[2]):
      print(1)
   else :
      print(2)
elif int(list[0]) == int(list[2]):
   print(2)
elif int(list[1]) == int(list[2]):
   print(2)
else:
   print(3)