s = input()
x = s.split()
y = [0,0,0,0]
i = 0
for v in x:
    y[i] = int(v)
    i = i + 1
a1 = y[0] * y[1]
a2 = y[2] * y[3]
if a1 >= a2:
    print(a1)
else:
    print(a2)