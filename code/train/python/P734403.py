n = int(input())
l = []
for i in range(n):
    l.append(list(input()))
for j in range(0, n, 1):
    for i in range(n-1, -1, -1):
        print(l[i][j], end='')
    print('')
print('')