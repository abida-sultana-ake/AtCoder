a = int(input())
b = int(input())
c = int(input())
mod = 10**9+7
r = ((b*c-c*a)%mod * pow((a*b-b*c+c*a), mod-2, mod))%mod
c = ((b*c-b*a)%mod * pow((c*a-b*c+a*b), mod-2, mod))%mod
print(r,c)
