import subprocess, math
N = int(input())
cnt = [0]*(N+1)
 
for i in range(2, N+1):
  _i = i
  for j in range(2, N+1):
    while i%j == 0:
      i //= j
      cnt[j] += 1
    if _i < j:
      break
 
ans = 1
for n in filter(lambda n: n>0, cnt):
  ans *= n+1
print(ans%1000000007)