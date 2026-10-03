N=int(input())

field=[list(input())]
field.append(list(input()))

M=1000000007

b=[field[0][0],field[1][0]]
if b[0]==b[1]:
    bdeffer=False
    count=3
else:
    bdeffer=True
    count=6

for j in range(1,len(field[0])):
    count=count%M
    a=[field[0][j],field[1][j]]

    if a[0]==b[0]:
        b=a
        if a[0]==a[1]:
            bdeffer=False
        else:
            bdeffer=True
        continue

    if a[0]==a[1]:
        if not bdeffer:
            count*=2
    else:
        if bdeffer:
            count*=3
        else:
            count*=2

    b=a[:]

    if a[0]==a[1]:
        bdeffer=False
    else:
        bdeffer=True

print(count%M)