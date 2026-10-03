#!/usr/bin/python3

a = list(map(int, input().split()))

a.sort()

if a == [5, 5, 7]:
    print("YES")
else:
    print("NO")
