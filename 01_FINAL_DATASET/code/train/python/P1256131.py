import math

def size(p1, p2):
    return math.sqrt((p1[0]-p2[0])**2 + (p1[1]-p2[1])**2)

N = input()
xy = [list(map(int, input().split())) for i in range(int(N))]
m = 0
for i in range(len(xy)):
    for j in range(len(xy)):
        m = max(m, size(xy[i], xy[j]))

print(m)