S = input()

for s, rs in zip(S, S[::-1]):
    if s != '*' and rs != '*' and s != rs:
        print('NO')
        exit()
print('YES')