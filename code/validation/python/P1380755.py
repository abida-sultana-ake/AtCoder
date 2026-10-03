import math
mode=1000000007


n,m=map(int,input().split())

if n==m:
    ans=math.factorial(n) % mode
    print(2*ans*ans % mode)
elif abs(n-m)==1:
    ans_n=math.factorial(n) % mode
    ans_m=math.factorial(m) % mode
    print(ans_n*ans_m % mode)
else:
    print(0)
