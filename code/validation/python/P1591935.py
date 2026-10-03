def solve(n,k,a,t):
    for i in range(k):
        xor = t ^ a[n][i]
        if n == 0:
            if xor == 0:
                return True
        else:
            if solve(n-1,k,a,xor):
                return True
    return False
n,k = map(int,input().split())
A = [[int(i)for i in input().split()]for _ in range(n)]
if solve(n-1,k,A,0):
    print('Found')
else:
    print('Nothing')