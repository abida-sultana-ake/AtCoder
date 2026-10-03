def radix_convert(number, radix):
    s = []
    while number>0:
        s.append(number%radix)
        number = number//radix
    return s[::-1]

n,k,t=map(int, input().split())
a = list(map(int, input().split()))
a.sort()
if k == 1:
    for i in range(n):
        print(a[i]%1000000007)
    exit()

b = [radix_convert(a[i], k) for i in range(n)]
c = [len(b[i]) for i in range(n)]

c_max = max(c)
d = [c_max - c[i] for i in range(n)]
sum_d = sum(d)
if t <= sum_d:
    for i in range(t):
        a.sort()
        a[0] *= k
    a.sort()
    for i in range(n):
        print(a[i]%1000000007)
else:
    t -= sum_d
    for i in range(n):
        a[i] *= k**d[i]
    a.sort()
    loop = t//n
    frac = t%n
    for i in range(t%n):
        a[i] *= k
    a.sort()
    kloop = pow(k,loop,1000000007)
    for i in range(n):
        print(a[i]*kloop%1000000007)
