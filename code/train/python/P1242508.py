n = int(input())
A = "Aoki"
T = "Takahashi"
if n == 1:
    print(A)
else:
    # for n in range(1, 100):
    # print(n)

    n += 1
    result = False
    while n != 1:
        result = not result
        if result:
            n += 1
        n //= 2
        # print("T" if result else "A", n, n*2-1)
        if n == 2:
            print(T if result else A)
            break
        elif n == 3:
            print(T)
            break
        # print("-------------")
