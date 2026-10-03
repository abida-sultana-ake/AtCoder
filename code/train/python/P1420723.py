a, b, c = map(int, input().split(" "))

if a <= c and b <= c:
    print(a + b)
elif a <= b and c <= b:
    print(a + c)
elif b <= a and c <= a:
    print(b + c)
