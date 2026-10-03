from itertools import combinations as c
f=lambda:map(int,input().split());n,m=f();r=range;d={tuple(f())for _ in r(m)}    
for a in r(1,n+2):    
 if not any(d>=set(c(o,2))for o in c(r(1,n+1),a)):print(a-1);break