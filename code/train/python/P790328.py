a, b, c = map(int, input().split())
mod = 1000000007
x = (a*b) % mod
x = (x*c) % mod
print(x)