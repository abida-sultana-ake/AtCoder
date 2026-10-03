import sys

stdin = sys.stdin

ni = lambda: int(ns())
na = lambda: list(map(int, stdin.readline().split()))
ns = lambda: stdin.readline()

n = ni()
s = ns().strip()
h = 0
minh = 0
for c in s:
    if c == "(":
        h += 1
    else:
        h -= 1
    minh = min(minh, h)
print("("*(-minh) + s + ")"*(h-minh))
