n = int(input())
a = list(map(int, input().split()))

total = [0, 0]
cnt = [0, 0]
for i in range(2):
    for j in range(n):
        total[i] += a[j]
        if (i+j)%2 == 0:
            if total[i] >= 0:
                cnt[i] += abs(total[i]+1)
                total[i] = -1
        else:
            if total[i] <= 0:
                cnt[i] += abs(total[i]-1)
                total[i] = 1
print(min(cnt))
