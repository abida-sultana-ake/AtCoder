def read():
    return map(int, input().split())
H1, W1 = read()
H2, W2 = read()
if H1 == H2 or W1 == W2 or H1 == W2 or W1 == H2:
    print('YES')
else:
    print('NO')