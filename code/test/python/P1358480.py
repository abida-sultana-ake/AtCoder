n, x = [int(i) for i in input().split()]

if x <= int(n/2):
    print(x-1)
else:
    print(n-x)