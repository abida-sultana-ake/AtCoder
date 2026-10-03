S = (input())
T = (int(input()))

Rc = 0
Lc = 0
Uc = 0
Dc = 0
Qc = 0

for i in range(len(S)):
    if S[i] == "R":
        Rc += 1
    if S[i] == "L":
        Lc += 1
    if S[i] == "U":
        Uc += 1
    if S[i] == "D":
        Dc += 1
    if S[i] == "?":
        Qc += 1

C = abs(Rc - Lc) + abs(Uc - Dc)

if T == 1:
    print(C + Qc)
else:
    if C < Qc:
        print((Qc - C) % 2)
    else:
        print(C - Qc)


