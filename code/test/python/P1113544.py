n=int(input())
a = [0 for i in range(n)]
for i in range(n):
    a[i]=int(input())
a.sort()
print(a[0])