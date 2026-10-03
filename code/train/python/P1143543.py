n=int(input())
s=[input() for i in range(n)]
r=sum(x.count('R') for x in s)-sum(x.count('B') for x in s)
print('TAKAHASHI' if r > 0 else 'AOKI' if r < 0 else 'DRAW')