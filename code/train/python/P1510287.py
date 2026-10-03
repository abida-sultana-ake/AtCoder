def main():
    N = int(input().strip())
    res = int(input().strip())
    if N == 1:
        print(res)
        return
    for _ in range(1, N):
        t = int(input().strip())
        res = lcm(res, t)
    print(res)


def lcm(a, b):
    return (a * b) // gcd(a, b)


def gcd(a, b):
    if b == 0:
        return a
    if b == 1:
        return 1
    if b > a:
        return gcd(b, a)
    else:
        return gcd(b, a % b)

if __name__ == '__main__':
    main()
