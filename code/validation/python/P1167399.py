import sys

INF = 10**9+7

stdin = sys.stdin
def na(): return map(int, stdin.readline().split())
def nal(): return list(map(int, stdin.readline().split()))
def ns(): return stdin.readline().strip()
def nsl(): return list(stdin.readline().strip())
def ni(): return int(stdin.readline())

a, b = stdin.readline().strip().split(' ')

if(a == 'H'):
    print(b)
else:
    if(b == 'H'):
        print('D')
    else:
        print('H')
