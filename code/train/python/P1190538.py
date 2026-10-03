[n,a,b]=[int(i) for i in input().split()]
x=[int(i) for i in input().split()]
y=[]
for i in range(n-1):
 z=(x[i+1]-x[i])*a
 if z<b:
   y.append(z)
 else:
   y.append(b)
print(sum(y))