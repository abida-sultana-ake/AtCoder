N = int(input())

s = []
for _ in range(N):
    s.append(int(input()))

all_sum = sum(s)
if all_sum % 10 != 0:
    print(all_sum)
else:
    s.sort()
    n = -1
    for i in s:
        if i % 10 != 0:
            n = i
            break
    if n != -1:
        print(all_sum - n)
    else:
        print(0)