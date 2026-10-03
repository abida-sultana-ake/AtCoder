import sys
MOD = 10007
n = int(input())
if n <= 2:
    print(0)
    sys.exit()

a = [0]*(n+1)
a[3] = 1
for i in range(4, n+1):
    a[i] = (a[i-1] + a[i-2] + a[i-3]) % MOD
print(a[n])