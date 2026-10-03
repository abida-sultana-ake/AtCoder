tmp = [int(i) for i in input().split(' ')]
a = tmp[0]
b = tmp[1]
c = tmp[2]
print(min(a+b, b+c, c+a))