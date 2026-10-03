A, B, K, L = map(int, input().split())
print(min(K // L * B + (K % L) * A, (K // L + 1) * B))