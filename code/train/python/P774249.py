import numpy as np

H, W = [int(intStr) for intStr in input().split()]

img = []
for h in range(H):
    img.append(input())

orig = np.ones((H,W))

for h in range(H):
    for w in range(W):
        if img[h][w]=='.':
            orig[max(h-1,0):min(h+1,H-1)+1,max(w-1,0):min(w+1,W-1)+1] = 0

for h in range(H):
    for w in range(W):
        regen = np.sum(orig[max(h-1,0):min(h+1,H-1)+1,max(w-1,0):min(w+1,W-1)+1])
        if (regen>0 and img[h][w]=='.') or (regen==0 and img[h][w]=='#'):
            print("impossible")
            exit()


print("possible")
for h in range(H):
    for w in range(W):
        print('.' if orig[h][w]==0 else '#', end='')
    print()

