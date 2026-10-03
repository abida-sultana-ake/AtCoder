n = 2025 - int(input())
ans = []
for i in range(1, 10):
    for j in range(1, 10):
        if i * j == n:
            ans.append((i, j))
for i, j in ans:
    print("{0} x {1}".format(i, j))
