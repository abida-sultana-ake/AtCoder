N = int(input())

a = [0]*1000000

a[2]=1

for i in range(3,N):
        a[i] = a[i-1]+a[i-2]+a[i-3]
        a[i] = a[i]%10007

print(a[N-1])
