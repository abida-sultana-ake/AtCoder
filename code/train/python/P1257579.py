def gcd(a,b):
	if b==0:return a
	return gcd(b,a%b)

x,y=map(int,input().split('/'))
g=gcd(x,y)
x=x//g;y=y//g

l=0
r=1000000000000000000
while l!=r:
	t=(l+r)//2
	if r-l==1:t=r
	a=x*t;b=y*t
	c=(1+b)*b//2-a
	if c<1:l=t
	else:r=t-1

i=l+1
flag=False

while 1:
	a=x*i;b=y*i
	c=(1+b)*b//2-a
	if 1<=c and c<=b:
		flag=True
		print(b,c)
	if c>b:break
	i+=1
if not flag:print("Impossible")