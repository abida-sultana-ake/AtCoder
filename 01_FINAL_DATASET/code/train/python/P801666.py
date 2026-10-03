def f(x):
    return (x + 99) // 100

a = int(input())
a, b = a ** 2, (a + 1) ** 2

while f(a) != f(b):
    a, b = f(a), f(b)

print(a)
