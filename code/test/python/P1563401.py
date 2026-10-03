N = int(input())
c = 0
ind = []
p = 0

for i,v in enumerate(input().split()):
    i = i+1
    if i == int(v):
        c += 1
        ind.append(i)

if len(ind) >= 3:
    i = 1
    while i <= len(ind) - 1:
        if ind[i-1]+1 == ind[i]:
            p+=1
            i += 2
        elif (i+1) <= (len(ind) - 1) and ind[i] + 1 == ind[i+1]:
            p += 1
            i += 3
        else:
            i += 1
elif len(ind) == 2 and ind[0] +1 == ind[1]:
    p += 1

if c == 0:
    print(0)
elif p == 0:
    print(c)
else:
    print(c-p)
