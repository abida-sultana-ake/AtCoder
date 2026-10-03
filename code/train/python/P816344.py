N, L = map(int, input().split())
D = input().split()
ans = N
while 1:
    s = str(ans)
    f = 1
    for i in D:
        if i in s : f = 0
    if f : break
    ans += 1
print(ans)