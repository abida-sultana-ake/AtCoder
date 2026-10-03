
a, b, c = input().split()

a = int(a)
b = int(b)
c = int(c)

flag = False

for i in range(100):
    tmp = (a * i) % b
    if tmp == c:
        flag = True
        break

if flag:
    print('YES')
else:
    print('NO')
