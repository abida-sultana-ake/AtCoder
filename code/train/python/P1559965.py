n = int(input())
p = [int(num) for num in input().split()]

flag = []
for i in range(n):
    flag.append(False)

for i in range(n):
    if p[i] == i + 1:
        flag[i] = True

count = 0
i = 0
while i < n:
    if flag[i]:
        count += 1
        i += 1
    i += 1

print(count)