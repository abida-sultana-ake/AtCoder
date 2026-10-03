# -*- coding:utf-8 -*-
A, B = map(int, input().split())
a1 = list(str(A))
a1[0] = '9'
a2 = list(str(A))
a2[1] = '9'
a3 = list(str(A))
a3[2] = '9'
a1 = int(''.join(a1))
a2 = int(''.join(a2))
a3 = int(''.join(a3))
b1 = list(str(B))
b1[0] = '1'
b2 = list(str(B))
b2[1] = '0'
b3 = list(str(B))
b3[2] = '0'
b1 = int(''.join(b1))
b2 = int(''.join(b2))
b3 = int(''.join(b3))

maximumA = max(a3, max(a1,a2))
minimumB = min(b3, min(b1,b2))
print(max(A-minimumB, max(A-B, maximumA-B)))