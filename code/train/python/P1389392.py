N, K = [int(i) for i in input().split()]

total = N ** 3
pattern = ((K - 1) * (N - K)) * 6 + (N - 1) * 3 + 1

print(pattern/total)
