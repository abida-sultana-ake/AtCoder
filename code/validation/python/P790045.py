N,M=[int(i) for i in input().strip().split()]
a=list(range(N))
memo={}
m=[[] for i in range(N)]
for i in range(M):
    x,y=[int(i)-1 for i in input().strip().split()]
    m[y].append(x)
def calc(A,M):
    ret=0
    if("_".join(map(str,A)) in memo):
        return memo["_".join(map(str,A))]
    for i in A:
        flg=True
        a=A[:]
        a.remove(i)
        if(not a):
            return 1
        for j in a:
            if(M[i] and j in M[i]):
                flg=False
                break
        if(flg):
            ret += calc(a,M)
    memo["_".join(map(str,A))]=ret
    return ret
print(calc(a,m))
