n,x=[int(i) for i in input().split()]
a=[int(i) for i in input().split()]
value=0

b=bin(x)
c=b.replace("0b","")
d=c[::-1]

for i in range(len(d)):
    if d[i]=="1":
        value=value+a[i]
print(value)