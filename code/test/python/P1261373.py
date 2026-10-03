A,B,C=input().split()
last_A=A[-1]
first_B=B[0]
last_B=B[-1]
first_C=C[0]

if (last_A==first_B) and (last_B==first_C):
    print('YES')
else:
    print('NO')