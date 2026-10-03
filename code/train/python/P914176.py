import sys
from itertools import combinations

def add_combination(S, cmb):
    new_S = ""

    for i in range(len(S)):
        new_S += S[i]
        if i in cmb:
            new_S += "+"

    return eval(new_S)


S = input()
sum_S = int(S)

for i in range(1, len(S)):
    for cmb in combinations(range(len(S) - 1), i):
        sum_S += add_combination(S, cmb)

print(sum_S)