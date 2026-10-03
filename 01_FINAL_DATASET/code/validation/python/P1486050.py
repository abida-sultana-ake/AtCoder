import sys
input = sys.stdin.readline

N = int(input())
a = [int(i) for i in input().split()]

c = [0,0,0]

for i in a:
    if i%2==1:
        c[0]+=1
    elif i%4!=0:
        c[1]+=1
    else:
        c[2]+=1
b = []

last = None

isPossible = True

while (sum(c)):
    mn = 0
    if len(b) and b[-1]==1:
        mn = 1
    if len(b) and b[-1]==0:
        mn = 2

    n = -1
    for i in range(mn, 3):
        if c[i]:
            n = i
            break
    if n==-1:
        isPossible = False
        break

    c[n]-=1
    b.append(n)

if isPossible:
    print("Yes")
else:
    print("No")
