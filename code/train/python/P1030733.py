from collections import Counter
n,k,l = map(int, input().split())
def f(m):
    a = list(range(n))
    def g(i):
        if a[i] == i:
            return i
        a[i] = g(a[i])
        return a[i]
    for _ in range(m):
        p,q = map(int, input().split())
        i = g(p-1)
        j = g(q-1)
        a[j] = i
    return g
g = f(k)
h = f(l)
c = Counter((g(i),h(i)) for i in range(n))
print(' '.join((str(c[g(i),h(i)]) for i in range(n))))