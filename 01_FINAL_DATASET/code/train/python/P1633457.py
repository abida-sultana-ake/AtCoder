N = int(input())
ans = 0
array = []
d = {}
for tmp in range(N):
    a = int(input())
    array.append(a)
    if a not in d:
        d[a] = 1
    else:
        d[a] += 1
array = list(set(array))
for tmp in range(len(array)):
    if d[array[tmp]]%2 == 1:
        ans += 1
    else:
        pass
print(ans)