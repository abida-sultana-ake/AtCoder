N = int(input())
a = list(map(int, input().split()))

N = 10**5
cnt = [0 for i in range(N+2)]
# index 0 == -1
for i in a:
    cnt[i] += 1
    cnt[i+1] += 1
    cnt[i+2] += 1

print(max(cnt))
