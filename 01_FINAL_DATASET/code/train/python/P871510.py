N,K=map(int,input().split())
Ds=list(input().split())
Di=list(map(int,Ds))
nex=[1]*10
for i in reversed(Di):
    nex[i-1]=nex[i]+1

def check(n):
    ns = str(N)
    for nss in ns:
        if nss in Ds:
            return False
    return True

def next(i):
    global N
    ns='{0:0>5}'.format(N)
    t=nex[int(ns[i])]
    pp=int(ns[i])+t
    if pp >=10:
        t=t-10
        N+=t*(10**(4-i))
        next(i-1)
    else:
        N+=t*(10**(4-i))

while not check(N):
    next(4)
print(N)