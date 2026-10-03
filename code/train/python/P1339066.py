n = int(input())
a = [int(input()) for i in range(n)]
a.sort()

print(a[a.index(max(a))-1])
