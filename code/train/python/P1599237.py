A, B, C, D, E, F = map(int, input().split())

y = 0
yx = 100*A
ys= 0
W = {}
for a in range(F//100 + 1):
    for b in range(F//200 + 1):
        w = 100*A*a + 100*B*b
        if w <= F:
            W[w] = 0
        
for w in W.keys():
    for c in range(min(F-w, (E*w//100)) + 1):
        for d in range(min(F-w, (E*w//100))//2 + 1):
            s = C*c + D*d
            x = w + s
            try:
                if s+w <= F and s/x <= E/(100+E):
                    if s/x > y:
                        y = s/x
                        ys = s
                        yx = x
            except ZeroDivisionError:
                pass
                
print(yx, ys)