n=int(input())
S,P = [],[]
for i in range(n):
    s,p = input().split()
    S.append(s);P.append(int(p))
w=sum(P)//2
ans="atcoder"
for i in range(n):
    if P[i]>w:
        ans = S[i]
        break
print(ans)
