N = int(input())
ds = iter([int(input()) for i in range(N)])

mx = mn = next(ds)

for d in ds:
    if mn <= d <= mx:
        mn = 0
    elif mx < d:
        mn = d - mx
    else:
        mn -= d
    mx += d

print(mx)
print(mn)
