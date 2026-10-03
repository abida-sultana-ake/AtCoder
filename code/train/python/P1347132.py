N = int(input())
a = list(map(int, input().split()))
 
COLOR = 8
cnt, ov = [0] * COLOR, 0
for i in range(N):
    if a[i] < 3200:
        cnt[a[i] // 400] += 1
    else:
        ov += 1
 
used = 0
for c in cnt:
    if c > 0:
        used += 1

unused = N - used 
print(max(1, used), used + min(unused, ov))