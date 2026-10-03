n = int(input())
hand = [[0 for j in range(100001)] for i in range(3)]
pls = []
for i in range(n):
    r,h = map(int, input().split())
    h -= 1
    pls.append((r,h))
    hand[h][r] += 1
acc = [0 for i in range(100001)]
for i in range(1, 100001):
    acc[i] = acc[i-1] + hand[0][i] + hand[1][i] + hand[2][i]

for i in range(n):
    r,h = pls[i]
    w = acc[r-1]+hand[(h+1)%3][r]
    d = hand[h][r] - 1
    l = n - 1 - w - d 
    print(w, l, d)
