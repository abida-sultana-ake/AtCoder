import math
n = int(input())

li = []
subli = []
for i in range(n):
    a = input()
    li.append(a)
    subli.append(a)

ansli = []

for i in range(n):
    for j in range(n):
        if i != j:
            a, b = map(int, li[i].split())
            c, d = map(int, subli[j].split())
            ans = abs(a-c) ** 2 + abs(b-d) ** 2
            ansli.append(ans)

target = math.sqrt(max(ansli))
print(target)
