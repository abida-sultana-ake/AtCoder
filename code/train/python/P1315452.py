N = int(input())
a, b = map(int, input().split())
K = int(input())
P = list(map(int, input().split()))
ans = "YES"
s = []

if a in P or b in P:
    ans = "NO"
else:
    for i in range(len(P)):
        if P[i] in s:
            ans = "NO"
        else:
            s.append(P[i])

print(ans)            