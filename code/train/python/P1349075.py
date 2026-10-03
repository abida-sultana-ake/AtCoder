n = int(input())
a1, a2, a3 = 0, 0, 1
for i in range(1,n):
    a1, a2, a3 = a2, a3, (a1 + a2 + a3) % 10007
print(a1)