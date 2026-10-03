n = int(input())
P = list(map(int, input().split()))

ntbs = []

for i in range(n):
  if i+1 == P[i]:
    ntbs.append(i+1)

res = len(ntbs)
cnt = 1
for i in range(res-1):
  if ntbs[i]+1 == ntbs[i+1]:
    cnt += 1
  else:
    res -= (cnt // 2)
    cnt = 1

res -= (cnt // 2)
print(res)
