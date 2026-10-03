from collections import Counter
n=int(input())
b=input()
c=[int(b[i]) for i in range(n)]
d=Counter(c)
s=sorted(list(d.values()))
if len(d.keys())==4:
 print(s[-1],s[0])
else:
 print(s[-1],0)