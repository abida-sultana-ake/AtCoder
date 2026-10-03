n = int(input())
a = [0]*n
b = [0]*n
for i in range(n):
    s,t = map(int,input().split())
    a[i] = s; b[i] = t+1
a.sort()
b.sort()
a.append(-1)
b.append(-1)
ai = bi = 0
tmp = ret = 0
for i in range(1000001):
    while a[ai] == i:
        tmp += 1
        ai += 1
    while b[bi] == i:
        tmp -= 1
        bi += 1
    ret = max(ret,tmp)
print(ret)
