n = int(input())
p = []
for i in range(n):
    t,a = map(int, input().split())
    p.append((t,a))
q = [p[0][i] for i in range(2)]
for i in range(1, n):
    l = 0
    r = 10**18 + 1
    while l+1 < r:
        m = (l+r) //2 
        if any([p[i][j] * m < q[j] for j in range(2)]):
            l = m
        else:
            r = m
    for j in range(2):
        q[j] = r * p[i][j]

print(sum(q))