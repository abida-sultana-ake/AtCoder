# -*- coding: utf-8 -*-
A, B, C, D, E, F = tuple(map(int, input().split()))
A, B = 100*A, 100*B
waters = set([a+b for b in range(0, F+1, B) for a in range(0, F+1, A) if a+b <= F])

res_water = min(A, B)
res_sugar = 0
max_ratio = 0

for w in sorted(waters):
    sugars = [c+d for c in range(0, int(w//100)*E+1, C)
                         for d in range(0, int(w//100)*E+1, D) 
                             if (c+d+w <= F) and (c+d <= int(w/100)*E)]
    sugar = max(sugars)
    #print(sugars)
    if w+sugar==0:
        continue
    if 100*sugar / (w+sugar) > max_ratio:
        max_ratio = 100*sugar / (w+sugar)
        res_water = w
        res_sugar = sugar
print("{} {}".format(res_water+res_sugar, res_sugar))
