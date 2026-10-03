N,T = map(int,input().split())
order = list(map(int,input().split()))
ov = 0
for i in range(N-1):
    if (order[i+1]-order[i])<T:
        ov += T-(order[i+1]-order[i])
print(N*T-ov)