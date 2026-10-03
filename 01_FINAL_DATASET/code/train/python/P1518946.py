x, y = map(int, input().split())

k = int(input())

if k <= y:
    ans = x + k
else:
    ans = x - k + (2 * y)
print(ans)
