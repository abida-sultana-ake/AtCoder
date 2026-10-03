N = int(input())

L = [int(input()) for i in range(N)]

if N <= 2:
    print(max(L))
elif N == 3:
    a = max(L)
    b = sum(L) - a
    print(max(a, b))
else:
    a = max(L)
    b = sum(L) - a
    c = max(L) + min(L)
    d = sum(L) - c
    ab = max(a, b)
    cd = max(c, d)
    print(min(ab, cd))
