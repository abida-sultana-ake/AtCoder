N = int(input())
coins = [int(input()) for i in range(N)]

ans = 0.0
for c1 in range(N):
    div = 0
    for c2 in range(N):
        if c1 == c2: continue
        if coins[c1] % coins[c2] == 0:
            div += 1
    ans += (0.5 if div%2 == 1 else ((div+1)//2 + 1) / (div+1))
print(ans)
