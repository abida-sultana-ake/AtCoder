K = int(input())
mul, div = divmod(K, 50)
a = [n+mul for n in range(50)]

for _ in [None]*div:
    a = [n-1 for n in a[1:]] + [a[0]+50]

print("50\n"+" ".join((str(n) for n in a)))