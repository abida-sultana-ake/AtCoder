A,B,K,L = map(int,input().split())

ans = min([A*K, (K%L)*A + (K//L)*B])
ans = min([ ans,(K//L + 1)*B ] )
print(ans)
