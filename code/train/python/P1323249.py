# C
N = int(input())
x_list = []
for _ in range(N):
    x_list.append(int(input()))

res = sum(x_list)

if res % 10 == 0:
    x_non10 = [x for x in x_list if x % 10 != 0]
    if len(x_non10) > 0:
        res -= min(x_non10)
    else:
        res = 0

print(res)