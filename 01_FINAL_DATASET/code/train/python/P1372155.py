N=int(input())
a=[]
a+=[int(input()) for i in range(N)]

B=enumerate(sorted(list(set(a))))
p = {v: i for i, v in B}
for i in range(N):
  print(p[a[i]])