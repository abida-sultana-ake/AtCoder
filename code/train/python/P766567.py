n = int(input())
a = list(map(int, input().split()))

tmp = a[0]
cnt = 1
ans = 0
for i in range(1, n):
    if a[i] > tmp:
        cnt += 1
    else:
        ans += int(cnt * (cnt + 1) / 2)
       	cnt = 1
    tmp = a[i]
ans += int(cnt * (cnt + 1) / 2)
print(ans)