N = int(input()) + 1
result = 0
for i in range(len(str(N) )):
    n = 10**(i+1)
    result += N // n * 10**i
    result += min(max((N % n) - 10**i, 0), 10**i)
print(result)