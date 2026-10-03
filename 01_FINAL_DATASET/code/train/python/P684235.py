(r, b), (x, y) = (map(int, input().split()) for i in range(2))
inf, sup = 0, int(2e18)
while sup - inf > 1:
    k = (inf + sup) // 2
    p1 = max(0, (y * k - b + y - 2) // (y - 1))
    p2 = min(k, (r - k) // (x - 1))
    if p1 <= p2:
        inf = k
    else:
        sup = k
print(inf)