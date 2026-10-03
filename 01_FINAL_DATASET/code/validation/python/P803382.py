
def money_plus(money,K):
    return money + (1 + K * money)


if __name__ == '__main__':
    l = input().split()
    A = int(l[0])
    K = int(l[1])

    if K == 0:
        print( 2 * (10**12) - A )
        quit()

    day = 0
    while A < 2 * (10**12):
        A = money_plus(A,K)
        day = day + 1

    print(day)
