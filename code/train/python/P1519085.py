from collections import defaultdict
from itertools import product


def update(v, w, length_pattern, now_pattern):
    if sum([length_pattern[x] for x in v]) != len(w):
        return None

    for n in v:
        length = length_pattern[n]
        s, w = w[:length], w[length:]
        if n in now_pattern and now_pattern[n] != s:
            return None
        now_pattern[n] = s

    return now_pattern


def main():
    K, N = map(int, input().split())
    items = []
    for _ in range(N):
        v, w = input().split()
        items.append((list(map(int, v)), w))

    for x in product(range(1, 4), repeat=K):
        length_pattern = [-1] + list(x)

        now_pattern = {}
        for v, w in items:
            now_pattern = update(v, w, length_pattern, now_pattern)
            if now_pattern is None:
                break
        else:
            for i in range(1, K + 1):
                print(now_pattern[i])
            return

if __name__ == '__main__':
    main()
