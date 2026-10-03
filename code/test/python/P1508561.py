import sys
sys.setrecursionlimit(10**6)
n=int(input())
G=[[]for i in[0]*-~n]
for I in[lambda:map(int,input().split())]*~-n:a,b,c=I();G[a]+=(b,c),;G[b]+=(a,c),
q,k=I()
d=[0]*-~n
def f(v,p,u):
 d[v]=u
 for t,c in G[v]:p==t or f(t,v,u+c)
f(k,0,0)
for p in[print]*q:
 x,y=I()
 p(d[x]+d[y])