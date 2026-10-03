x = int(input())

a = (x//11)*2

if (x%11) == 0:
    b = 0
elif (x%11) <= 6:
    b = 1
else:
    b = 2

print(a + b)
