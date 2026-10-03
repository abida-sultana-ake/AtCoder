a,b,c,d,e,f = tuple(map(int,input().split()))

a = 100 * a
b = 100 * b

max_w = 0
max_sugar_w = 0
max_c = 0
for i in range(31):
    for j in range(31):
        water = a * i + b * j
        if 0 < water <= f:
            for k in range(50):
                for l in range(50):
                    sugar = c * k + d * l
                    if water + sugar <= f:
                        con = 100 * sugar /(sugar+water)
                        if sugar <= water/100*e:
                            if con >= max_c:
                                max_w = water + sugar
                                max_sugar_w = sugar
                                max_c = con
print(str(int(max_w))+" "+str(int(max_sugar_w)))
