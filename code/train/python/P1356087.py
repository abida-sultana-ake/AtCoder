import sys
import math

sys.setrecursionlimit(100000000)

n = int(input())
s = int(input())

def f(b, n):
    if n<b:
        return n
    else:
        return f(b, n//b) + n%b

if s > n:
    print(-1)
elif s==n:
    print(s+1)
else:
    for b in range(2, math.ceil(math.sqrt(n))+1):
        if f(b, n)==s:
            print(b)
            break
    else:
        for d in range(math.floor(math.sqrt(n)), 0, -1):
            if (n-s)%d==0 and f((n-s)//d+1, n)==s:
                print((n-s)//d+1)
                break
        else:
            print(-1)