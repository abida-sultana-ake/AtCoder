A, K = map(int, input().split())
t = A
cnt = 0
if K != 0:
    while t < 2*10**12:
        t += t * K + 1
        cnt += 1
else:
    cnt = 2*10**12 - A
print(cnt)