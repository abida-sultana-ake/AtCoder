c = int(input())
maxs = [0, 0, 0]
for i in range(c):
    a = list(map(int, input().split()))
    a.sort()
    for i in range(3):
        maxs[i] = max(maxs[i], a[i])
print(maxs[0] * maxs[1] * maxs[2])
