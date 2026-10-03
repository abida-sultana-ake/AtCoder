import collections

N = int(input())
A = [int(input()) for _ in range(N)]

d = collections.Counter(A)
print(sum([1 for k, v in d.items() if v % 2] ))