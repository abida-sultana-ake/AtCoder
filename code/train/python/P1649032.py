w,h = map(int,input().split())
n = int(input())
xn = [0]*n
yn = [0]*n
for i in range(n):
    a,b = map(int,input().split())
    xn[i] = a; yn[i] = b
d = dict()

def memo(lw,lh,rw,rh):
    if lw > rw or lh > rh: return 0
    if (lw,lh,rw,rh) in d: return d[(lw,lh,rw,rh)]

    val = 0
    for act in range(n):
        xi = xn[act]; yi = yn[act]
        if xi >= lw and xi <= rw and yi >= lh and yi <= rh:
            tmp = rw-lw + rh-lh + 1
            tmp += memo(lw,lh,xi-1,yi-1)
            tmp += memo(lw,yi+1,xi-1,rh)
            tmp += memo(xi+1,yi+1,rw,rh)
            tmp += memo(xi+1,lh,rw,yi-1)
            val = max(val,tmp)
    d[(lw,lh,rw,rh)] = val
    return val
print(memo(1,1,w,h))
