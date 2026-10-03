N = int(input())

def is_prime(n):
    for i in range(2, n):
        ans = n % i
        if ans == 0:
            return False
    return n != 1

ans = is_prime(N)

if ans == False:
    b = N % 3
    c = str(N)
    c = c[-1:]
    d = int(c) % 2
    if b != 0 and int(c) != 5 and d != 0 and N != 1:
        ans = True

if ans == True:
    print("Prime")
else:
    print("Not Prime")
