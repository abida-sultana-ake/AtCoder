n = int(input())
for i in range(8):
    if 2 ** i <= n < 2 ** (i+1):
        print(2 ** i)
        break