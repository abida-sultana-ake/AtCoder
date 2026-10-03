def read():
    return map(int, input().split())

n = int(input())
x = list(read())
minlast1 = abs(x[1] - x[0])
minlast2 = 0

for i in range(2, n):
    minlast2, minlast1 = minlast1, min(
        abs(x[i] - x[i - 1]) + minlast1, abs(x[i] - x[i - 2]) + minlast2)

print(minlast1)
