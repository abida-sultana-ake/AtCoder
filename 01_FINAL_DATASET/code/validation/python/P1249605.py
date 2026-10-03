N, T = map(int, input().split())
ts = list(map(int, input().split()))

ans = 0
tmp_now = ts[0] + T
tmp_start = ts[0]

for i in range(1, N):
    # print(tmp_now, tmp_start)
    if ts[i] <= tmp_now:
        tmp_now = ts[i] + T
    else:
        ans += tmp_now - tmp_start
        tmp_now = ts[i] + T
        tmp_start = ts[i]

ans += tmp_now - tmp_start

print(ans)

