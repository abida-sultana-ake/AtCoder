import itertools as it
import math

N = int(input())
x, y = [], []
for i in range(N):
    temp = [int(a) for a in input().split()]
    x.append(temp[0]), y.append(temp[1])

def distance(i, j):
    return math.sqrt((x[i]-x[j])**2 + (y[i]-y[j])**2)

result = 0
for i in it.combinations(range(N), 2):
    result = max(result, distance(i[0], i[1]))

print(result)