N=int(input())
W=[int(input()) for _ in [1]*N]
A=[[W[0]]]
for w in W[1::]:
    e=True
    for a in A:
        if a[::-1][0]>=w:
            a.append(w)
            e=False
            break
    if e:A.append([w])
print(len(A))