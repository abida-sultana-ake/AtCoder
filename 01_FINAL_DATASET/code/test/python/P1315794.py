m, n, N = map(int,input().split())
sell = N

while N // m > 0:
    sell += N // m * n
    N = N // m * n + N % m

print(sell)