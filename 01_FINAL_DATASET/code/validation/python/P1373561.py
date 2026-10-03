temp=input().split()
N=int(temp[0])
M=int(temp[1])
ans=0
INF=1000000000

if abs(N-M)==0:
	ans=2
elif abs(N-M)==1:
	ans=1
else:
	ans=0

#を求める
for i in range(1,N+1):
	ans*=i
	ans%=INF+7
for i in range(1,M+1):
	ans*=i
	ans%=INF+7
print(ans)