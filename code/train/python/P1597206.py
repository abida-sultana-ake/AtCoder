# coding:utf-8

buf = input()
nm = buf.split(' ')
n = int(nm[0])
m = int(nm[1])

success = False
end = (4 * n - m) // 2 + 1
for i in range(0, end + 1):
    y = 4 * n - m - 2 * i
    z = i + m - 3 * n
    if y >= 0 and z >= 0:
        print(i, y, z)
        success = True
        break

if success:
    pass
else:
    print(-1, -1, -1)
