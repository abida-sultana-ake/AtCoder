n, q = [ int(x) for x in input().split()]
arr = [0 for i in range(n)]

for i in range(q):
    l, r, t = [int(x) for x in input().split()]
    for i in range(l-1, r):
        arr[i] = t


for i in arr:
    print(i)
