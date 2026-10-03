
import math

txa, tya, txb, tyb, T, V = map(int, input().split())
n = int(input())
dis = 10**10

for i in range(n):
    x, y = map(int, input().split())
    dis1 = math.sqrt((x - txa)**2 + (y - tya)**2)
    dis2 = math.sqrt((x - txb)**2 + (y - tyb)**2)
    dis = min(dis ,dis1 + dis2)


if T * V >= dis:
    print("YES")
else:
    print("NO")