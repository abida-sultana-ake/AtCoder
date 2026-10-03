x = int(input())

sho = x // 11
ama = x % 11

count = 2 * sho
if 0 < ama < 11 :
    if ama > 6:
        count += 2
    else:
        count += 1

print(count)
