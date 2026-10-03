A = str(input())
B = str(input())
C = [A[i]+B[i] for i in range(len(B))]

if len(A) > len(B):
    C.append(A[-1])
else:
    pass

C_str = "".join(C)

print(C_str)