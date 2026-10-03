n = int(input())
a = 0
for i in range(1,10):
    for j in range(1,10):
        a = a + i*j
s = a - n

for i in range(1,10):
    for j in range(1,10):
        if s == i * j:
            print(str(i)+" x "+str(j))