n = int(input())
li = [0] * 1000002

for i in range(n):
    a, b = map(int, input().split())
    li[a] += 1
    li[b+1] -= 1

for j in range(1, 1000001):
    li[j] += li[j-1]

print(max(li[:1000001]))