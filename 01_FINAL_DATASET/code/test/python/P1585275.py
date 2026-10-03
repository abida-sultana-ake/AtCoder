N = int(input())
l = [0] * N
r = [0] * N
for i in range(N):
    l[i], r[i] = map(int, input().split())

count = [0] * N
for i in range(N):
    count[i] = r[i] - l[i] + 1

print(sum(count))
