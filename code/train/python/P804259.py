K = int(input())
L = str(K * K)
R = str((K + 1) * (K + 1) - 1)

if len(L) != len(R):
    L = "0" + L
i1 = 0
while L[i1] == R[i1]:
    i1 += 1
i2 = len(L) - 1
while L[i2] == '0':
    i2 -= 1

for i in range((len(L) & 1) ^ 1, len(L), 2):
    if i >= i2:
        print(int(L[:i + 1]))
        break
    elif i >= i1:
        print(int(L[:i + 1]) + 1)
        break
