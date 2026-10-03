from collections import Counter

N = int(input())
A = list(map(int, input().split()))
c_dict = Counter(A)
B = []
C = []

for k, v in c_dict.items():
    if v >= 4:
        B.append(k)
    elif v >= 2:
        C.append(k)
B.sort(reverse=True)
C.sort(reverse=True)

if len(B) < 1 and len(C) < 2:
    print(0)
elif len(B) < 1 and len(C) >= 2:
    F = C[1] * C[0]
    print(F)
elif len(B) >= 1 and len(C) == 1:
    D = B[0] ** 2
    E = C[0] * B[0]
    print(max(D, E))
elif len(B) >= 1 and len(C) >= 2:
    D = B[0] ** 2
    E = C[0] * B[0]
    F = C[1] * C[0]
    print(max(D, E, F))
