h, w = [int(n) for n in input().split()]
i = min(h, w)
j = max(h, w)
area = i * j
if i % 3 == 0 or j % 3 == 0:
    print(0)
else:
    lst = []
    for r, s in [(i, j), (j, i)]:
        
        p = s // 3 + 1
        q = s // 3 
        a1 = r * p
        a2 = r * q
        b1 = r // 2 * (s - p)
        bb1 = (r // 2 - 1) * (s - p)
        b2 = r // 2 * (s - q)
        bb2 = (r // 2 - 1) * (s - q)
        c1 = (s - p) // 2 * r
        cc1 = ((s - p) // 2- 1) * r
        c2 = (s - q) // 2 * r
        cc2 = ((s - q) // 2 - 1) * r
        tup = [(a1, b1), (a2, b2), (a1, c1), (a2, c2),
               (a1, bb1), (a2, bb2), (a1, cc1), (a2, cc2)]
        lst.extend([abs(max(a, b, area - a - b) - min(a, b, area - a - b))
                    for a, b in tup])
    print(min(lst))