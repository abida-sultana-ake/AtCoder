import numpy as np

N = int(input())
inp = input().split()
a = []
for i in range(N):
    a.append(int(inp[i]))

height = np.array(a)
No_sorted = np.argsort(height) +1
No_sorted_down = No_sorted[::-1]

for i in range(N):
    print(No_sorted_down[i])
