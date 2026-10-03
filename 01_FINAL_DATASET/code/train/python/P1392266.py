a, b, c = input().split()

v1 = int(a) + int(b)
v2 = int(a) + int(c)
v3 = int(b) + int(c)

print(min(v1, v2, v3))
