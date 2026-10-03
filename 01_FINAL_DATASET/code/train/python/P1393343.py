n = int(input())
a = input().split()
if n==1:
    print(a[0])
elif n%2==0:
    tmp=a[1::2][::-1] + a[0::2]
    print((" ").join(tmp))
else:
    tmp=a[2::2][::-1] + [a[0]]  +a[1::2]
    print((" ").join(tmp))
 