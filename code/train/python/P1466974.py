# coding: utf-8
def get_ln_inputs():
    return input().split()


def get_ln_int_inputs():
    return list(map(int, get_ln_inputs()))


def main():
    K = get_ln_int_inputs()[0]

    N = 50
    n = K // N
    initNum = N + n - 1
    remK = K % N

    l = []

    fn = initNum + 1 + (N - remK)
    for _ in range(remK):
        l.append(fn)

    ln = initNum - remK
    for _ in range(remK, N):
        l.append(ln)

    print(N)
    print(" ".join(map(str, l)))


main()