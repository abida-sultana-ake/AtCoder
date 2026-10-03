A, B, C, D, E, F = map(int, raw_input().split(' '))

ans_water = None
ans_sugar = None

for a in xrange(0, int(F/(100*A))+1):
  waterA = 100 * A * a
  for b in xrange(0, int((F-waterA)/(100*B))+1):
    water = waterA + 100 * B * b
    for c in xrange(0, int((F-water)/C)+1):
      sugarC = C * c
      for d in xrange(0, int((F-water-sugarC)/D)+1):
        sugar = sugarC + D * d
        if sugar * (100 + E) <= (water + sugar) * E:
          if (not ans_water) or (not ans_sugar) or ans_sugar * (water + sugar) < (ans_water + ans_sugar) * sugar:
            ans_water = water
            ans_sugar = sugar

print (ans_water + ans_sugar), ans_sugar