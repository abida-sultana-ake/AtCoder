a = input()
s = list(a)
for i in range(len(a)) :
  if i == 0 : 
    print(s[i].upper(), end = '')
  else :
    print(s[i].lower(), end = '')
print()