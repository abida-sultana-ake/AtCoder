import sys, math, itertools, collections, heapq
sys.setrecursionlimit(10 ** 7)
pinf = float("inf")
ninf = -float("inf")

n = int(input())
ali = list(map(int, input().split()))

sum = 0
for a in ali:
        sum += a

cum = 0
min = pinf
cache = pinf
ali.pop()

for a in ali:
        tmp = cum + a
        dif = abs(sum/2 - tmp)
        if min > dif:
                min = dif
        #if cache < dif:
        #       break
        #else:
        cache = dif
        cum = tmp

print(int(min * 2))