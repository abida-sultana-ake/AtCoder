N = int(input())
m = [tuple(map(int, input().split(' '))) for i in range(N)]
d = list(filter(lambda x: x[0] - x[1] < 0, m))
u = list(filter(lambda x: x[0] - x[1] >= 0, m))
d.sort(key=lambda x: x[0])
u.sort(key=lambda x: x[1], reverse=True)
ans = ct = 0
d.extend(u)
for tm in d:
    ct += tm[0]
    if ans < ct:
        ans = ct
    ct -= tm[1]
print(ans)