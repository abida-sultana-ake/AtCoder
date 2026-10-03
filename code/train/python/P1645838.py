N, A, B = map(int, input().split())

print(min(N, 5) * B + (N - min(N, 5)) * A)
