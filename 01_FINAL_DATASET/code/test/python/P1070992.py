a = sorted([int(i) for i in input().split()])
suma = sum(a) / 2
if sum(a) % 2 == 0 and suma == a[2] or suma == a[0] + a[1]:
    print("Yes")
else:
    print("No")
