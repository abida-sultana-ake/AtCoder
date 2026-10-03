n = int(input())
a = [int(num) for num in input().split()]

a.sort()
count = []
for i in range(100001 + 1):
    count.append(0)

for num in a:
    count[num] += 1

max = 0
for i in range(1, 100001):
    res = count[i - 1] + count[i] + count[i + 1]
    if (res > max):
        max = res

print(max)