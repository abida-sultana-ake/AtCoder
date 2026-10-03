mod = 1000000007

N = int(input())
u = input()
d = input()

c = 1
t = 0

if u[t] == d[t]:
    t += 1
    c *= 3
    lh = 'l'
else:
    t += 2
    c *= 6
    lh = 'h'

while t < N:
    if u[t] == d[t]:
        t += 1
        if lh == 'l':
            c = (c * 2) % mod
        lh = 'l'
    else:
        t += 2
        if lh == 'l':
            c = (c * 2) % mod
        else:
            c = (c * 3) % mod
        lh = 'h'
print(c)
