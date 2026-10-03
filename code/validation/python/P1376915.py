import sys
import math

def fact(n, modulus):
    ans=1
    for i in range(1,n+1):
        ans = ans * i % modulus    
    return ans % modulus

arr=[]
arr =(input().split())

n = int(arr[0])
m = int(arr[1])

modulus = 1000000007

if abs(n-m)>1 :
    print(0)
elif n==m:
    ans = (fact(n,modulus)*fact(m,modulus))%modulus
    ans = ans+ans
    if ans > modulus:
        ans-=modulus
    print(ans)
else:
    print( (fact(n,modulus)*fact(m,modulus))%modulus)
    