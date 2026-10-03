N = int(input())

def power(x, n):
    if n == 0:
        return 1
    elif n % 2:
        return x * power(x, n - 1)
    else:
        return power(x * x, n / 2)

print(power(10, N) + 7)
