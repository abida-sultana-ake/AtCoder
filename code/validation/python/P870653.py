n = int(input())
k = int(input())
x = int(input())
y = int(input())

print( x * n if n < k else x * k + y * (n - k) )