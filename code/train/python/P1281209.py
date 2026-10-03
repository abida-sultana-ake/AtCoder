a = list(map(int,input().split(" ")))
b = list()

for i in range(a[0]):
    b.append(list(map(int,input().split(" "))))

c = sorted(b, key=lambda x:x[0])

ans = c[0][0]
tmp = 0


for i in range(a[0]):
    tmp = tmp + c[i][1]
    if tmp >= a[1]:
        ans = c[i][0]
        break

print(ans)