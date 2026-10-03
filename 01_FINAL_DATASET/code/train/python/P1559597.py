# D
N = int(input())
a_list = list(map(int, input().split()))

res = 0

i = 0
while i < N:
    if a_list[i] == i+1:
        res += 1
        i += 2
    else:
        i += 1
print(res)
