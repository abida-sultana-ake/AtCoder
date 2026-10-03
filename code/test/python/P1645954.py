N = int(input())
A = sorted(map(int, input().split()), reverse=True)
print(sum([A[i] for i in range(0, N, 2)]))
