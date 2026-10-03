# coding: utf-8

s, k = input(), int(input())
lis = set()
for i in range(len(s)-k+1):
    lis.add(s[i:i+k])

print(len(lis))