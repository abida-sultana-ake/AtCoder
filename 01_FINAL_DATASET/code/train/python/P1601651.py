a, b, c, d, e, f = map(int, input().split(" "))

max = 0
water = 0
sugar = 0
flag = True

i = 1
while(f >= 100 * a * i):
    j = 0
    while(f >= 100 * (a * i + b * j)):
        k = 0
        while(f >= 100 * (a * i + b * j) + c * k):
            l = 0
            while(f >= 100 * (a * i + b * j) + c * k + d * l):
                n = 100 * (c * k + d * l) / (100 * (a * i + b * j) + c * k + d * l)
                if(n > 100 * e / (100 + e)):
                    break
                if(max < n):
                    max = n
                    water = 100 * (a * i + b * j)
                    sugar = c * k + d * l
                l += 1
            k += 1
        j += 1
    i += 1

i = 0
j = 1
while(f >= 100 * (a * i + b * j)):
    k = 0
    while(f >= 100 * (a * i + b * j) + c * k):
        l = 0
        while(f >= 100 * (a * i + b * j) + c * k + d * l):
            n = 100 * (c * k + d * l) / (100 * (a * i + b * j) + c * k + d * l)
            if(n > 100 * e / (100 + e)):
                break
            if(max < n):
                max = n
                water = 100 * (a * i + b * j)
                sugar = c * k + d * l
            l += 1
        k += 1
    j += 1

if(water == 0):
    water = 100 * a
print("%d %d" %(water + sugar, sugar))