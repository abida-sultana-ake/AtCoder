n = int(input())
l = 0
for s in list(input()):
    c = ord(s)
    p = max(0, 69-c)
    l += p
print(l/n)