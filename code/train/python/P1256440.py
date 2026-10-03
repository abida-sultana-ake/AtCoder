# -*- coding:utf-8 -*-
n, m = map(int, input().split())
n %= 12
degree1 = 360//12
degree3 = 360//60
degree2 = degree3/(60//5)
ans = abs(degree1*n+degree2*m-degree3*m)
ans = min(ans,(360-ans))
print(ans)