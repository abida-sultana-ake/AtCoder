# -*- coding: utf-8 -*-
a = input().split()
min_data = None
for i in range(len(a)):
    for j in range(len(a)):
        if i == j:
            pass
        elif min_data is None:
            min_data = int(a[i])+int(a[j])
        else:
            min_data = min(min_data, int(a[i])+int(a[j]))
print(min_data)
