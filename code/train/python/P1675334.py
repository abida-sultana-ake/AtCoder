import numpy as np


def combi(l, r):
    if l == 0 or r == 0 or l == r:
        return 0.0
    plus = np.log(np.arange(l - r + 1, l + 1))
    minus = np.log(np.arange(1, r + 1))
    return np.sum(plus) - np.sum(minus)


N, D = [int(x) for x in input().split(' ')]
X, Y = [int(x) for x in input().split(' ')]

if abs(X) % D != 0 or abs(Y) % D != 0:
    print(0.0)
else:
    X = abs(X) // D
    Y = abs(Y) // D
    if (N - X - Y) % 2 != 0:
        print(0.0)
    else:
        answer = 0.0
        rest = N - X - Y
        if rest == 0:
            print(np.exp(combi(N, X) + combi(N - X, Y) + N * np.log(0.25)))
        else:
            for i in range(rest // 2 + 1):
                ud = i
                lr = rest // 2 - i
                ways = combi(N, X + ud) + combi(N - X - ud, ud) + combi(N - X - 2 * ud, Y + lr)
                if answer == 0.0:
                    answer = ways
                elif answer > ways:
                    answer = answer + np.log(np.exp(ways - answer) + 1.0)
                else:
                    answer = ways + np.log(np.exp(answer - ways) + 1.0)
            print(np.exp(answer + N * np.log(0.25)))
