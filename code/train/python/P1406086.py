# coding: utf-8

s, n = input(), int(input())
for i in range(n):
    l, r = [int(i) for i in input().split()]
    x = s[:l-1]
    y = s[l-1:r]
    y = y[::-1]
    z = s[r:]
    s = x+y+z
print(s)