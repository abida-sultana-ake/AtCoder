A, B, C, D = map(int, input().split())
if A * D < B * C:
    print('TAKAHASHI')
elif A * D > B * C:
    print('AOKI')
else:
    print('DRAW')
