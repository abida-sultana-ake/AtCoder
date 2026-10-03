n, x = map(int,input().split())
print(n-x if n-x < x-1 else x-1)