def f(l, t):
    c = len(l)
    while c:
        if t[2] >= l[c - 1][2]:
            l.insert(c, t)
            return
        c -= 1
    l.insert(0, t)

N = int(input())
hl = list(map(int, input().split()))
q = [(hl[1], 1, abs(hl[0]-hl[1]))]
cl = [sum(hl)]*N
if N > 2 : q += [(hl[1], 2, abs(hl[0]-hl[2]))]
while 1:
    ih, ip, ic = q[0]
    q = q[1:]
    if ip == N-1:
        print(ic)
        break
    for i in range(1, 3):
        p = ip + i
        if p < N:
            a = ic + abs(hl[ip]-hl[p])
            if a < cl[p]:
                cl[p] = a
                f(q,(hl[p], p, a))