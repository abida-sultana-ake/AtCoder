a = int(input())
b = int(input())

if a < b:
    print(min(b - a, a - b + 10))
else:
    print(min(a - b, b + 10 - a))