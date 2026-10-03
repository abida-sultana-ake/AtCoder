s = [int(i) for i in input().split()]
s.sort()
if s[0] == s[1] :
    print (s[2])
else :
    print (s[0])