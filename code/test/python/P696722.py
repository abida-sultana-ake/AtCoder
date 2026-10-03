# coding: utf-8
K = int(input())

(a, b) = (1, 1)

for _ in range(K):
  (a, b) = (a+b, a)

print("{0} {1}".format(a, b))
