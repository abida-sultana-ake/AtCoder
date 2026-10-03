N = int(input())
X, Y, C = [], [], []
for _ in range(N):
    x, y, c = list(map(int, input().split()))
    X.append(x)
    Y.append(y)
    C.append(c)

def check(cost):
    left, right = -10**5, 10**5
    for x, c in zip(X, C):
        left = max(left, x - cost / c)
        right = min(right, x + cost / c)
    if left > right:
        return False
    left, right = -10**5, 10**5
    for y, c in zip(Y, C):
        left = max(left, y - cost / c)
        right = min(right, y + cost / c)
    if left > right:
        return False
    return True

left, right = -1, 10 ** 5 * 10 ** 3 + 1
for _ in range(100):
    mid = (left + right) / 2
    if check(mid):
        right = mid
    else:
        left = mid
print(right)
