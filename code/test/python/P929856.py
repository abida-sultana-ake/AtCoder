a = input().split()
s = {a[0]}
for i in a:
    s |= {i}
print(len(s))
