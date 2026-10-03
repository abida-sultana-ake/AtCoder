# coding: utf-8
# Here your code !
n, s, t =  map(int, input().split())
cnt = 0
for i in range(n):
    if i == 0:
        w = int(input())
    else:
        w += int(input())
    if s <= w <= t:
        cnt += 1
print(cnt) 
