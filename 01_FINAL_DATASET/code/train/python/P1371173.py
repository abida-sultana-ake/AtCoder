import copy


def get_completed(s):
    ans = copy.deepcopy(s)

    not_close = 0
    not_open = 0

    for c in s:
        if c == '(':
            not_close += 1

        if c == ')':
            if not_close > 0:
                not_close -= 1
            else:
                not_open += 1

    for i in range(not_open):
        ans = '(' + ans

    for i in range(not_close):
        ans = ans + ')'

    return ans


if __name__ == '__main__':
    N = input()
    S = input()

    print(get_completed(S))
