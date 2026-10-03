import subprocess, math
N = int(input())
cnt = [0]*(N+1)

for i in range(2, N+1):
  s = str(i)
  f = [int(n) for n in subprocess.check_output(["factor", s])[len(s)+1:].strip().split()]
  for n in set(f):
    cnt[n] += f.count(n)

ans = 1
for n in filter(lambda n: n>0, cnt):
  ans *= n+1
print(ans%1000000007)