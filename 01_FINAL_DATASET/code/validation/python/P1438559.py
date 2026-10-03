n = int(input())
a = list(map(int, input().split()))
b = set()
for v in a:
    while v % 2 == 0:
        v //= 2
    b.add(v)
print(len(b))