def is_prime(x):
    if x == 2:
        return True
    i = 3
    while i ** 2 <= x:
        if x % i == 0:
            return False
        i += 1
    return True


print('YES' if is_prime(int(input())) else 'NO')
