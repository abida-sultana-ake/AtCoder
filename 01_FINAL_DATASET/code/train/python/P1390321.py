import numpy as np

nums = [int(x) for x in input().split()]
sx,sy = nums[0],nums[1]
gx,gy = nums[2],nums[3]
V,T = nums[4],nums[5]
N = int(input()) 
for i in range(N):
    her = [int(x) for x in input().split()]
    alpha = np.asarray([her[0] - sx, her[1] - sy])
    beta  = np.asarray([gx - her[0], gy - her[1]])

    if np.linalg.norm(alpha) + np.linalg.norm(beta) > V * T:
        continue
    else:
        print("YES")
        exit(0)

print("NO")
