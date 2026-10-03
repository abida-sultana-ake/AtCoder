N = int(input())
T = list(map(int, input().split()))
M = int(input())
PX = []
for i in range(M):
    PX.append(list(map(int, input().split())))

for i in PX:
    temp = T[:]
    temp[i[0]-1] = i[1]
    print(sum(temp))
