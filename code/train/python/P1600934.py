import sys

N = int(sys.stdin.readline())
K = int(sys.stdin.readline())
x = list(map(int, input().split()))

z = [2 * (K - i) if i > K/2 else 2 * i for i in x]
print(sum(z))
