import itertools
import numpy as np
nums = [int(x) for x in input().split()]
N,M = nums[0],nums[1]


# make graphs
matrix = [[0 for i in range(N)] for j in range(N)]
for i in range(M):
    nums=[int(x) for x in input().split()]
    a,b = nums[0]-1,nums[1]-1
    matrix[a][b] = 1
    matrix[b][a] = 1

patterns = [i for i in itertools.product([0,1], repeat=N)]

ans = 0
for pat in patterns:
    choice = [i for i in range(len(pat)) if pat[i] != 0]

    if all([matrix[l[0]][l[1]] for l in list(itertools.combinations(choice,2))]):
        ans = max(ans,len(choice))
print(ans)