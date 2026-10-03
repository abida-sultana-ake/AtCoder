N, K = map(int, input().split())
D = list(map(str,input().split()))
ans = N
while sum([d in str(ans) for d in D]):
	ans+=1
print(ans)