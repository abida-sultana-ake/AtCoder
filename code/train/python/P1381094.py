
import sys
sys.setrecursionlimit(int(2e9))

def distance(P, p1, p2):
    return min(abs(P[p1][1]-P[p2][1]), abs(P[p1][2]-P[p2][2]))
def root(CI, p):
    if CI[p] == p:
        return p
    else:
        CI[p] = root(CI, CI[p])
        return CI[p] 

N = int(input())
P = [[j]+[int(i) for i in input().split(' ')] for j in range(N)]
sortX = sorted(P,key=lambda x:x[1])
sortY = sorted(P,key=lambda x:x[2])
EX = [[sortX[i][0], sortX[i+1][0], distance(P,sortX[i][0],sortX[i+1][0])] for i in range(N-1)]
EY = [[sortY[i][0], sortY[i+1][0], distance(P,sortY[i][0],sortY[i+1][0])] for i in range(N-1)]
E = EX + EY
E = sorted(E, key=lambda x:x[2])
CI = [i for i in range(N)]
disSum = 0
for e in E:
    s,l = min(e[0],e[1]),max(e[0],e[1])
#     if CI[s] != CI[l]:
#         CI = list(map(lambda x:CI[s] if x == CI[l] else x, CI))
#         disSum += e[2]
    if root(CI, s) != root(CI, l):
        CI[root(CI, l)] = root(CI, s)
        disSum += e[2]
print(disSum)
    