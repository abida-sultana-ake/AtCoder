n = int(input())
a = [int(input()) for i in range(n)]

a.sort()

for i in range(n-1):
    if a[i] == a[i+1]:
        a[i] = 0
        a[i+1] = 0

print(len(a)-a.count(0))
