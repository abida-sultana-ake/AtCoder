n, m = map(int, input().split())
a = [input() for i in range(n)]
b = [input() for i in range(m)]

for i in range(n - m + 1):
    for j in range(n - m + 1):
        flag = True
        for k in range(m):
            for l in range(m):
                if b[k][l] != a[k + i][l + j]:
                    flag = False
                    break
            if not flag:
                break
        if flag:
            print("Yes")
            exit()
print("No")
