def f(p):
    ans=1
    if p<=5:return 0
    for n in range(2,int(p**0.5)+1):
        if p%n==0:
            if n!=p//n:ans+=n+p//n
            else:ans+=n
    return ans

n=int(input())
m=f(n)
if n == m:print('Perfect')
else:print('Deficient' if n>m else 'Abundant')