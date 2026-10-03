n = int(input())
top = 1
a = []
for i in range(2, n + 1):
    print("? {0} {1}".format(top, i))
    a.append([i, int(input())])

a = max(a, key=lambda x: x[1])
top = a[0]

a = []
for i in range(1, n + 1):
    if i == top:
        continue
    print("? {0} {1}".format(top, i))
    a.append([i, int(input())])
a = max(a, key=lambda x: x[1])
print("! {}".format(a[1]))
