a, b, c = [int(i) for i in input().split()]

ans='NO'

i = 1
f = a % b
while(1):
    tmp = a * i
    mod = tmp % b

    if mod == c:
        ans = 'YES'
        break

    if i != 1 and mod == f:
        break

    i += 1


print(ans)
