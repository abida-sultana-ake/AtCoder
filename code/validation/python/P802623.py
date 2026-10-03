A, K = map(int, input().split())

if K > 0:
    d = 0
    while A < 2*(10**12):
        A = A + A*K + 1
        d += 1
    print(d)
else:
    print(2*(10**12) - A)