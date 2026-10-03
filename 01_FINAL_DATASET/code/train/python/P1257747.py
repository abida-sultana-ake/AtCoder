import sys
N, K = map(int, input().split())

As = [int(input()) for i in range(N)]

if K == 1:
    print(N)
    sys.exit()

Ds = [As[i+1] - As[i] for i in range(len(As)-1)]

prevIndex = -1
cnt = 0
for i in range(len(Ds)):
    if Ds[i] > 0:
        if prevIndex == -1:
            prevIndex = i
        if i - prevIndex >= K - 2:
            cnt += 1

    elif prevIndex != -1:
        prevIndex = -1

print(cnt)
