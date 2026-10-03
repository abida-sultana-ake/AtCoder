def read(): return list(map(int, input().split()))


n = int(input())
a = read()

c = [0 for i in range(9)]
for i in a:
    if 1 <= i <= 399:
        c[0] = 1
    elif 400 <= i <= 799:
        c[1] = 1
    elif 800 <= i <= 1199:
        c[2] = 1
    elif 1200 <= i <= 1599:
        c[3] = 1
    elif 1600 <= i <= 1999:
        c[4] = 1
    elif 2000 <= i <= 2399:
        c[5] = 1
    elif 2400 <= i <= 2799:
        c[6] = 1
    elif 2800 <= i <= 3199:
        c[7] = 1
    else:
        c[8] += 1

s = sum(c[:8])
mini = 1 if s < 1 else s
maxi = s + c[8]
print("{} {}".format(mini, maxi))
