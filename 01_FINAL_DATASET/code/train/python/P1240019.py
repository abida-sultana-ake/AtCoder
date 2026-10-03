n = list(map(int, input().split()))

a = n[0]
b = n[1]
c = n[2]

x = (a * b) * 2
y = (b * c) * 2
z = (c * a) * 2

print(x + y + z)