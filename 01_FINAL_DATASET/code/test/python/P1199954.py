import operator
import functools


def main():
    N, A, B = map(int, input().split())
    v = list(map(int, input().split()))
    # use list.sort() or sorted(list)
    v.sort(reverse=True)
    # use slice to sum first A elements
    # use '{:f}'.format to format float
    print('{:.6f}'.format((sum(v[:A]) / A)))

    va = v[A - 1]
    # use list.count instead of (sum(list(map(lambda x: 1 if ... else 0, v))))
    pool = v.count(va)
    # ...and for comprehension and boolean sum
    head = sum(x > va for x in v)
    # 5 4 3 3 3 2 1, A = 3, B = 5, pool = 3, pick = 1
    # 5 4 3 3 3 2 1, A = 4, B = 5, pool = 3, pick = 2
    # 3 3 3 3 3 2 1, A = 3, B = 6, pool = 5, pick = 3, 4, 5
    # 3 3 3 3 3 2 1, A = 3, B = 4, pool = 5, pick = 3, 4
    if head == 0:
        # for comprehension again, instead of a for loop that modifies variable
        ans = sum([_nCr(pool, pick) for pick in range(A, min(B, pool) + 1)])
    else:
        pick = A - head
        ans = _nCr(pool, pick)
    print(ans)


def _nCr(n, r):
    r = min(r, n-r)
    if r == 0:
        return 1
    # reduce and xrange are for python2
    numer = functools.reduce(operator.mul, range(n, n-r, -1))
    denom = functools.reduce(operator.mul, range(1, r+1))
    return numer//denom


if __name__ == '__main__':
    main()
