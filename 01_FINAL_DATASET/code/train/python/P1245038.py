n, m = map(int, input().split())
c = [[0 for i in range(n+1)] for j in range(n+1)]

for i in range(m):
    a, b = map(int, input().split())
    c[a][b] = 1
    c[b][a] = 1

result = 1
for i in range(1, 1<<n):
    a = [j+1 for j in range(n) if i&1<<j]
    flag = True
    for j in a:
        if not all([c[j][k] == 1 for k in a if j != k]):
            flag = False
            break
    if flag:
        subt = len([1 for j in range(n+1) if i&1<<j])
        result = max(result, subt)
print(result)