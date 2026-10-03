# coding: utf-8
def II(): return int(input())
def ILI(): return list(map(int, input().split()))


def read():
    N = II()
    p = ILI()
    return N, p


def solve(N, p):
    ans = 0
    now_ind = 0
    while now_ind <= N - 1:
        if now_ind + 1 == p[now_ind]:
            ans += 1
            now_ind += 2
        else:
            now_ind += 1
    return ans


def main():
    params = read()
    print(solve(*params))


if __name__ == "__main__":
    main()
