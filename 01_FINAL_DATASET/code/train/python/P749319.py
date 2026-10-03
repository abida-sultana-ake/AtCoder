a, b, c = input().split()
a, b, c = int(a), int(b), int(c)
count = 0
if a < b:
    kau = a
else:
    kau = b

while c >= kau:
    c -= kau
    count += 1

print(count)
