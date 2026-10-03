import math
def nCr(n,r):
    f = math.factorial
    return f(n) // f(r) // f(n-r)
r, c = map(int, input().split())
x, y = map(int, input().split())
d, l = map(int, input().split())
# 区画の場所の場合の数
a = (r-x+1)*(c-y+1)
# 配置の組み合わせ
b = nCr(x*y,d+l) * nCr(d+l,l)
# 一辺空き
if x > 1 and (x-1)*y >= d+l:
    b -= nCr((x-1)*y,d+l) * nCr(d+l,l) * 2
if y > 1 and x*(y-1) >= d+l:
    b -= nCr(x*(y-1),d+l) * nCr(d+l,l) * 2
# 二辺空き
if x > 2 and (x-2)*y >= d+l:
    b += nCr((x-2)*y,d+l) * nCr(d+l,l)
if y > 2 and x*(y-2) >= d+l:
    b += nCr(x*(y-2),d+l) * nCr(d+l,l)
if x > 1 and y > 1 and (x-1)*(y-1) >= d+l:
    b += nCr((x-1)*(y-1),d+l) * nCr(d+l,l) * 4
# 三辺空き
if x > 2 and y > 1 and (x-2)*(y-1) >= d+l:
    b -= nCr((x-2)*(y-1),d+l) * nCr(d+l,l) * 2
if x > 1 and y > 2 and (x-1)*(y-2) >= d+l:
    b -= nCr((x-1)*(y-2),d+l) * nCr(d+l,l) * 2
# 四辺空き
if x > 2 and y > 2 and (x-2)*(y-2) >= d+l:
    b += nCr((x-2)*(y-2),d+l) * nCr(d+l,l)
print(a*b%1000000007)
