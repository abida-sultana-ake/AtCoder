N = int(input())
a = [[int(input()), False] for i in range(N)]


num = 1
for i in range(N):
    if a[num-1][1]:
        print(-1)
        break
    if a[num-1][0] == 2:
        print(i+1)
        break
    a[num-1][1] = True
    num = a[num-1][0]