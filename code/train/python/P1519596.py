A, B = map(int, input().split())

if A < 0 and B > 0:
    ans = abs((B - A) - 1)
else:
    ans = abs(B - A)
print(ans)
