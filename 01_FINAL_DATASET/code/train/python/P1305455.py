N,W=map(int,input().split())
w,v=[],[]
for i in range(N):
    w_tmp,v_tmp=map(int,input().split())
    w.append(w_tmp)
    v.append(v_tmp)

dp=[{} for _  in range(N+1)]
def rec(i,j):
    if j in dp[i] :
        return dp[i][j]
    if i==N:
         res=0
    elif j<w[i]:
        res=rec(i+1,j)
    else:
        res=max(rec(i+1,j),rec(i+1,j-w[i])+v[i])
    dp[i][j]=res
    
    return res

print(rec(0,W))
    
