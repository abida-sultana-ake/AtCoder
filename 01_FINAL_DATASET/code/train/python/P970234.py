# coding: utf-8

s = input().strip()
cur = s[0]
cnt = 0
for c in s:
    if c != cur:
        cur = c
        cnt += 1
print(cnt)
