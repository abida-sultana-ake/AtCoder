s = input()
if s.count(s[0]) == len(s):
    print("%d %d"%(1, len(s)))
else:
    for i in range(len(s)-2):
        if s[i:i+3].count(s[i]) >= 2:
            print("%d %d"%(i+1, i+3))
            exit()
    print("-1 -1")