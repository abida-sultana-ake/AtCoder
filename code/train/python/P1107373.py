import numpy as np
import copy

if __name__=="__main__":
    inputs_number  = lambda : [int(x) for x in input().split()]
    N, Ma, Mb = inputs_number()
    drugs = [inputs_number() for i in range(N)]
    inf = 100*N + 1
    dp = np.ones((2,N*10+1,N*10+1)).astype(np.int32) * inf
    dp = dp.tolist()
    dp[0][0][0] = 0.0

    for i in range(N):
        for ca in range(10*i+1):
            for cb in range(10*i+1):
                if(dp[0][ca][cb]==inf):
                    continue
                dp[1][ca][cb]=min([dp[1][ca][cb], dp[0][ca][cb]])
                dp[1][ca+drugs[i][0]][cb+drugs[i][1]]=min([dp[1][ca+drugs[i][0]][cb+drugs[i][1]], dp[0][ca][cb]+drugs[i][2]])
        dp[0] = copy.copy(dp[1])
        dp[1] = (np.ones((N*10+1,N*10+1)).astype(np.int32) * inf).tolist()
    ans = inf
    for ca in range(1, N*10+1):
        for cb in range(1, N*10+1):
            if(Ma*cb==Mb*ca and dp[0][ca][cb]<ans):
                ans = dp[0][ca][cb]
    if(ans==inf):
        ans = -1
    print(int(ans))