K = int(input())
x, y = 2, 1
for i in range(K-1):
    x, y = x+y, x
print(x, y)