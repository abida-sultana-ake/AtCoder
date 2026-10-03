N = int(input())

res = [0] * 1000001
for i in range(N):
    a, b = [int(_) for _ in input().split()]
    res[a] = res[a] + 1
    if b+1 != len(res):
        res[b+1] = res[b+1] - 1

sum = 0
for index, x in enumerate(res):
    sum = sum + x
    res[index] = sum

print(max(res))
