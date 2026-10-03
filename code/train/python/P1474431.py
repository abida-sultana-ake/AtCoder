n, x = map(int, input().split())
a = list(map(int, input().split()))
two_x = format(x, 'b')
pad_x = two_x.zfill(n)
b = list(pad_x)
b = b[::-1]
li = []
for i in range(n):
    if int(b[i]) == 1:
        li.append(a[i])

print(sum(li))
