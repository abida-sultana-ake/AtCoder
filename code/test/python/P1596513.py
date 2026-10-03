A,B,C,D,E,F = map(int,input().split())
possibleWater = {0}
for i in range(F//(100*A)):
    copy = set(possibleWater)
    for x in copy:
        possibleWater.add(x+100*A)
for i in range(F//(100*B)):
    copy = set(possibleWater)
    for x in copy:
        possibleWater.add(x+100*B)
possibleSugar = {0}
for i in range(F//C):
    copy = set(possibleSugar)
    for x in copy:
        possibleSugar.add(x+C)
for i in range(F//D):
    copy = set(possibleSugar)
    for x in copy:
        possibleSugar.add(x+D)

bestWater = -1
bestSugar = -1
bestDensity = -1
possibleWater.remove(0)
for w in possibleWater:
    for s in possibleSugar:
        #print(w,s)
        if w/100 * E < s:
            #print("too much sugar")
            continue
        if w+s>F:
            #print("too much mass")
            continue
        density = 100*s/(w+s)
        if density>bestDensity:
            bestDensity = density
            bestWater = w
            bestSugar = s

print(bestWater+bestSugar,bestSugar)
