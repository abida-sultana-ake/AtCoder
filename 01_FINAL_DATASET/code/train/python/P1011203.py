import sys

a, b, x = map(int, input().split())
c = b // x
d = (a-1) // x

if a == 0 and b == 0:
    print(1)
    sys.exit()

elif a == 0 or b == 0:
    print(c + 1)
    sys.exit()

print(c - d)
