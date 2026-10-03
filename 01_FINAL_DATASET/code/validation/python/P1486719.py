# coding: utf-8
INF = 10 ** 20
MOD = 10 ** 9 + 7


def II(): return int(input())
def ILI(): return list(map(int, input().split()))


def read():
    N = II()
    a = ILI()
    return N, a


def solve(N, a):
    n_odd = 0
    n_div_2 = 0
    n_div_4 = 0
    for _a in a:
        if _a % 2 == 1:
            n_odd += 1
        else:
            if _a % 4 == 0:
                n_div_4 += 1
            else:
                n_div_2 += 1

    ans = ""
    if n_div_2 == 0:
        if n_div_4 >= n_odd - 1:
            ans = "Yes"
        else:
            ans = "No"
    else:
        if n_div_4 >= n_odd:
            ans = "Yes"
        else:
            ans = "No"

    return ans


def main():
    params = read()
    print(solve(*params))


if __name__ == "__main__":
    main()
