import math as mt
store = []
def binarysearch(min, max):
    mid = int((max + min)/2)
    if (min == max):
        return mid
    elif count(mid) > mid:
        return binarysearch(mid+1, max)
    else:
        return binarysearch(min, mid)

def count(x):
    store = [mt.ceil((n - x*b)/a) for n in hp]
    store = [x for x in store if x > 0]
    return sum(store)

st = 0
min = 10 ** 18
max = 0
n, a, b = [int(x) for x in input().split(' ')]
hp = []
for i in range(n):
    st = int(input())
    if st < min:
        min = st
    if st > max:
        max = st
    hp.append(st)
min, max = mt.ceil(min/a), mt.ceil(max/b)
a = a - b
print(binarysearch(min,max))
