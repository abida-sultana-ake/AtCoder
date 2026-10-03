def ri(): return int(input())
def rli(): return list(map(int, input().split()))
def ris(): return list(input())
def pli(a): return "".join(list(map(str, a)))

N, M = rli()
keiro = [[False for i in range(2)] for j in range(N+1)]
for i in range(M):
    a, b = rli()
    if(b == 1 or b == N):
        keiro[a][1 if b == 1 else 0] = True
    elif(a == 1 or a == N):
        keiro[b][1 if a == 1 else 0] = True

flag = False
for i in range(2, N):
    if(keiro[i][1] and keiro[i][0]):
        flag = True
if(flag):
    print("POSSIBLE")
else:
    print("IMPOSSIBLE")