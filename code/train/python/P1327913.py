N = int(input())

s_min = 200
sum = 0
for _ in range(N):
    s_i = int(input())
    sum += s_i
    if s_i % 10 != 0:
        if s_min > s_i:
            s_min = s_i


if sum % 10 != 0:
    print(sum)
else:
    if s_min == 200:
        print(0)
    else:
        print(sum - s_min)
