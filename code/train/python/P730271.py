import math
N = int(input())
down, up = [], []
for i in range(N):
    a, b = map(int,input().split())
    if a-b < 0:
        down.append((a, b))
    else:
        up.append((a, b))
 
temp = 0
max = 0
down = sorted(down, key=lambda x:x[1], reverse=True)
down = sorted(down, key=lambda x:x[0], reverse=False)
up = sorted(up, key=lambda x:x[0], reverse=True)
up = sorted(up, key=lambda x:x[1], reverse=True)
magic = down + up
 
for i in magic:
    temp += i[0]
    if max < temp:
        max = temp
    temp -= i[1]
print(max)