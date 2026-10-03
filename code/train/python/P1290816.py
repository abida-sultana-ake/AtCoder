A,B,C = map(int, input().split())
X = 0
for  k in range(B-1):
    if A * k % B == C:
         print('YES')
         X = 1
         break

if X == 0:
    print('NO')