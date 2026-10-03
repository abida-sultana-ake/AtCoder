S, C = map(int,input().split())
ans = 0
x1 = min(S, C//2)
ans += x1
S -= x1
C -= x1 * 2
ans += C // 4
print(ans)
