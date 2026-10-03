import math
p = 1000000007
if __name__ == '__main__':
    n,m = list(map(int,input().split()))
    if n==m:
        print(((math.factorial(n)%p)*(math.factorial(n)%p)*2)%p)
    elif abs(n-m)==1:
        print((math.factorial(m)%p)*(math.factorial(n)%p)%p)
    else:
        print(0)
