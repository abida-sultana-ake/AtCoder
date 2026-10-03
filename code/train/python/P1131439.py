N=int(input())
S=[]
P=[]
for _ in range(N):
  s, p = input().split()
  S.append(s)
  P.append(int(p))
K=sum(P)
ans='atcoder'
for i in range(N):
  if K < P[i]*2:
    ans = S[i]
print(ans)
