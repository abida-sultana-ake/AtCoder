N = int(input())
R = []
for i in range(N):
    R.append(int(input()))
sort = sorted(R, reverse=True)
area = 0
for i in range(0, N, 2):
    if i == N - 1:
        area += sort[i] ** 2
    else:
        area += sort[i] ** 2 - sort[i+1] ** 2
print(area * 3.14159265359)
