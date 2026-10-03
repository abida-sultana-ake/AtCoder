import sys
def query(a, b):
    print ('?', a, b)
    sys.stdout.flush()
    return int(input())

N = int(input())
maxa,maxb = 1,2
diameter = query(maxa,maxb)
for n in range(3, N+1):
    d1 = query(n, maxa)
    d2 = query(n, maxb)
    if d1 > diameter:
        maxb = n
        diameter = d1
    if d2 > diameter:
        maxa = n
        diameter = d2
print ('!', diameter)
