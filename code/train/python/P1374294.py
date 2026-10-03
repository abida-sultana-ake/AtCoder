x, a, b = map(int, input().split())

z = a - b

if z >= 0:
    print("delicious")
elif z*(-1) <= x:
    print("safe")
else:
    print("dangerous")
