h,m=map(int,input().split())
if h>11:h-=12
s=l=.0
l=m*6
s=30*(h+(m/60))
if l<s:l,s=s,l
if l-s>180:d=360-l+s
else:d=l-s
print(d)