import itertools
s=sorted(input())
n=int(input())
print(*list(itertools.product(s,repeat=2))[n-1],sep='')