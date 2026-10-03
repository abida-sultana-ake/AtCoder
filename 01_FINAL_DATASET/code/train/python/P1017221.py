a=int(input())
r = (a+1)*(a+1)-1
l = a*a
while (l+99)//100 <= r//100:
    l=(l+99)//100
    r=(r)//100
print(l)
