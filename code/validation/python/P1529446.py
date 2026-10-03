N = int(input())						# 5
a = list(input())
#b = [int(i) for i in input().split()]	# 1 2 3 4 5 ...

MOD = 1000000007

if N==1:
	print(3)
	exit(0)




b=[]
bSkip = False

for i in range(N):
	if bSkip:
		bSkip = False
		continue
	if i==N-1:
		b.append(1)
	else:
		if a[i] == a[i+1]:
			b.append(2)
			bSkip = True
		else:
			b.append(1)

#print(b)


if b[0]==1:
	ans = 3
else:
	ans = 6


for i in range(1, len(b)):
	if b[i-1]==1:
		ans = (ans * 2) % MOD
	else:
		if b[i]==2:
			ans = (ans * 3) % MOD


print(ans % MOD)
