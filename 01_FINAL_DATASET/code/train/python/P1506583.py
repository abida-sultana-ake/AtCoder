def gcd(a, b):
    if b>a:
        a,b = b,a
    if b==0:
        return a
    return gcd(b, a%b)

N = int(input())
ret = 1
for i in range(N):
    hoge = int(input())
    ret = (ret * hoge)//gcd(ret, hoge)
print(ret)
