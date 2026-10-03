s = input()
s= s[:-2]
 
while(True):
    s1, s2 = s[0:len(s)//2], s[len(s)//2:len(s)+1]
    if s1 == s2:
        print(len(s1)*2)
        break
 
    s = s[:-2]