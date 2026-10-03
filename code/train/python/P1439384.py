# coding: utf-8

n = int(input())
cities, population = list(), list()
for i in range(n):
    [population.append(int(x)) if x.isnumeric() else cities.append(x) for x in input().split()]

s = sum(population)
m = max(population)
print('atcoder' if m<=s/2 else cities[population.index(m)])
