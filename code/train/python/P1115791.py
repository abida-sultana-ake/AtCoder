S, C = map(int, input().split())

if 2 * S < C:
    a = S + (C - 2 * S) // 4
else:
    a = max(C//2, 0)

print(a)
