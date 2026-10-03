[N,A,B]=[int(i) for i in input().split()]
x=[int(i) for i in input().split()]
a=0
for i in range(N-1):
  if (x[i+1]-x[i])*A>B:
     a+=B
  else:
     a+=(x[i+1]-x[i])*A
print(a)