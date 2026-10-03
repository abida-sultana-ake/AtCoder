import sys, math, itertools, collections, heapq

sys.setrecursionlimit(10 ** 7)
pinf = float("inf")
ninf = -float("inf")

n = int(input())
A = [list(map(int, input().split())) for _ in range(n)]

for i in range(n):
    A[i][i] = pinf

ans = 0
for i in range(n):
    A_i = A[i]
    for j in range(i):
        A_j = A[j]
        min_d = min([A_i[n] + A_j[n] for n in range(n)])
        if A[i][j] > min_d:
            # 他のノード経由で最小コストを更新する場合
            print(-1)
            exit()
        elif A[i][j] < min_d:
            # 他のノード経由が非効率なpathの場合、i,j間に直接のパスを作る
            ans += A[i][j]

print(ans)