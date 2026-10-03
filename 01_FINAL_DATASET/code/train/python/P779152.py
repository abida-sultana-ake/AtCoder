A, B, K, L = map(int, input().split())
print(min(A * K, (K + L - 1) // L * B, K // L * B + (K - K // L * L) * A))