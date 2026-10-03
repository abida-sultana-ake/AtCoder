import sys

N = int(sys.stdin.readline())
K = int(sys.stdin.readline())
X = int(sys.stdin.readline())
Y = int(sys.stdin.readline())

print (K if K < N else N) * X + ((N - K) if K < N else 0) * Y
