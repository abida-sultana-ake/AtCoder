R, B = map(int, input().split())
x, y = map(int, input().split())
l = 0
r = 10 ** 20
while (l + 1 < r):
    m = (l + r) // 2
    #print("m")
    #print(m)
    if (m > R):
        r = m 
        continue
    p = (R - m) // (x - 1)
    #print("p")
    #print(p)
    if (p >= m):
        p = m 
    if (p >= B):
        p = B
    if (p + (m - p) * y <= B):
        l = m
    else:
        r = m
print(l)

