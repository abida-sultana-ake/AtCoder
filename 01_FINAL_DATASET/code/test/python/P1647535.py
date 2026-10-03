n = int(input())
d = dict()
for _ in range(n):
    t = input()
    if t in d:
        d[t] += 1
    else:
        d[t] = 1
ret = sorted(d.items(), key = lambda x: x[1])
print(ret[-1][0])
