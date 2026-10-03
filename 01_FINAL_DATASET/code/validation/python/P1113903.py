import math

N = int(input())
A = [int(x) for x in input().split() if int(x) != 0]

print(math.ceil(sum(A) / len(A)))