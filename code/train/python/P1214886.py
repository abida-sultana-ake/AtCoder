N, M = map(int, input().split())
Xs = list(map(int, input().split()))
Ys = list(map(int, input().split()))

MOD = 1000000007

w = Xs[1] - Xs[0]
ws = [w]
for i in range(2, N):
    ws.append((i * (Xs[i] - Xs[i - 1]) + ws[-1]) % MOD)
    w += ws[-1]
    w %= MOD
   
h = Ys[1] - Ys[0]
hs = [h]
for i in range(2, M):
    hs.append((i * (Ys[i] - Ys[i - 1]) + hs[-1]) % MOD)
    h += hs[-1]
    h %= MOD

ans = w * h % MOD
print(ans)
