n = int(input())
a = [int(i) for i in input().split(' ')]
_a = [-1*i for i in a]

def func(l):
    _ans = 0
    product = 0
    for i in range(n):
        product += l[i]
        if i%2 == 0:
            if product<=0:
                _ans += abs(product) + 1
                product = 1
        elif i%2 == 1:
            if product>=0:
                _ans += abs(product) + 1
                product = -1
    return _ans

ans = min(func(a), func(_a))
print(ans)