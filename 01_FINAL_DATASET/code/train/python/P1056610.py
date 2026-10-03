K, S = list(map(int, input().split()))

a = 0
for i in range(K + 1):
    r = S - i
    if i <= S and r <= K * 2:
        t = (r + 1) - max(0, r - K) * 2
        a += t

print(a)
