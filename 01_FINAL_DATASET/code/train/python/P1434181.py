xa, ya, xb, yb, xc, yc = map(int, input().split(' '))
B = [xb - xa, yb - ya]
C = [xc - xa, yc - ya]
print(abs(B[0] * C[1] - B[1] * C[0]) / 2)