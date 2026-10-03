N,T=[int(i) for i in input().split()]
t_n=[int(i) for i in input().split()]

ans=T
for i in range(N-1):
    if t_n[i+1]-t_n[i]<=T:
        ans+=t_n[i+1]-t_n[i]
    else:
        ans+=T
print(ans)