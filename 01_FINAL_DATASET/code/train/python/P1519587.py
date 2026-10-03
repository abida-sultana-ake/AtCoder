N, L = map(int, input().split())

li = list(input())
num = 1
count = 0

for i in range(N):
    if li[i] == "+":
        num += 1
    else:
        num -= 1
    if num > L:
        count += 1
        num = 1
print(count)
