N = int(input())
a = list(map(int, input().split()))
b = [0] * 100002
m = 0
for i in range(N):
    for j in range(3):
        b[a[i] + j] += 1
        if b[a[i] + j] > m:
            m = b[a[i] + j]
print(m)
