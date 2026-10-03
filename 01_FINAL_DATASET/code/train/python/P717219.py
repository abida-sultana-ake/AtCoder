N = int(input())

a = []
for i in range(N):
    A = input()
    a.append(A)

for j in range(N):
    for i in range(N - 1,-1,-1):
        print(a[i][j],end = "")
    print("")