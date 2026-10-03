def range_sum(l, r):
    if l <= 0 and r <= 0:
        l *= -1
        r *= -1
        t = l
        l = r
        r = t
    elif not (l >= 0 and r >= 0):
        return range_sum(0, abs(l)) + range_sum(0, abs(r))
    
    return (r*(r+1)//2) - (l*(l-1)//2)


r, g, b = map(int, input().split())

ans = 10000000000000

for i in range(600*2+1):
    l = i - 600
    calc = 0

    #R
    if -100 + (r-1)//2 >= l: #[l-r, l-1]
        calc += range_sum(l-r + 100 ,l-1 + 100)
    else: #[0, r//2] + [0,(r-1)//2]
        calc += range_sum(-(r//2),(r-1)//2)
    
    #G [l, l+g-1]
    calc += range_sum(l, l+g-1)

    #B
    if l+g - 1 >= 100 - (b-1)//2:
        calc += range_sum(l+g - 100, l+g+b-1 - 100)
    else:
        calc += range_sum(-(b//2),(b-1)//2)

    ans = min(ans, calc)

print(ans)
