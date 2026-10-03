from bisect import bisect as bis

n = int(input())
cs = [int(input()) for _ in range(n)]

lis = []
for i in range(n):
    idx = bis(lis, cs[i])
    if idx >= len(lis):
        lis.append(cs[i])
    else:
        lis[idx] = cs[i]

ans = n - len(lis)
print(ans)