a, b, c = map(int, input().split())

n = a*100 + b*10 + c

if n % 4 == 0:
    print('YES')
else:
    print('NO')