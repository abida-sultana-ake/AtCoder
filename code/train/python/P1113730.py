n=int(input())
for i in range(3,int(n**0.5)+1):
    if n%i==0 or n&1==0:print('NO');exit()
print('YES')