n,m = map(int, input().split())

deg = [0]*n

for i in range(m):
  a,b = map(int,input().split())
  deg[a-1] += 1
  deg[b-1] += 1

print('\n'.join(map(str,deg)))