n, m = map(int, input().split())
stu = []
check = []
for i in range(n):
    stu.append(list(map(int, input().split())))

for i in range(m):
    check.append(list(map(int, input().split())))


ans = []

for i in range(n):
    dist = []
    for j in range(m):
        tmp = abs(stu[i][0] - check[j][0]) + abs(stu[i][1] - check[j][1])
        dist.append(tmp)
    mi = dist.index(min(dist))
    ans.append(mi)


for i in range(len(ans)):
    print(ans[i] + 1)