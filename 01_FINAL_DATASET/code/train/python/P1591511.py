import sys
N = int(input())
a = 2
while a*a <= N:
    if N%a == 0:
        print('NO')
        sys.exit()
    a += 1
print('YES')
