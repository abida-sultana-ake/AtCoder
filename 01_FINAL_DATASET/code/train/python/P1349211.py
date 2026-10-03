N=int(input())

a=input()
a=a.split()
for i in range(N):
    a[i]=int(a[i])

a=sorted(a)

print(a[N-1]-a[0])