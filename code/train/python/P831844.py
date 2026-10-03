import sys
a = []
for line in sys.stdin:
    a.append(str(line))
b=len(a)
d=[]
for i in xrange(b):
    c=map(str,a[i][:-1].split(" "))
    d.append(c)
if (d[0][0] in d[1]) or (d[0][1] in d[1]):
    print("YES")
else:
    print("NO") 