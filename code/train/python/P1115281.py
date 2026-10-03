n, m = list(map(int, input().split()))

x = min(n,  m//2)
r = m - 2 * x
print(x + r // 4)