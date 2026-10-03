import sys

data=[int(n) for n in sys.stdin.readline().strip().split(" ") ]
l=data[1]-1
r=data[0]-data[1]

print( l if l<=r else r )