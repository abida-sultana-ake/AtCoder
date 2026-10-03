A, B, C = map(int, input().split())
lc, hc = min(A,B), max(A,B)
ans = max(C // lc, 0)
C -= ans * lc
ans += max(C // hc, 0)
print(ans)
