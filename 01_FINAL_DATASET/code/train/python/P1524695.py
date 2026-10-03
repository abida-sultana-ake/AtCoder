# coding: utf-8
def II(): return int(input())
def ILI(): return list(map(int, input().split()))


def read():
    N = II()
    S_1 = str(input())
    S_2 = str(input())
    return N, S_1, S_2


def solve(N, S_1, S_2):
    ind = 0
    l_sum = []
    while ind <= N - 1:
        if ind == N - 1:
            l_sum.append("a")
            ind += 1
            continue
        now = S_1[ind]
        next = S_1[ind + 1]
        if now == next:
            l_sum.append("b")
            ind += 2
        else:
            l_sum.append("a")
            ind += 1

    if l_sum[0] == "a":    
        ans = 3
    else:
        ans = 6
    for i in range(1, len(l_sum)):
        pre = l_sum[i - 1]
        now = l_sum[i]
        if pre == "a":
            ans *= 2
        else:
            if now == "b":
                ans *= 3

    return ans % (10 ** 9 + 7)


def main():
    params = read()
    print(solve(*params))


if __name__ == "__main__":
    main()
