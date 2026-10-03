N, x = map(int, input().split())
l = list(map(int, input().split()))
cnt = 0

for i in range(N - 1):
    tmp1 = max(l[i] + l[i+1] - x, 0)
    cnt += tmp1
    l[i+1] = max(l[i+1] - tmp1, 0)

print(cnt)