n=int(input())
if n<=2: print(0)
elif n==3: print(1)
else:
  a=0
  b=0
  c=1
  d=1
  for i in range(n-4):
    a=b
    b=c
    c=d
    d=(a+b+c)%10007
  print(d)