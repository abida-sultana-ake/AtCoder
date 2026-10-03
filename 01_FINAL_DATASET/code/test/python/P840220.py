s = raw_input()
if s[0] == s[1]:
    print("1 2")
    exit()
    
for i in xrange(2,len(s)):
    if s[i] == s[i-1] or s[i] == s[i-2]:
        print(str(i-1) + " " + str(i+1)) 
        exit()
print ("-1 -1")

