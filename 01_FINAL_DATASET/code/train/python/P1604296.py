def node(hen, sin):
    if hen == 0 or sin == 0:
        return 0
    return 100 * sin / (hen + sin)


a, b, c, d, e, f = [int(i) for i in input().split()]
node_ans = 0
water_ans = 0
sugar_ans = 0
for A in range(0, f, a * 100):
    for B in range(0, f, b * 100):
        water = A + B
        max_sugar = water * e
        for C in range(0, f, c):
            for D in range(0, f, d):
                sugar = C + D
                if max_sugar < sugar*100 or f < water + sugar or water == 0:
                    break
                elif node_ans <= node(water, sugar):
                    node_ans = node(water, sugar)
                    sugar_ans = sugar
                    water_ans = water

print(water_ans + sugar_ans, sugar_ans)
