H,W = map(int,input().split())
N = int(input())
A = list(map(int,input().split()))

ans = [[None]*W for _ in range(H)]

x,y = 0,0
d = 1
for c,a in enumerate(A):
  c += 1

  for i in range(a):
    if x < 0 or x >= W:
      y += 1
      d = -d
      x += d
    ans[y][x] = c
    x += d

for a in ans:
  print(' '.join(map(str,a)))
