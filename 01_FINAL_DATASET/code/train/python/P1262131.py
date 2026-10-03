
N,W = map(int, input().split())


w=[0 for i in range(N)]
v=[0 for i in range(N)]

Wsum = [0 for i in range(N+1)]
Vsum = [0 for i in range(N+1)]

for i in range(N):
    w[i],v[i] = map(int, input().split())
    


Wmin = min(w)    
w.insert(0,"0")
v.insert(0,"0")
for i in range(N):
    Wsum[i+1] = Wsum[i] + w[i+1]
    Vsum[i+1] = Vsum[i] + v[i+1]



nap_memo ={}

def nap(i,W2):
    kagi = str(i) + ':' +str(W2)
    if kagi in nap_memo:
        return nap_memo[kagi]
    elif i ==0:
        r=0
    elif W2<Wmin:
        r=0
    elif W2 < w[i]:
        r=nap(i-1,W2)
    elif Wsum[i]<=W2:
        r=Vsum[i]
    else:
        r=max( nap(i-1,W2-w[i])+v[i],nap(i-1,W2))
        
    nap_memo[kagi]=r
    return r

print(nap(N,W))