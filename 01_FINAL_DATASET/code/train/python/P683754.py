a, b, m = map(int, raw_input().split())

def gcd(m, n):
    if m < n:
        return gcd(n, m)
    r = m % n
    return gcd(n, r) if r else n

def prod(X, Y):
    R = [[1,0,0],[0,1,0],[0,0,1]]
    for i in xrange(3):
        for j in xrange(3):
            r = 0
            for k in xrange(3):
                r += X[i][k] * Y[k][j]
                r %= m
            R[i][j] = r
    return R

def make(p, q):
    M = [[pow(10, q, m), 0, 1],[1,0,0],[0,0,1]]
    #M = [[pow(10, q), 0, 1],[1,0,0],[0,0,1]]
    res = [[1,0,0],[0,1,0],[0,0,1]]
    p /= q
    p -= 1
    while p>0:
        if p&1:
            res = prod(res, M)
        M = prod(M, M)
        p >>= 1
    return (res[0][0] + res[0][2]) % m

if a<b:
    a,b = b,a
g = gcd(a, b)

#print make(a, 1), make(b, g)
print (make(a, 1)*make(b, g)) % m
