S = []
P = []

N = int(input())
for i in range(N):
    s, p= map(str, input().split())
    P.append(int(p))
    S.append(s)

ans = sorted(P)
ans.reverse()
goukei = sum(P)
if goukei / 2 < ans[0]:
    b = P.index(ans[0])
    print(S[b])
else:
    print("atcoder")
