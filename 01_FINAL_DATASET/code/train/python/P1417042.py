N = int(input())
m = list(map(int, input().split()))
l = len(m)
count = 0
for i in range(l):
    a = m[i] % 2 # 2 4 6 8
    b = m[i] % 3 # 2 5 8
    if m[i] == 6:
        count += 3
    elif m[i] == 5:
        count += 2
    elif a == 0:
        count += 1
print(count)
