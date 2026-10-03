x_a, y_a, x_b, y_b, x_c, y_c = map(int, input().split())

A = x_b - x_a
B = y_b - y_a
C = x_c - x_a
D = y_c - y_a


S = abs(A * D - B * C) / 2

print(S)