
if 1:
    N,W = map(int, input().split(' '))
    w,v = [],[]
    for i in range(N):
        w_,v_ = map(int, input().split(' '))
        w.append(w_)
        v.append(v_)
else:
    N,W = 4,6
    w = [2,3,4,3]
    v = [1,4,10,4]

w0 = w[0]

idxs = set()
for i in range(N+1):
    for j in range(3*i+1):
        if i*w0+j <= W:
            idxs.add(i*w0+j)
idxs = sorted(list(idxs))
idx_dict = {idx:i for i,idx in enumerate(idxs)}

dp = [[0 for j in range(len(idxs))] for i in range(N+1)]

for i in range(N):
    for j in range(len(idxs)):
        if idxs[j] < w[i]:
            dp[i+1][j] = dp[i][j]
        else:
            try:
                dp[i+1][j] = max([dp[i][j],dp[i][idx_dict[idxs[j]-w[i]]]+v[i]])
            except:
                dp[i+1][j] = dp[i][j]
        
print(max([max(dp_) for dp_ in dp]))