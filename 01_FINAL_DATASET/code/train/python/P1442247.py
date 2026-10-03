a=int(input())
b=int(input())


c=a-b
d=b-a

if c>=5:
    c=10-c

elif d>=5:
    d=10-d

if c>d:
    print(c)

else:
    print(d)