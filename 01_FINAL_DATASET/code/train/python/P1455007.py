N = int(input())
a = []
for _ in range(N):
    a.append(int(input()))

cnt = 0
s = a[0]

if s == 2:
    print(cnt + 1)
else:
    for i in range(N):
        s = a[s-1]
        cnt += 1
        if s ==  2:
            print(cnt + 1)
            break
        if i == N-1:
            print('-1')