# coding: utf-8
def II(): return int(input())
def ILI(): return list(map(int, input().split()))


def read():
    A, B, C, D = ILI()
    return A, B, C, D


def solve(A, B, C, D):
    l_ans = [0] * 101
    for a in range(A, B + 1):
        l_ans[a] += 1
    for b in range(C, D + 1):
        l_ans[b] += 1

    ans = 0
    for a in l_ans:
        if a == 2:
            ans += 1

    if ans != 0:
        ans -= 1

    return ans


def main():
    params = read()
    print(solve(*params))


if __name__ == "__main__":
    main()
