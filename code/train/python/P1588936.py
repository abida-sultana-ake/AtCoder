from sys import stdin
input = stdin.readline

to_middle = set()           #  島1から渡ることのできる島
from_middle = set()         #  島Nへ渡ることのできる島
N, M = map(int, (input().split()))
for _ in range(M):
    f, t = map(int, (input().split()))
    if f == 1:
        to_middle.add(t)
    elif t == N:
        from_middle.add(f)

if to_middle & from_middle:
    print('POSSIBLE')
else:
    print('IMPOSSIBLE')
