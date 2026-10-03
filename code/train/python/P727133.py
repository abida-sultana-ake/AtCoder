r, b = map(int, input().split())
x, y = map(int, input().split())

def check(k):
    return (r >= k) and (b >= k) and (((r - k)//(x - 1)) + ((b - k)//(y - 1)) >= k)
inf, sup = 0, int(1e18)
while inf != sup:
    k = (inf + sup + 1) // 2
    if check(k):
        inf = k
    else:
        sup = k-1
print(inf)
