N = int(input())

ans = N // 2
if N % 2 == 1:
    ans += 1

print(ans)