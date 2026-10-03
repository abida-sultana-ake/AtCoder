N, K, A = int(input()), int(input()), [int(v) for v in input().split()]
R = 0
for a in A:
  Na = abs(0-a)
  Ka = abs(K-a)
  r = Na if Na <= Ka else Ka
  R += r * 2

print(R)