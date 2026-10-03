N = int(input())
print(80 * N - sum(map(lambda n: min(80, int(n)), input().split())))
