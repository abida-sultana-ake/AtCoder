import math


def main():
    n = int(input())
    res = f(1, n)
    for i in range(int(math.sqrt(n)), 0, -1):
        if n % i == 0:
            this_f = f(i, n // i)
            if this_f <= res:
                res = this_f
            else:
                break
    print(res)


def f(a, b):
    return max(len(str(a)), len(str(b)))


if __name__ == "__main__":
    main()
