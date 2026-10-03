H, W = map(int, input().split())
N = int(input())
A = list(map(int, input().split()))

HW = [[0 for w in range(W)]for h in range(H)]
C = []

count = 1
for a in A:
    for i in range(a):
        C.append(count)
    count += 1

count = 0
for h in range(H):
    if h % 2 == 0:
        for w in range(W):
            HW[h][w] = C[count]
            count += 1
    else:
        for w in range(W):
            HW[h][W-w-1] = C[count]
            count += 1

for hw in HW:
    for s in hw:
        print(s, end=" ")
    print()