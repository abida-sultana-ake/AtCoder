A, B, K, L = map(int, input().split())
if K % L == 0:
    print(B * K // L)
else:
    c = K // L
    print(c * B + min(B, (K - K // L * L) * A))
