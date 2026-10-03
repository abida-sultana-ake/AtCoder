temp=input().split()
H=int(temp[0])
W=int(temp[1])

INF=10000000000
ans=INF
#超特殊例
if H%3==0 or W%3==0:
	ans=0
ans=min(ans,H,W)
#横長がある場合
for i in range(H):
	S1=W*i
	S2=int(W/2)*(H-i)
	S3=(W-int(W/2))*(H-i)
	if max(S1,S2,S3)-min(S1,S2,S3)<ans:
		ans=max(S1,S2,S3)-min(S1,S2,S3)
for i in range(W):
	S1=H*i
	S2=int(H/2)*(W-i)
	S3=(H-int(H/2))*(W-i)
	if max(S1,S2,S3)-min(S1,S2,S3)<ans:
		ans=max(S1,S2,S3)-min(S1,S2,S3)
print(ans)