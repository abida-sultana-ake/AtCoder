A, K = map(int, input().split())
i = 1
if K == 0:
    print(2 * (10 ** 12) - A)
    exit()
while True:
    A += 1 + K * A
    if A >= 2 * (10 ** 12):
        print(i)
        exit()
    i += 1
