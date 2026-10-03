L, R = map(int, input().split())
l = list(map(int, input().split()))
r = list(map(int, input().split()))
ret = 0

for i in range(1, 100):
    ret += min(l.count(i), r.count(i))
print(ret)
