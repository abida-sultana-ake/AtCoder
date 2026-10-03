N = int(input())
ans = 1 << 20
for a in range(N//10+2):
    b = max(0, N - 10*a)
    ans = min(ans, a*100+15*b)
print(ans)