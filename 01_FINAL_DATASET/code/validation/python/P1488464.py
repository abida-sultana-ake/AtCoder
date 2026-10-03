# Grid Coloring
H,W = list(map(int, input().split()))
N = int(input())
a = list(map(int, input().split()))

from itertools import chain
b = list(chain.from_iterable( [[i+1]*a[i] for i in range(N)] ))
#print(b)
c = [b[i*W:(i+1)*W] if i%2==0 else b[i*W:(i+1)*W][::-1] for i in range(H)]

for i in range(H):
    print(' '.join(map(str, c[i])))