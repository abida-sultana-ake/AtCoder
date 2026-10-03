H, W = map(int, input().split())
N = int(input())
a = list(map(int, input().split()))

out = [[0 for _ in range(W)] for _ in range(H)]

index = [0, 0]
sign = 1
for color in range(N):
    for number in range(a[color]):
        out[index[0]][index[1]] = color + 1
        if index[0] == H - 1 and sign == 1:
            index[1] += 1
            sign = -1
        elif index[0] == 0 and sign == -1:
            sign = 1
            index[1] += 1
        else:
            index[0] += sign

for i in range(H):
    [print(x, end=' ') for x in out[i]]
    print()