import sys
sys.setrecursionlimit(10**5)


N,M = map(int,raw_input().split(" "))
path = [[] for i in range(N)]
for i in range(M):
    a,b = map(int,raw_input().split(" "))
    a-=1
    b-=1
    path[a].append((b,i))
    path[b].append((a,i))




vmemo = [0 for i in range(N)]
ememo = [1 for i in range(M)]

stk = []

def loop(pos,last_edge):
    global stk,vmemo,ememo
    
    if vmemo[pos]:
        for i in range(len(stk)-1,-1,-1):
            _v,_e = stk[i]
            ememo[_e] = 0
            if _v == pos:
                return pos
    
    vmemo[pos] = 1
    for v,e in path[pos]:
        if e != last_edge:
            stk.append((pos,e))
            _p = loop(v,e)
            stk.pop()
    vmemo[pos] = 0

    return -1



loop(0,-1)

print(ememo.count(1))
