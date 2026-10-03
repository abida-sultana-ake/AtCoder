O = input()
E = input()

S = ''
for i in range(len(O)):
    S += O[i]
    if len(E) > i:
        S += E[i]

print(S)