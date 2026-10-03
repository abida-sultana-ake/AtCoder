INF=1000

N=int(input())
S=[]
for i in range(N):
	temp=input()
	S.append({})
	for j in temp:
		if j not in S[i]:
			S[i][j]=1
		else:
			S[i][j]+=1
#print(S)
ans={}
for i in range(97,97+26):
	ans[chr(i)]=INF

for i in range(97,97+26):
	temp=chr(i)
	for j in S:
		if temp not in j:
			ans[temp]=0
			continue
		else:
			ans[temp]=min(ans[temp],j[temp])
ansLine=""
for i in range(97,97+26):
	temp=chr(i)
	if ans[temp]!=0:
		ansLine+=temp*ans[temp]
print(ansLine)