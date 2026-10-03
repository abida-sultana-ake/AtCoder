N, T = map(int, input().split())
t = list(map(int, input().split()))

ret = T
for i in range(len(t)-1):
    ret += min(t[i+1] - t[i], T)

print(ret)