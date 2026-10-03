a, b = map(int, input().split())
d = abs(a - b)
t = (d + 2) // 10
d -= 10 * t
d = abs(d)
f = (d + 1) // 5
d -= 5 * f
print(t + f + abs(d))
