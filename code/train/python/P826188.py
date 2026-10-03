import sys
a = []
for line in sys.stdin:
    a.append(str(line))
b=len(a)
d=[]
for i in xrange(1,b):
    c=map(str,a[i][:-1].split(" "))   
    d.append(c[0])
e=sorted(d)
ans="".join(e)
print(ans)