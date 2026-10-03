import sys

stdin = sys.stdin

ni = lambda: int(ns())
na = lambda: list(map(int, stdin.readline().split()))
ns = lambda: stdin.readline()

a,b,c = na()
if (a*100+b*10+c) % 4 == 0:
    print("YES")
else:
    print("NO")