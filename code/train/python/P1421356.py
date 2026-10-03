m, n, o = map(int, input().split())
count = 0
for i in range(m):
    p, q = map(str, input().split())
    q = int(q)
    if p == "East":
        if q > n and q < o:
            count += q
        elif q <= n:
            count += n
        else:
            count += o
    elif p == "West":
        if q > n and q < o:
            count -= q
        elif q <= n:
            count -= n
        else:
            count -= o
if count > 0:
    print("East " + str(count))
elif count < 0:
    count *= -1
    print("West " + str(count))
else:
    print(0)
