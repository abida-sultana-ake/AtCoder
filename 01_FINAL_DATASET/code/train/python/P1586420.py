import scipy.sparse as S
import itertools as i
m=lambda:map(int,input().split())
N,M,_=m()
R=m()
G=S.dok_matrix((N,N))
G.update((lambda x:((next(x)-1,next(x)-1),next(x)))(m())for _ in range(M))
G=S.csgraph.floyd_warshall(G.tocsr(),directed=0)
print(int(min(sum(G[a-1,b-1]for a,b in zip(p[1:],p))for p in i.permutations(R))))