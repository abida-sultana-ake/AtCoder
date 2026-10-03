n=int(input())
m=[]
for i in range(n):
    m.append(input())

for i in range(n):
    s = ''
    for j in reversed(range(n)):
        s += m[j][i]
    print(s)