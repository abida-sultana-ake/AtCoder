inp = input().split(" ")

for i in range(len(inp)):
    inp[i] = int(inp[i])

mn = 10**9 * 10**9
for i in range(0,int(inp[2]/inp[3])+2):
    y = i
    x = inp[2] - (i * inp[3])
    if x < 0:
        x = 0
    xm = x * inp[0]
    ym = y * inp[1]
    mn = min( xm + ym, mn )

print(mn)
