import sys
sys.setrecursionlimit(1000000)

N = int(input())
adj = [[] for n in range(N)]
for i in range(N-1):
  a, b = [int(n)-1 for n in input().split()]
  adj[a].append(b)
  adj[b].append(a)



def dfs(now, cost, dic):
  dic[now] = cost
  for nx in adj[now]:
    if nx not in dic:
      dfs(nx, cost+1, dic)

dist_f = {}
dist_s = {}

dfs(0, 0, dist_f)
dfs(N-1, 0, dist_s)


f_cnt = 0
for  i in range(N):
  if dist_f[i] <= dist_s[i]:
    f_cnt += 1

if f_cnt > N-f_cnt:
  print("Fennec")
else:
  print("Snuke")