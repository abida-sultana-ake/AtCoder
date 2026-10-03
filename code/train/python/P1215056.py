# coding: utf-8
from collections import Counter
import copy

n = int(input())

d_str = []
for __ in range(n):
    l_char = list(input())
    d_count = Counter(l_char)
    d_str.append(dict(d_count))

now_dict = d_str[0]

for i in range(1, n):
    dif_dict = d_str[i]
    next_dict = dict()
    for key, item in now_dict.items():
        if key in dif_dict:
            next_dict[key] = min(item, dif_dict[key])
        else:
            pass

    now_dict = copy.deepcopy(next_dict)

print_str = []
for tup in sorted(now_dict.items()):
    for item in range(tup[1]):
        print_str.append(tup[0])

print("".join(print_str))
