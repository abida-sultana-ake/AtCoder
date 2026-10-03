S = input()
T = input()


def pre_(X):
    d= dict()
    d[0]=0
    tmp = 0
    for i,s in enumerate(X):
        if s=="A":
           tmp +=1
        else:
            tmp+=2
        d[i+1]=tmp
    return d

Sx = pre_(S)
Tx = pre_(T)


for a,b,c,d in [list(map(int,input().split())) for _ in range(int(input()))]:
    """
    print(Sx[a-1])
    print(Sx[b])
    print(Tx[c-1])
    print(Tx[d])
    """
    print( "YES" if (((Sx[a-1]-Sx[b])- (Tx[c-1]-Tx[d]))%3==0) else "NO")