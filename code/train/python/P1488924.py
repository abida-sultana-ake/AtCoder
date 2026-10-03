from heapq import heappush, heappop

H, W = map(int, input().split())
N = int(input())
a = list(map(int, input().split()))

a_list = []
for i in range(N):
    heappush(a_list, (a[i], i + 1))

c = [[0] * W for _ in range(H)]
remain = 0
for y in range(H):
    if y % 2 == 0:
        for x in range(W):
            if remain == 0:
                remain, num = heappop(a_list)
            c[y][x] = num
            remain -= 1
    else:
        for x in reversed(range(W)):
            if remain == 0:
                remain, num = heappop(a_list)
            c[y][x] = num
            remain -= 1

for row in c:
    s = ' '.join([str(i) for i in row])
    print(s)