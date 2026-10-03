from collections import defaultdict


def calc(H, W):
    if H % 3 == 0 or W % 3 == 0:
        return 0
    ans = min(H, W)
    h1 = H // 2
    h2 = H - h1
    for w in range(W + 1):
        a = H * w
        b = (W - w) * h1
        c = (W - w) * h2
        ans = min(ans, max(abs(a - b), abs(a - c)))
    return ans


def solve(H, W):
    return min(calc(H, W), calc(W, H))


def main():
    H, W = map(int, input().split())
    print(solve(H, W))

if __name__ == '__main__':
    main()
