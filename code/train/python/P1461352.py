a = input().split()
a = [int(e) for e in a]
a.sort()
print(a[int(len(a)/2)])
