l = input().split()

for i in range(len(l)):
    l[i] = int(l[i])

w = l[0]    
a = l[1]
b = l[2]

if a + w < b:
    print(b - a - w)
elif b + w < a:
    print(a - b - w)
else:
    print(0)