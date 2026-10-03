ret = 0
for _ in range(3):
    a,b = map(int,input().split())
    ret += a*b//10
print(ret)