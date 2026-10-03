import math


def main():
    #infile = open("compprog.txt", mode="r")
    n = int(input())
    res = f(1, n)
    i = 2
    while i <= math.sqrt(n):
        if n % i == 0:
            this_f = f(i, n // i)
            res = this_f if this_f < res else res
        i += 1
    print(res)
    #infile.close()


def f(a, b):
    return max(len(str(a)), len(str(b)))


if __name__ == "__main__":
    main()
