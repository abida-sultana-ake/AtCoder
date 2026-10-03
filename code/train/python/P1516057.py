from collections import defaultdict


def can_make(m, k, items):
    n = []
    for item in items:
        w, p = item
        n.append(w * (p - m))
    return sum(sorted(n, reverse=True)[:k]) >= 0


def main():
    N, K = map(int, input().split())
    items = []
    for _ in range(N):
        w, p = map(int, input().split())
        items.append((w, p))

    left, right = 0, 100
    ans = 0
    for _ in range(1000):
        m = (left + right) / 2
        if can_make(m, K, items):
            left = m
            ans = m
        else:
            right = m
            ans = m

    print(ans)

if __name__ == '__main__':
    main()
