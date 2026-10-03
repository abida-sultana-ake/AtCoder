import sys
def p(y,x):
    ret=False
    if(W!=1 and H!=1):
        if(S[y][x]=='#'):
            if(y-1>=0 and x-1>=0 and S[y-1][x-1]=='#'):
                if(S[y][x-1]=='#' and S[y-1][x]=='#'):
                    ret=True
            if(y-1>=0 and x+1<W and S[y-1][x+1]=='#'):
                if(S[y][x+1]=='#' and S[y-1][x]=='#'):
                    ret=True
            if(y+1<H and x-1>=0 and S[y+1][x-1]=='#'):
                if(S[y][x-1]=='#' and S[y+1][x]=='#'):
                    ret=True
            if(y+1<H and x+1<W and S[y+1][x+1]=='#'):
                if(S[y][x+1]=='#' and S[y+1][x]=='#'):
                    ret=True
    elif(H==1 and W==1):
        ret=True
    elif(H==1):
        if(S[y][x]=='#'):
            if(x-1>=0 and S[y][x-1]=='#'):
                ret=True
            if(x+1<W and S[y][x+1]=='#'):
                ret=True
    elif(W==1):
        if(S[y][x]=='#'):
            if(y-1>=0 and S[y-1][x]=='#'):
                ret=True
            if(y+1<H and S[y+1][x]=='#'):
                ret=True
    if(S[y][x]=='.'):
        ret = True
    return ret


def b(y,x):
    return 0>y or y>=H or 0>x or x>=W or S[y][x]=='#'


def a(y,x):
    if(b(y-1,x-1) and b(y-1,x) and b(y-1,x+1) and 
       b(y,  x-1) and b(y,  x) and b(y,  x+1) and 
       b(y+1,x-1) and b(y+1,x) and b(y+1,x+1)):
        A[y][x]='#'


H,W=[int(x) for x in input().strip().split()]
S=[]
A=[["." for j in range(W)] for i in range(H)]

for i in range(H):
    S.append(list(input().strip()))

for i in range(H):
    for j in range(W):
        if(p(i,j)):
           a(i,j) 
        else:
            print("impossible")
            sys.exit()

print("possible")
for i in range(H):
    print("".join(A[i]))