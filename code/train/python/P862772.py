import numpy as np

N, A = map(int, input().split())
xs = np.array(list(map(int, input().split()))) - A

dp = np.zeros((50*50*2+1, N+1), dtype=np.int64)
dp[50*50,0] = 1

for i, x in enumerate(xs):
    dp[:,i+1] = dp[:,i]
    dp[max(0,x):min(len(dp),len(dp)+x),i+1] += dp[max(0,-x):min(len(dp),len(dp)-x),i]

print(dp[50*50,N]-1)