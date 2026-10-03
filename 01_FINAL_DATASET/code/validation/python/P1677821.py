n = int(input())
k = int(input())
mod = 10**9+7
r = 1
for i in range(k):
    r = r * (n+k-1-i)*pow(i+1,mod-2,mod)%mod
print(r)
