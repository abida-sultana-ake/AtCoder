x = (int(input()))

x-=1

a=0
b=0
c=1
for i in range(x):
    a,b,c = b,c,(a+b+c)%10007
print(a)