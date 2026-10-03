from collections import Counter

n = int(input())
c = Counter(''.join(input().strip() for _ in range(n)))

if c['R'] > c['B']:
    print('TAKAHASHI')
elif c['R'] < c['B']:
    print('AOKI')
else:
    print('DRAW')
