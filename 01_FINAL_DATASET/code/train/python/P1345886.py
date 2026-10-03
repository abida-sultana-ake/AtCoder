
borders = [400, 800, 1200, 1600, 2000, 2400, 2800, 3200]
def getcolor(rate):
    i = 0
    for border in borders:
        if rate < border:
            return i
        i += 1
    return -1

N = int(input())
rates = [int(x) for x in input().split(" ")]
colors = [0 for _ in range(len(borders))]
topcoders = 0

for rate in rates:
    c = getcolor(rate)
    if c != -1:
        colors[c] = 1
    else:
        topcoders += 1

s_c = sum(colors)
ans = "{0} {1}".format(max(s_c, 1), s_c + topcoders)
print(ans)