A, B = map(int, input().split())

A_A = list(str(A))
A_A[0] = 9
A_1 = "".join(map(str, A_A))
A_A = list(str(A))
A_A[1] = 9
A_2 = "".join(map(str, A_A))
A_A = list(str(A))
A_A[2] = 9
A_3 = "".join(map(str, A_A))

B_B = list(str(B))
B_B[0] = 1
B_1 = "".join(map(str, B_B))
B_B = list(str(B))
B_B[1] = 0
B_2 = "".join(map(str, B_B))
B_B = list(str(B))
B_B[2] = 0
B_3 = "".join(map(str, B_B))

ansA = max(int(A_1), int(A_2), int(A_3))
ansB = min(int(B_1), int(B_2), int(B_3))
C = (A-B)
D = ansA - B
E = A - ansB
print(max(C, D, E))
