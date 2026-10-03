# coding: utf-8

n_s, n_c = map(int, input().split())
ans = 0

if n_c >= n_s * 2:
    ans += n_s
    rest_c = n_c - n_s * 2
    ans += rest_c // 4
else:
    ans += n_c // 2

print(ans)