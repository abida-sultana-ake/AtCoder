n = int(input())
s = list(map(int, input().split()))
res = 0
last = 0
accu = 0
for i in s:
    if i > last:
        accu += 1
    else:
        accu = 1
    last = i
    res += accu
print(res)
