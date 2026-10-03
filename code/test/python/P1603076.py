A,B,C,D,E,F = list(map(int,input().split()))
A = 100*A
B = 100*B

a = int(F/A)
b = int(F/B)

hoge = 0

water = [[0 for i in range(a+1)]for i in range(b+1)]
sugar = [[0 for i in range(a+1)]for i in range(b+1)]

noudo = [[0 for i in range(a+1)]for i in range(b+1)]

for i in range(a+1):
    for j in range(b+1):
        if A*i+B*j < F:
            water[j][i] = A*i+B*j
       


        c = int(E*water[j][i]/(100*C))
        d = int(E*water[j][i]/(100*D))
        for k in range(c+1):
            for m in range(d+1):
                if C*k+D*m <= F-water[j][i]  and C*k+D*m <= E*water[j][i]/100:
                    sugar[j][i] = max(sugar[j][i],C*k+D*m)

for i in range(a+1):
    for j in range(b+1):
        if water[j][i] != 0 and sugar[j][i] != 0:
            noudo[j][i] = sugar[j][i]/(water[j][i]+sugar[j][i])
        if hoge <= noudo[j][i]:
            res_i = i
            res_j = j
            hoge = noudo[j][i]

print(water[res_j][res_i]+sugar[res_j][res_i],sugar[res_j][res_i])

