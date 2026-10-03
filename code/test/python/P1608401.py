N = int(input())
listT = [int(_) for _ in input().split()]
M = int(input())
total_listT = sum(listT)

answer = []
for i in range(M):
    temp = [int(_) for _ in input().split()]
    answer.append(total_listT - listT[temp[0]-1] + temp[1])

for _ in answer:
    print(_)