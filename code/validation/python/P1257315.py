N,T = [int(i) for i in input().split()]
ts = [int(i) for i in input().split()]
ret = 0
# for ind in range (1, N):
#     ret += min(T,ts[ind]-ts[ind-1])
for diff in [ts[ind+1]-ts[ind] for ind in range(N-1)]:
    ret += T if T<diff else diff
print(ret+T)
