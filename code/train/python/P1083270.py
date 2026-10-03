n = int(input())

a = n // 11
m = n % 11

if m == 0:
    print(a * 2)
elif m < 7:
    print(a * 2 + 1)
else:
    print(a * 2 + 2)