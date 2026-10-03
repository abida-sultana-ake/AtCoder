from math import fabs
n, m = map(int, input().split())
n %= 12
ans = fabs(n*30 + 0.5*m - 6*m)
print(min(ans,fabs(360-ans)))