k=int(input())
a=1
b=3
for i in range(k-1):
    s=a+b
    a=b
    b=s
print(b,a)