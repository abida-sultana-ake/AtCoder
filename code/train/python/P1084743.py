N = int(input())
d, m = divmod(N, 11)
a = (1 if m else 0) if m < 7 else 2
print(d * 2 + a)