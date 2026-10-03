import itertools as t;c=t.combinations
f=lambda:map(int,input().split());n,m=f();d={tuple(f())for _ in range(m)};r=range(1,n+1)
for a in r:
 if not any(d>=set(c(o,2))for o in c(r,a+1)):print(a);break