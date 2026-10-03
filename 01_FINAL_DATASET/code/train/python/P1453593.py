import itertools as t;c=t.combinations
f=lambda:map(int,input().split());n,m=f();d={tuple(f())for _ in range(m)};r=range(1,n+1)
all(1 if any(d>=set(c(o,2))for o in c(r,a+1))else print(a)for a in r)