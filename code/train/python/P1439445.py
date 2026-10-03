# coding: utf-8

n = int(input())
table = [list(input()) for _ in range(n)]
[[print(table[y][x]) if y==0 else print(table[y][x], end='') for y in range(n)[::-1]] for x in range(n)]