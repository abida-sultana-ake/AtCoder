(n, k) = map(int, input().split(" "))

xs = []
ys = []
pts = []
for _ in range(n):
    (x, y) = map(int, input().split(" "))
    xs += [x]
    ys += [y]
    pts += [(x, y)]

xs.sort()
ys.sort()

res = float("inf")
for a in xs:
    for b in xs:
        ci = 0
        di = 1
        while di < len(ys):
            num = 0
            c = ys[ci]
            d = ys[di]
            
            for x in pts:
                if a <= x[0] <= b and c <= x[1] <= d:
                    num += 1
        
            if num >= k:
                res = min(res, abs(b-a)*abs(d-c))
                if ci < di:
                    ci += 1
                else:
                    di += 1
            else:
                di += 1

print(res)