N = int(input())

if N%2==0:
    n = N // 2
    print(n)
    for i in range(n):
        print(2)
else:
    N = N - 1
    n = N // 2
    print(n+1)
    print(1)
    for i in range(n):
        print(2)