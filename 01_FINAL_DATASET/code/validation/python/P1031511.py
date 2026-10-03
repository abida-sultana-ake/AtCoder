n=int(input())
a=list(map(int,input().split()))
if n%2==0:
	sta=[1,1]
	s=3
else:
	sta=[0]
	s=2

for i in range(s,n)[::2]:
	sta.append(i)
	sta.append(i)

if sorted(sta)!=sorted(a):
	print(0)
	exit()

i=int(n/2)
print(pow(2,i,10**9+7))