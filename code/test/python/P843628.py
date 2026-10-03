n = int(input())
a = [int(i) for i in input().split(' ')]
ave = sum(a) / n
if (ave - int(ave)) < 0.5:
    ave = int(ave)
else:
    ave = int(ave) + 1
res = 0
for i in a:
    res += (i - ave)**2
print(res)