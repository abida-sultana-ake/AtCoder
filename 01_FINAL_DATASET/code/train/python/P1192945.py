import copy
x = int(input())

m = 0

for i in range(1, x + 1):
    m += i
    if x <= m:
        print(i)
        break
