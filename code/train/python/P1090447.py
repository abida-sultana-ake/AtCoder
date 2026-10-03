N, x = map(int, raw_input().split())
l    = map(int, raw_input().split())
cnt = 0

for i in range(N - 1):
    i += 1
    tmp1 = max(l[i-1] + l[i] - x, 0)
    cnt += tmp1
    l[i] = max(l[i] - tmp1, 0)

print(cnt)