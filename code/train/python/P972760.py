S=input()

prev = S[0]
res=0
for i in range(1,len(S)):
	if S[i]!=prev:
		res+=1
		prev=S[i]

print(res)

