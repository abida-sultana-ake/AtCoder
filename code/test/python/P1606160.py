A, B, C, D, E, F = map(int, input().split())

max_density = 0
ans_water = 0
ans_sugar = 0
for na in range(F // (A * 100) + 1):
    for nb in range(F // (B * 100) + 1):
        water = (A * na + B * nb) * 100
        if water == 0 or water > F:
            break

        for nc in range(F // C + 1):
            for nd in range(F // D + 1):
                sugar = C * nc + D * nd
                if water + sugar > F:
                    break

                density = sugar / (water + sugar)
                if density > E / (100 + E):
                    break

                if density >= max_density:
                    max_density = density
                    ans_water = water
                    ans_sugar = sugar

print(ans_water + ans_sugar, ans_sugar)
