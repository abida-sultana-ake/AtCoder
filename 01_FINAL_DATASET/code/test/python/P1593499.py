N=int(input())
T=[ int(input()) for _ in range(N) ]
S=sum(T)
ans = S
for bits in range(1 << N):
  t = 0
  for i in range(N):
    if (bits >> i & 1) == 1:
      t += T[i]
  ans=min(ans, max(t, S-t))
print(ans)