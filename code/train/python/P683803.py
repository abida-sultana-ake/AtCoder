def check(k):
    if R < k or B < k:
        return False
    return (R - k) // (x - 1) + (B - k) // (y - 1) >= k


R, B = map(int, input().split())
x, y = map(int, input().split())

l = 0
r = 10**20
while r - l > 1:
    m = (l + r) // 2
    if check(m):
        l = m
    else:
        r = m

print(l)
