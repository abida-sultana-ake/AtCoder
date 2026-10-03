A, B = list(map(int, input().split()))
ans = B - A
if A * B < 0:
    ans -= 1
print(ans)