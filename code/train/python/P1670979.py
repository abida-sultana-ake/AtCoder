#http://abc003.contest.atcoder.jp/
# -*- coding: utf-8 -*-
n =int(input())
result = 0
for i in range(n):
    result += (i + 1) * 10000 * 1 / n

print(int(result))
