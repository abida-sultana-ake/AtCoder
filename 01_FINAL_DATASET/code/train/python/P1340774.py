N = int(input())
a = list(map(int, input().split()))
M, m = max(a), min(a)

print(M - m)