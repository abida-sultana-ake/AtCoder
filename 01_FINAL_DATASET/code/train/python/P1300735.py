from heapq import *
r=reversed
N=int(input())
A=list(map(int,input().split()))
def w(L):
	q=L[:N]
	heapify(q)
	s=sum(q)
	yield s
	for e in L[N:2*N]:
		s+=e-heappushpop(q,e)
		yield s
print(max(map(sum,zip(w(A),r(list(w([-a for a in r(A)])))))))