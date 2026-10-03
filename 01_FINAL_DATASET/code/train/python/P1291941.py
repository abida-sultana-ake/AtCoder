N = int(input())
unders = [[] for i in range(N+1)]

def func(n):
    if len(unders[n]) == 0:
        return 1

    l = []
    for m in unders[n]:
        l.append(func(m))
    return min(l) + max(l) + 1

for i in range(2,N+1):
    b = int(input())
    unders[b].append(i)

print(func(1))