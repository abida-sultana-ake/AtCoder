import math

y = int(input())
m = int(input())
d = int(input())

def solve(y, m, d):
    y = (365*y) + math.floor(y / 4) - math.floor(y /100) + math.floor(y / 400)
    m = math.floor((306 * (m+1)) / 10)
    ans = y + m + d - 429
    return ans

if m == 1 or m == 2:
    y -= 1
    m += 12

print(abs(solve(y, m, d) - 735369))
