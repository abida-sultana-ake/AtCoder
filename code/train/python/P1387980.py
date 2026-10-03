import sys

def func(H, W):
    ans = 10**9
    for w in range(1,W):
        w_a = (W - w) // 2
        w_b = W - w  - w_a
        sub = max(H * w, H * w_a, H * w_b) - min(H * w, H * w_a, H * w_b)
        ans = min(ans, sub)

        h_a = H // 2
        h_b = H - h_a
        sub = max(H * w, h_a * (W - w), h_b * (W- w)) - min(H * w, h_a * (W - w), h_b * (W- w))
        ans = min(ans , sub)
    return ans

stdin = sys.stdin

ns = lambda: stdin.readline()
ni = lambda: int(ns())
na = lambda: list(map(int, stdin.readline().split()))

H, W = na()

print (min(func(H, W), func(W, H)))

