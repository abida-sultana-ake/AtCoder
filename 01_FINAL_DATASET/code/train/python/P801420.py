a = int(input())
l, r = a * a, (a + 1) * (a + 1) - 1
while (l + 99) // 100 <= r // 100:
    l = (l + 99) // 100
    r //= 100
print(l)