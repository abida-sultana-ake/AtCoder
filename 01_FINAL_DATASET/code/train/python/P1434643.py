n, m = map(int, input().split())

for x in range(n+1):
    z = m - 3 * n + x
    if z >= 0 and x + z <= n:
        y = n - x - z
        break
    elif x == n:
        x, y, z = -1, -1, -1

print(str(x)+' '+str(y)+' '+str(z))