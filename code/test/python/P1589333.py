# -*- encoding: utf-8 -*-
n = int(input().rstrip())
p = list(map(int, input().rstrip().split(' ')))

i, ans = 1, 0
while i <= n:
    if p[i - 1] == i:
        ans += 1
        i += 2
    else:
        i += 1

print(ans)