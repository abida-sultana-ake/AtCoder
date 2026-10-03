X, t = list(map(int, input().split()))

dif = X - t
if dif < 0:
    print(0)
else:
    print(dif)