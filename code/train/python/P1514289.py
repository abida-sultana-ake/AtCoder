N, H = map(int, input().split())
A, B, C, D, E = map(int, input().split())

ans = []
"""
for i in range(N+1):
    for j in range(N+1):
        x = i
        y = j
        if H + (B * x) + (D * y) - (N - x - y) * E > 0 and x + y <= N:
            ans.append((x*A) + (y*C))
"""

for x in range(N+1):
    y = max(0, int(((N - x) * E - H - (B * x)) // (D + E)) + 1)
    if x + y <= N:
        ans.append((x*A) + (y*C))

print(min(ans))
