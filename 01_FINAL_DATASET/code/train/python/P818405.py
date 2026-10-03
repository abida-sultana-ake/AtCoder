from functools import reduce
import operator as op

def mapAccumL(f, acc, xs):
    ys = []
    for x in xs:
        (acc, y) = f(acc, x)
        ys.append(y)
    return (acc, ys)

def unfoldl(f, init, finish):
    acc = init
    while not finish(acc):
        acc, y = f(acc)
        yield y

n = int(input().split(' ')[0])
ds_str = input().split(' ')
ds = set(map(int, ds_str))

for m in range(n, 100000):
    mlist = list(unfoldl(lambda acc: (acc//10, acc%10), m, lambda acc: acc == 0))
    if reduce(op.or_, map(lambda x:x in ds, mlist)):
        continue
    else:
        print(m)
        break
