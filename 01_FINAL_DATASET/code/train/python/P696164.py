from functools import reduce

x1, y1, r = [int(x) for x in input().split()]
x2, y2, x3, y3 = [int(x) for x in input().split()]

print('NO' if x2 + r <= x1 <= x3 - r and y2 + r <= y1 <= y3 - r else 'YES')
print('NO' if reduce(lambda p, P: p and (P[0] - x1) ** 2 + (P[1] - y1) ** 2 <= r * r, [(x2, y2), (x2, y3), (x3, y2), (x3, y3)], True) else 'YES')