N = int(input())
a = list(map(int,input().split()))

GRAY = 400
BROWN = 800
GREEN = 1200
CYAN = 1600
BLUE = 2000
YELLOW = 2400
ORANGE = 2800
RED = 3200

colors = []
over3200 = 0

for i in a:
    if i < GRAY:
        colors.append(GRAY)
    elif i < BROWN:
        colors.append(BROWN)
    elif i < GREEN:
        colors.append(GREEN)
    elif i < CYAN:
        colors.append(CYAN)
    elif i < BLUE:
        colors.append(BLUE)
    elif i < YELLOW:
        colors.append(YELLOW)
    elif i < ORANGE:
        colors.append(ORANGE)
    elif i < RED:
        colors.append(RED)
    else:
        over3200 += 1

colornum = len(set(colors))
mincolor = max(colornum, 1)
maxcolor = colornum + over3200

print(' '.join([str(mincolor),str(maxcolor)]))