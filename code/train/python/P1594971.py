N = int(input())
a = [int(input())-1 for i in range(N)]
cnt = 0
i = 0
while i != 1:
    i = a[i]
    cnt += 1
    if cnt == N:
        break
if cnt == N:
    print(-1)
else:
    print(cnt)